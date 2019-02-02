package com.example.android.miwok;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ColorsFragment extends WordCommonFragment {
    final String LOG_TAG = ColorsFragment.class.getSimpleName();
    final private int mColorResourceId = R.color.category_colors;
    private ArrayList<Word> wordList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        Log.v(LOG_TAG, "onCreateView");
        createWordList();
        finishCreation(this, rootView, wordList, mColorResourceId);
        return rootView;
    }

    private void createWordList() {
        Log.v(LOG_TAG, "createWordList");
        wordList = new ArrayList<Word>();
        wordList.add(new Word("red", "weṭeṭṭi", R.raw.color_red, R.drawable.color_red));
        wordList.add(new Word("green", "chokokki", R.raw.color_green, R.drawable.color_green));
        wordList.add(new Word("brown", "ṭakaakki", R.raw.color_brown, R.drawable.color_brown));
        wordList.add(new Word("gray", "ṭopoppi", R.raw.color_gray, R.drawable.color_gray));
        wordList.add(new Word("black", "kululli", R.raw.color_black, R.drawable.color_black));
        wordList.add(new Word("white", "kelelli", R.raw.color_white, R.drawable.color_white));
        wordList.add(new Word("dusty yellow", "ṭopiisә", R.raw.color_dusty_yellow, R.drawable.color_dusty_yellow));
        wordList.add(new Word("mustard yellow", "chiwiiṭә", R.raw.color_mustard_yellow, R.drawable.color_mustard_yellow));
    }
}
