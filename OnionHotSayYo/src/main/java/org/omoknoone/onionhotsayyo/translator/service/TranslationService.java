package org.omoknoone.onionhotsayyo.translator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.omoknoone.onionhotsayyo.translator.dto.TranslationDTO;

public interface TranslationService {
    TranslationDTO translate(TranslationDTO translationDTO);
}
