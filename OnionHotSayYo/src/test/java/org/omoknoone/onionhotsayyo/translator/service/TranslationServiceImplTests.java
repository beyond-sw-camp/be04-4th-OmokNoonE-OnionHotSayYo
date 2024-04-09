package org.omoknoone.onionhotsayyo.translator.service;

import org.junit.jupiter.api.Test;
import org.omoknoone.onionhotsayyo.translator.dto.TranslateTextDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TranslationServiceImplTests {

    @Autowired
    private TranslationService translationService;

    @Test
    void testTranslate() {

        int postingId1 = 1;
        String originalText1 = "Hello, world!";
        String targetLang1 = "KO";

        int postingId2 = 2;
        String originalText2 = "What's your name?";

        int postingId3 = 3;
        String originalText3 = "私は開発者です";

        int postingId4 = 4;
        String originalText4 = "Je suis développeur";

        int postingId5 = 5;
        String originalText5 = "What are you having for lunch?";

        List<TranslateTextDTO> translateTextDTOList = new ArrayList<>();
        TranslateTextDTO translateTextDTO1 = new TranslateTextDTO();
        translateTextDTO1.setPostingId(postingId1);
        translateTextDTO1.setOriginalText(originalText1);
        translateTextDTO1.setTargetLang(targetLang1);
        translateTextDTOList.add(translateTextDTO1);

        TranslateTextDTO translateTextDTO2 = new TranslateTextDTO();
        translateTextDTO2.setPostingId(postingId2);
        translateTextDTO2.setOriginalText(originalText2);
        translateTextDTOList.add(translateTextDTO2);

        TranslateTextDTO translateTextDTO3 = new TranslateTextDTO();
        translateTextDTO3.setPostingId(postingId3);
        translateTextDTO3.setOriginalText(originalText3);
        translateTextDTOList.add(translateTextDTO3);

        TranslateTextDTO translateTextDTO4 = new TranslateTextDTO();
        translateTextDTO4.setPostingId(postingId4);
        translateTextDTO4.setOriginalText(originalText4);
        translateTextDTOList.add(translateTextDTO4);

        TranslateTextDTO translateTextDTO5 = new TranslateTextDTO();
        translateTextDTO5.setPostingId(postingId5);
        translateTextDTO5.setOriginalText(originalText5);
        translateTextDTOList.add(translateTextDTO5);

        List<TranslateTextDTO> translatedResult  = null;
        translatedResult = translationService.translate(translateTextDTOList);

        // 테스트 결과 확인
        System.out.println("Translated Text: " + translatedResult);
    }
}