package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */

public class Word {
    private final static int NO_IMAGE_ADDED = -1;

    /** Miwok Translation of word **/
    private String mMiwokTranslation;
    /** Default Translation of word **/
    private String mDefaultTranslation;
    /** Drawable resource ID **/
    private int mImageResourceID = NO_IMAGE_ADDED;


    /**
     * Creates a new word with no image
     * @param defaultTranslation is the word in the language user is already familiar with
     * @param miwokTranslation is the word in Miwok
     */
    public Word(String defaultTranslation, String miwokTranslation) {
        this(defaultTranslation, miwokTranslation, NO_IMAGE_ADDED);
    }

    /**
     * Creates a new word with a Image
     * @param defaultTranslation is the word in the language user is already familiar with
     * @param miwokTranslation is the word in Miwok
     * @param imageResourceID is the drawable image resource id
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceID) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageResourceID = imageResourceID;
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

    /**
     * This method returns the image that gows along with the word as a Drawable img res ID.
     * @return Drawable Image Resource ID associated with the Word
     */
    public int getImageResourceID() {
        return mImageResourceID;
    }

    public boolean hasImage() {
        return (mImageResourceID!=NO_IMAGE_ADDED);
    }
}
