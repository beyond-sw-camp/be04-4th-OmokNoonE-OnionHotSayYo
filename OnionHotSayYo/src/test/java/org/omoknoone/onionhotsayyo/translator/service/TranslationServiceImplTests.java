package org.omoknoone.onionhotsayyo.translator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.omoknoone.onionhotsayyo.translator.dto.TranslationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TranslationServiceImplTests {

    @Autowired
    private TranslationService translationService;

    @Test
    void testTranslate() {

        String originalText1 = "Hello, world!";
        String sourceLang1 = "EN";
        String targetLang1 = "KO";

        String originalText2 = "What's your name?";
        String sourceLang2 = null;
        String targetLang2 = "KO";

        List<TranslationDTO> translationDTOList = new ArrayList<>();
        TranslationDTO translationDTO1 = new TranslationDTO();
        translationDTO1.setOriginalText(originalText1);
        translationDTO1.setSourceLang(sourceLang1);
        translationDTO1.setTargetLang(targetLang1);
        translationDTOList.add(translationDTO1);

        TranslationDTO translationDTO2 = new TranslationDTO();
        translationDTO2.setOriginalText(originalText2);
        translationDTO2.setSourceLang(sourceLang2);
        translationDTO2.setTargetLang(targetLang2);
        translationDTOList.add(translationDTO2);

        List<TranslationDTO> translatedResult  = null;
        translatedResult = translationService.translate(translationDTOList);

        // 테스트 결과 확인
        System.out.println("Translated Text: " + translatedResult);
    }
}