package org.omoknoone.onionhotsayyo.translator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.omoknoone.onionhotsayyo.translator.aggregate.Translation;
import org.omoknoone.onionhotsayyo.translator.dto.TranslateTextDTO;
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
import java.util.List;

@Service
public class TranslationServiceImpl implements TranslationService {

    private final Environment environment;
    private final ObjectMapper objectMapper;
    private final String BASE_URL = "https://api-free.deepl.com/v2";
    private final TranslationRepository translationRepository;

    @Autowired
    public TranslationServiceImpl(Environment environment,
                                  ObjectMapper objectMapper,
                                  TranslationRepository translationRepository) {
        this.environment = environment;
        this.objectMapper = objectMapper;
        this.translationRepository = translationRepository;
    }

    @Override
    public List<TranslateTextDTO> translate(List<TranslateTextDTO> translateTextDTOList){

        /* 이미 번역 된 글 제외 전처리 */
        List<TranslateTextDTO> cleanedTranslateTextDTOList = excludeExistTranslatedPost(translateTextDTOList);

        /* API 통신 객체 */
        RestTemplate restTemplate = new RestTemplate();

        /* header set */
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String auth = "DeepL-Auth-Key " + environment.getProperty("deepl.api-key");
        httpHeaders.set("Authorization", auth);

        /* body set */
        String targetLang = cleanedTranslateTextDTOList.get(0).getTargetLang();

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        for (TranslateTextDTO translateTextDTO : cleanedTranslateTextDTOList) {
//            String sourceLang = translateTextDTO.getSourceLang();
            String originalText = translateTextDTO.getOriginalText();

//            body.add("source_lang", sourceLang);
            body.add("target_lang", targetLang);
            body.add("text", originalText);
        }

        /* message */
        HttpEntity<?> requestMessage = new HttpEntity<>(body, httpHeaders);

        /* Request */
        HttpEntity<String> response = restTemplate.postForEntity(BASE_URL + "/translate", requestMessage, String.class);

        System.out.println("[serviceImpl] responseDTO = " + response.getBody());

        /* 응답 결과 저장 */
        JsonNode rootNode = null;
        List<TranslateTextDTO> responseList = new ArrayList<>();
        try {
            rootNode = objectMapper.readTree(response.getBody());
            JsonNode translationsNode = rootNode.get("translations");
            if(translationsNode.isArray()) {
                for (JsonNode node : translationsNode) {
                    responseList.add(new TranslateTextDTO(
                            node.get("detected_source_language").asText(),
                            targetLang,
                            node.get("text").asText()));
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return responseList;
    }

    /* 번역 요청 들어온 글의 ID를 찾아서 제외 (게시글의 경우에만) */
    public List<TranslateTextDTO> excludeExistTranslatedPost(List<TranslateTextDTO> translateTextDTOList) {

        // 번역본에서 찾을 게시글 id 목록
        List<Integer> excludePostIds = new ArrayList<>();

        for (TranslateTextDTO translateTextDTO : translateTextDTOList) {
            excludePostIds.add(translateTextDTO.getPostingId());
        }

        List<Translation> translationExistList = null;

        System.out.println("excludePostIds = " + excludePostIds);
        System.out.println("translateTextDTOList.toString() = " + translateTextDTOList.toString());
        // 게시글 id가 있다면 (댓글인 경우에는 postingId가 없으므로)
        if(!excludePostIds.isEmpty()) {
            translationExistList = translationRepository.findAllByPostingIdAndLanguage(
                                                        excludePostIds, translateTextDTOList.get(0).getTargetLang());
        }

        // 번역된 게시글 ID 제외하기
        if (translationExistList != null && !translationExistList.isEmpty()) {
            List<Integer> translatedPostIds = new ArrayList<>();
            for (Translation translation : translationExistList) {
                translatedPostIds.add(translation.getPostingId());
            }

            // 아직 번역되지 않은 게시글 필터링
            List<TranslateTextDTO> untranslatedPostList = new ArrayList<>();
            for (TranslateTextDTO translateTextDTO : translateTextDTOList) {
                if (!translatedPostIds.contains(translateTextDTO.getPostingId())) {     // 번역된 게시글이 없으면
                    untranslatedPostList.add(translateTextDTO);                         // 번역안된 게시글 목록에 추가
                }
            }
            return untranslatedPostList;
        }

        return translateTextDTOList; // 번역된 게시글이 없으면 모든 게시글을 반환
    }

}
