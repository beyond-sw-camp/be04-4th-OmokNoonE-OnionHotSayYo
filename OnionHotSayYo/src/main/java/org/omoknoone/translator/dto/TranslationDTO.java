package org.omoknoone.translator.dto;

import lombok.*;

@Setter
@Getter
@ToString @EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TranslationDTO {
    private int postId;
    private String language;
    private String title;
    private String content;

    public TranslationDTO(int postId, String language, String title) {
        this.postId = postId;
        this.language = language;
        this.title = title;
    }

/*private int postId;
    private String targetLang;
    private String originalText;
    private String translatedText;

    public TranslateTextDTO(String targetLang, String translatedText) {
        this.targetLang = targetLang;
        this.translatedText = translatedText;
    }*/
}
