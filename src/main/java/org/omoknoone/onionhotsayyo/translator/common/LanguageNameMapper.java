package org.omoknoone.onionhotsayyo.translator.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class LanguageNameMapper {

    private static final Map<String, String> languageMap = new HashMap<>();

    static {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // ClassPathResource를 사용하여 리소스 파일 읽기
            ClassPathResource resource = new ClassPathResource("languages.json");

            // JSON 파일의 내용을 ObjectMapper를 통해 읽기
            JsonNode rootNode = objectMapper.readTree(resource.getInputStream());

            // JSON 배열인지 확인
            if (rootNode.isArray()) {
                Iterator<JsonNode> elements = rootNode.elements();
                while (elements.hasNext()) {
                    JsonNode node = elements.next();
                    // language와 name을 languageMap에 추가
                    languageMap.put(node.get("language").asText(), node.get("name").asText());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(
                new File("src/main/resources/languages.json"));

            if (rootNode.isArray()) {
                Iterator<JsonNode> elements = rootNode.elements();
                while (elements.hasNext()) {
                    JsonNode node = elements.next();
                    languageMap.put(node.get("language").asText(), node.get("name").asText());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static String getLanguageName(String languageCode) {
        return languageMap.getOrDefault(languageCode, "Unknown");
    }
}
