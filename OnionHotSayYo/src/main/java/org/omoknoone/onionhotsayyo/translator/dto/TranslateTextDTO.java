package org.omoknoone.onionhotsayyo.translator.dto;

import lombok.*;

@Setter
@Getter
@ToString @EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TranslateTextDTO {
    private int postingId;
    private String sourceLang;
    private String targetLang;
    private String originalText;
    private String translatedText;

    public TranslateTextDTO(String sourceLang, String targetLang, String translatedText) {
        this.sourceLang = sourceLang;
        this.targetLang = targetLang;
        this.translatedText = translatedText;
    }
}
