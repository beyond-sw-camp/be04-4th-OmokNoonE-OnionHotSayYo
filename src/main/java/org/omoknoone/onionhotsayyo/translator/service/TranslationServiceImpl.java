package org.omoknoone.onionhotsayyo.translator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.omoknoone.onionhotsayyo.post.dto.HeaderSearchInfoDTO;
import org.omoknoone.onionhotsayyo.translator.aggregate.Translation;
import org.omoknoone.onionhotsayyo.translator.common.LanguageNameMapper;
import org.omoknoone.onionhotsayyo.translator.dto.TranslatedTextDTO;
import org.omoknoone.onionhotsayyo.translator.dto.TranslationDTO;
import org.omoknoone.onionhotsayyo.translator.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TranslationServiceImpl implements TranslationService {

    private final Environment environment;
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;
    private final String BASE_URL = "https://api-free.deepl.com/v2";
    private final TranslationRepository translationRepository;
    private final LanguageNameMapper languageNameMapper;

    @Autowired
    public TranslationServiceImpl(Environment environment, ObjectMapper objectMapper, ModelMapper modelMapper,
        TranslationRepository translationRepository, LanguageNameMapper languageNameMapper) {
        this.environment = environment;
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.translationRepository = translationRepository;
        this.languageNameMapper = languageNameMapper;
    }

    @Override
    public List<TranslationDTO> translate(List<TranslationDTO> translationDTOList) {

        /* 이미 번역 된 글 제외 전처리 */
        Map<String, List<TranslationDTO>> translationMap = excludeExistTranslatedPost(translationDTOList);

        // 이미 번역본이 존재하는 게시글 목록
        List<TranslationDTO> translatedPostList = translationMap.get("translatedPostList");

        List<TranslationDTO> translateAPIDTO = new ArrayList<>();

        if (!translationMap.get("untranslatedPostList").isEmpty()) { // 번역할 게시글이 있다면

            // 번역 진행해야할 게시글 목록
            List<TranslationDTO> untranslatedPostList = translationMap.get("untranslatedPostList");

            /* API 통신 객체 */
            RestTemplate restTemplate = new RestTemplate();

            /* header set */
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            String auth = "DeepL-Auth-Key " + environment.getProperty("deepl.api-key");
            httpHeaders.set("Authorization", auth);

            /* body set */
            String targetLang = translationDTOList.get(0).getLanguage();

            // 게시글 번호를 순서대로 가지고 있기 위한 List
            List<Integer> postIdList = new ArrayList<>();

            // API 통신을 위한 Map
            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            for (TranslationDTO translationDTO : untranslatedPostList) {
                postIdList.add(translationDTO.getPostId());
                String originalTitle = translationDTO.getTitle();
                String originalContent = translationDTO.getContent();

                // 제목 저장
                body.add("target_lang", targetLang);
                body.add("text", originalTitle);

                // 내용 저장
                body.add("target_lang", targetLang);
                body.add("text", originalContent);
            }

            /* message */
            HttpEntity<?> requestMessage = new HttpEntity<>(body, httpHeaders);

            /* Request */
            HttpEntity<String> response = restTemplate.postForEntity(
                BASE_URL + "/translate",
                requestMessage,
                String.class);

            /* 응답 결과 저장 */
            JsonNode rootNode = null;

            try {
                rootNode = objectMapper.readTree(response.getBody());
                JsonNode translationsNode = rootNode.get("translations");
                if (translationsNode.isArray()) {
                    int postId = 0;
                    String title = "";
                    String content = "";
                    String language = languageNameMapper.getLanguageName(targetLang);
                    TranslationDTO translationDTO = null;

                    int j = 0;
                    for (int i = 0; i < translationsNode.size(); i++) {
                        if (i % 2 == 0) {        // 제목 번역
                            postId = postIdList.get(j);
                            title = translationsNode.get(i).get("text").asText();
                            translationDTO = new TranslationDTO(postId, language, title);
                        } else {                 // 본문 번역
                            content = translationsNode.get(i).get("text").asText();
                            translationDTO.setContent(content);
                            translateAPIDTO.add(translationDTO);
                            j++;
                        }
                    }
                    /* 번역 완료된 글 DB에 저장 */
                    saveTranslatedText(translateAPIDTO);
                    // 이미 있는 번역된 글과 방금 번역한 글 병합
                    translatedPostList.addAll(translateAPIDTO);
                }
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }

        return translatedPostList;
    }

    @Override
    public TranslatedTextDTO translateKeyword(HeaderSearchInfoDTO searchInfo) {

        String translatedText = "[" + searchInfo.getTitle() + "] 번역되지 않음";

        /* API 통신 객체 */
        RestTemplate restTemplate = new RestTemplate();

        /* header set */
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String auth = "DeepL-Auth-Key " + environment.getProperty("deepl.api-key");
        httpHeaders.set("Authorization", auth);

        // API 통신을 위한 Map
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("target_lang", searchInfo.getLanguage());
        body.add("text", searchInfo.getTitle());

        /* message */
        HttpEntity<?> requestMessage = new HttpEntity<>(body, httpHeaders);

        /* Request */
        HttpEntity<String> response = restTemplate.postForEntity(
            BASE_URL + "/translate",
            requestMessage,
            String.class);

        /* 응답 결과 저장 */
        JsonNode rootNode = null;

        try {
            rootNode = objectMapper.readTree(response.getBody());
            JsonNode translationsNode = rootNode.get("translations");
            if (!translationsNode.isEmpty()) {

                translatedText = translationsNode.get(0).get("text").asText();
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new TranslatedTextDTO(searchInfo.getLanguage(), translatedText);
    }

    /* 번역 요청 들어온 글의 ID를 찾아서 제외 (게시글의 경우에만) */
    private Map<String, List<TranslationDTO>> excludeExistTranslatedPost(List<TranslationDTO> translationDTOList) {

        // 번역본에서 찾을 게시글 id 목록
        List<Integer> excludePostIds = new ArrayList<>();

        for (TranslationDTO translationDTO : translationDTOList) {
            excludePostIds.add(translationDTO.getPostId());
        }

        List<Translation> translatedExistList = null;

        // 게시글 id가 있다면 (댓글인 경우에는 postId가 없으므로)
        if (!excludePostIds.isEmpty()) {
            translatedExistList = translationRepository.findAllByPostIdAndLanguage(
                excludePostIds, translationDTOList.get(0).getLanguage());
        }

        Map<String, List<TranslationDTO>> resultMap = new HashMap<>();

        // 번역된 게시글 ID 제외하기
        if (translatedExistList != null && !translatedExistList.isEmpty()) {
            List<Integer> translatedPostIds = new ArrayList<>();
            for (Translation translation : translatedExistList) {
                translatedPostIds.add(translation.getPostId());
            }

            // 아직 번역되지 않은 게시글 필터링
            List<TranslationDTO> untranslatedPostList = new ArrayList<>();
            for (TranslationDTO translationDTO : translationDTOList) {
                if (!translatedPostIds.contains(translationDTO.getPostId())) {     // 번역된 게시글이 없으면
                    untranslatedPostList.add(translationDTO);                         // 번역안된 게시글 목록에 추가
                }
            }

            // Translation -> TranslationDTO
            List<TranslationDTO> translatedPostList =
                modelMapper.map(translatedExistList, new TypeToken<List<TranslationDTO>>() {
                }.getType());

            // 번역된 게시글과 번역안된 게시글 목록을 Map 형태로 전달
            resultMap.put("translatedPostList", translatedPostList);
            resultMap.put("untranslatedPostList", untranslatedPostList);

            return resultMap;
        }

        resultMap.put("untranslatedPostList", translationDTOList);

        return resultMap; // 번역된 게시글이 없으면 모든 게시글을 반환
    }

    /* 번역 완료된 글을 Translation DB에 저장 */
    private void saveTranslatedText(List<TranslationDTO> translatedTextList) {
        // 매개변수를 Translation Entity에 맞게 수정 (TranslateTextDTO -> Translation)
        List<Translation> translationList =
            modelMapper.map(translatedTextList, new TypeToken<List<Translation>>() {
            }.getType());

        // 수정된 목록은 repo.save()를 통해 저장
        translationRepository.saveAll(translationList);
    }

}
