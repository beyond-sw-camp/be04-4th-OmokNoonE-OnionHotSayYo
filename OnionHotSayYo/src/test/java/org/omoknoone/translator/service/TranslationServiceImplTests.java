package org.omoknoone.translator.service;

import org.junit.jupiter.api.Test;
import org.omoknoone.translator.dto.TranslationDTO;
import org.omoknoone.translator.service.TranslationService;
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

        String targetLang = "KO";

        int postId1 = 1;
        String originalTitle1 = "greeting";
        String originalContent1 = "Hello, world!";

        int postId2 = 2;
        String originalTitle2 = "name";
        String originalContent2 = "What's your name?";

        int postId3 = 3;
        String originalTitle3 = "自己紹介";
        String originalContent3 = "私は開発者です";

        int postId4 = 4;
        String originalTitle4 = "présentation";
        String originalContent4 = "Je suis développeur";

        int postId5 = 5;
        String originalTitle5 = "lunch menu";
        String originalContent5 = "What are you having for lunch?";

        List<TranslationDTO> translationDTOList = new ArrayList<>();
        TranslationDTO translationDTO1 = new TranslationDTO();
        translationDTO1.setPostId(postId1);
        translationDTO1.setLanguage(targetLang);
        translationDTO1.setTitle(originalTitle1);
        translationDTO1.setContent(originalContent1);
        translationDTOList.add(translationDTO1);

        TranslationDTO translationDTO2 = new TranslationDTO();
        translationDTO2.setPostId(postId2);
        translationDTO2.setLanguage(targetLang);
        translationDTO2.setTitle(originalTitle2);
        translationDTO2.setContent(originalContent2);
        translationDTOList.add(translationDTO2);

        TranslationDTO translationDTO3 = new TranslationDTO();
        translationDTO3.setPostId(postId3);
        translationDTO3.setLanguage(targetLang);
        translationDTO3.setTitle(originalTitle3);
        translationDTO3.setContent(originalContent3);
        translationDTOList.add(translationDTO3);

        TranslationDTO translationDTO4 = new TranslationDTO();
        translationDTO4.setPostId(postId4);
        translationDTO4.setLanguage(targetLang);
        translationDTO4.setTitle(originalTitle4);
        translationDTO4.setContent(originalContent4);
        translationDTOList.add(translationDTO4);

        TranslationDTO translationDTO5 = new TranslationDTO();
        translationDTO5.setPostId(postId5);
        translationDTO5.setLanguage(targetLang);
        translationDTO5.setTitle(originalTitle5);
        translationDTO5.setContent(originalContent5);
        translationDTOList.add(translationDTO5);

        List<TranslationDTO> translatedResult  = null;
        translatedResult = translationService.translate(translationDTOList);

        // 테스트 결과 확인
        System.out.println("Translated Text: " + translatedResult);
    }
}