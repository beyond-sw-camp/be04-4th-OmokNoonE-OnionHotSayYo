package org.omoknoone.onionhotsayyo.translator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.omoknoone.onionhotsayyo.translator.dto.TranslationDTO;
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

    @Autowired
    public TranslationServiceImpl(Environment environment, ObjectMapper objectMapper) {
        this.environment = environment;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<TranslationDTO> translate(List<TranslationDTO> translationDTOList){

        /* API 통신 객체 */
        RestTemplate restTemplate = new RestTemplate();

        /* header set */
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String auth = "DeepL-Auth-Key " + environment.getProperty("deepl.api-key");
        httpHeaders.set("Authorization", auth);

        /* body set */
        String targetLang = translationDTOList.get(0).getTargetLang();

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        for (TranslationDTO translationDTO : translationDTOList) {
            String sourceLang = translationDTO.getSourceLang();
            String originalText = translationDTO.getOriginalText();

            body.add("source_lang", sourceLang);
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
        List<TranslationDTO> responseList = new ArrayList<>();
        try {
            rootNode = objectMapper.readTree(response.getBody());
            JsonNode translationsNode = rootNode.get("translations");
            if(translationsNode.isArray()) {
                for (JsonNode node : translationsNode) {
                    responseList.add(new TranslationDTO(node.get("detected_source_language").asText(),
                                                        targetLang,
                                                        node.get("text").asText()));
                }
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return responseList;
    }

}
