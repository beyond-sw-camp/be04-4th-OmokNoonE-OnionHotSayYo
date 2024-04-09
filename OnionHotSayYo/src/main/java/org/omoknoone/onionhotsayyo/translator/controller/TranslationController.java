package org.omoknoone.onionhotsayyo.translator.controller;

import org.omoknoone.onionhotsayyo.responseEntity.ResponseMessage;
import org.omoknoone.onionhotsayyo.translator.dto.TranslateTextDTO;
import org.omoknoone.onionhotsayyo.translator.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/translators")
public class TranslationController {

    private final TranslationService translationService;

    @Autowired
    public TranslationController(TranslationService translationService) {
        this.translationService = translationService;
    }

    /* 번역 요청 */
    @PostMapping("/translate")
    public ResponseEntity<ResponseMessage> translateText(@RequestBody List<TranslateTextDTO> translateTextDTOList) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("result", translationService.translate(translateTextDTOList));

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "번역 성공", responseMap));
    }

}
