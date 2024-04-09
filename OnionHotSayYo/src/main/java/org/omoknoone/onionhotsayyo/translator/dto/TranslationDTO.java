package org.omoknoone.onionhotsayyo.translator.dto;

import lombok.Data;

@Data
public class TranslationDTO {

    private int translationId;
    private String content;
    private String title;
    private String language;
    private int postingId;
}
