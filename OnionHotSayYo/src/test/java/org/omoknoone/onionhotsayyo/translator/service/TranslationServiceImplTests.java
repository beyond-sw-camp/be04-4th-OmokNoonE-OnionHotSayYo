package org.omoknoone.onionhotsayyo.translator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.omoknoone.onionhotsayyo.translator.dto.TranslationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TranslationServiceImplTests {

    @Autowired
    private TranslationService translationService;

    @Test
    void testTranslate() {

        String originalText = "Hello, world!";
        String sourceLang = "EN";
//        String sourceLang = null;
        String targetLang = "KO";

        TranslationDTO translationDTO = new TranslationDTO(sourceLang, targetLang, originalText);

        TranslationDTO translatedResult = null;
        translatedResult = translationService.translate(translationDTO);

        // 테스트 결과 확인
        // TODO. 테스트 코드 수정해야 함
//        System.out.println("Translated Text: " + translatedResult);
    }
}