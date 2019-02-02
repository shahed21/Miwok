package com.example.android.miwok;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PhrasesFragment extends WordCommonFragment {
    final String LOG_TAG = PhrasesFragment.class.getSimpleName();
    final private int mColorResourceId = R.color.category_phrases;
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
        wordList.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        wordList.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        wordList.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        wordList.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        wordList.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        wordList.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        wordList.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        wordList.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
        wordList.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        wordList.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));
    }
}
