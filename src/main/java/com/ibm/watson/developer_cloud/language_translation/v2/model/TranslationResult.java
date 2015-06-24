
package com.ibm.watson.developer_cloud.language_translation.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;

/**
 * Translation results from calling the translate method.
 * This case is used as POJO by the {@link LanguageTranslation}
 *
 * @author German Attanasio Ruiz <germanatt@us.ibm.com>
 */
public class TranslationResult {

    /** The translations. */
    private List<Translation> translations = new ArrayList<Translation>();
    
    /** The word count. */
    @SerializedName("word_count")
    private int wordCount;
    
    /** The character count. */
    @SerializedName("character_count")
    private int characterCount;
    
    /**
     * Gets the translations.
     *
     * @return     The translations
     */
    public List<Translation> getTranslations() {
        return translations;
    }

    /**
     * Sets the translations.
     *
     * @param translations     The translations
     */
    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }

    /**
     * With translations.
     *
     * @param translations the translations
     * @return the translation result
     */
    public TranslationResult withTranslations(List<Translation> translations) {
        this.translations = translations;
        return this;
    }

    /**
     * Gets the word count.
     *
     * @return     The word count
     */
    public int getWordCount() {
        return wordCount;
    }

    /**
     * Sets the word count.
     *
     * @param wordCount     The word count
     */
    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    /**
     * With word count.
     *
     * @param wordCount the word count
     * @return the translation result
     */
    public TranslationResult withWordCount(int wordCount) {
        this.wordCount = wordCount;
        return this;
    }

    /**
     * Gets the character count.
     *
     * @return     The characterCount
     */
    public int getCharacterCount() {
        return characterCount;
    }

    /**
     * Sets the character count.
     *
     * @param characterCount     The character count
     */
    public void setCharacterCount(int characterCount) {
        this.characterCount = characterCount;
    }

    /**
     * With character count.
     *
     * @param characterCount the character count
     * @return the translation result
     */
    public TranslationResult withCharacterCount(int characterCount) {
        this.characterCount = characterCount;
        return this;
    }

}
