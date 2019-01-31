package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */

public class Word {
    /** Miwok Translation of word **/
    private String mMiwokTranslation;
    /** Default Translation of word **/
    private String mDefaultTranslation;

    /**
     * Creates a new word
     * @param defaultTranslation is the word in the language user is already familiar with
     * @param miwokTranslation is the word in Miwok
     */
    public Word(String defaultTranslation, String miwokTranslation) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
    }

    /**
     * This method returns the default translation of the Word
     * @return defaultTranslation
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * This method returns the Miwok translation of the Word
     * @return Miwok Translation
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
}
