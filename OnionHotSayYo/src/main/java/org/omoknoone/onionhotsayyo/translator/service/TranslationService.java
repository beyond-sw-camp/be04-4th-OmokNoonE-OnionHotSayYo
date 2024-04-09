package org.omoknoone.onionhotsayyo.translator.service;

import org.omoknoone.onionhotsayyo.translator.dto.TranslateTextDTO;

import java.util.List;

public interface TranslationService {
    List<TranslateTextDTO> translate(List<TranslateTextDTO> translateTextDTOList);
}
