package org.omoknoone.translator.service;

import org.omoknoone.translator.dto.TranslationDTO;

import java.util.List;

public interface TranslationService {
    List<TranslationDTO> translate(List<TranslationDTO> translationDTOList);
}
