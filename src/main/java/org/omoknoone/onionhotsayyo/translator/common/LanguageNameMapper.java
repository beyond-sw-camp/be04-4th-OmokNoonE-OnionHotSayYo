package org.omoknoone.onionhotsayyo.translator.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import org.springframework.stereotype.Component;

@Component
public class LanguageNameMapper {

    private static final Map<String, String> languageMap = new HashMap<>();

    static {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(
                new File("src/main/java/org/omoknoone/onionhotsayyo/translator/data/languages.json"));

            if (rootNode.isArray()) {
                Iterator<JsonNode> elements = rootNode.elements();
                while (elements.hasNext()) {
                    JsonNode node = elements.next();
                    languageMap.put(node.get("language").asText(), node.get("name").asText());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getLanguageName(String languageCode) {
        return languageMap.getOrDefault(languageCode, "Unknown");
    }
}
