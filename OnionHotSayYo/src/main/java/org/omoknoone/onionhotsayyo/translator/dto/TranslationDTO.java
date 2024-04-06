package org.omoknoone.onionhotsayyo.translator.dto;

public class TranslationDTO {
    private String sourceLang;
    private String targetLang;
    private String originalText;
    private String translatedText;

    public TranslationDTO() {
    }

    public TranslationDTO(String sourceLang, String targetLang, String translatedText) {
        this.sourceLang = sourceLang;
        this.targetLang = targetLang;
        this.translatedText = translatedText;
    }

    public TranslationDTO(String sourceLang, String targetLang, String originalText, String translatedText) {
        this.sourceLang = sourceLang;
        this.targetLang = targetLang;
        this.originalText = originalText;
        this.translatedText = translatedText;
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public void setSourceLang(String sourceLang) {
        this.sourceLang = sourceLang;
    }

    public String getTargetLang() {
        return targetLang;
    }

    public void setTargetLang(String targetLang) {
        this.targetLang = targetLang;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    @Override
    public String toString() {
        return "TranslationDTO{" +
                "sourceLang='" + sourceLang + '\'' +
                ", targetLang='" + targetLang + '\'' +
                ", originalText='" + originalText + '\'' +
                ", translatedText='" + translatedText + '\'' +
                '}';
    }
}
