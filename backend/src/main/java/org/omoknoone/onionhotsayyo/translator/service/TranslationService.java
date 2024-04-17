package org.omoknoone.onionhotsayyo.translator.service;

import org.omoknoone.onionhotsayyo.post.dto.HeaderSearchInfoDTO;
import org.omoknoone.onionhotsayyo.translator.dto.TranslatedTextDTO;
import org.omoknoone.onionhotsayyo.translator.dto.TranslationDTO;

import java.util.List;

public interface TranslationService {
    List<TranslationDTO> translate(List<TranslationDTO> translationDTOList);

    TranslatedTextDTO translateKeyword(HeaderSearchInfoDTO searchInfo);
}
