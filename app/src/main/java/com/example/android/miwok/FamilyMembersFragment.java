package com.example.android.miwok;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FamilyMembersFragment extends WordCommonFragment {
    final String LOG_TAG = FamilyMembersFragment.class.getSimpleName();
    final private int mColorResourceId = R.color.category_family;
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
        wordList.add(new Word("father", "әpә", R.raw.family_father, R.drawable.family_father));
        wordList.add(new Word("mother", "әṭa", R.raw.family_mother, R.drawable.family_mother));
        wordList.add(new Word("son", "angsi", R.raw.family_son, R.drawable.family_son));
        wordList.add(new Word("daughter", "tune", R.raw.family_daughter, R.drawable.family_daughter));
        wordList.add(new Word("older brother", "taachi", R.raw.family_older_brother, R.drawable.family_older_brother));
        wordList.add(new Word("younger brother", "chalitti", R.raw.family_younger_brother, R.drawable.family_younger_brother));
        wordList.add(new Word("older sister", "teṭe", R.raw.family_older_sister, R.drawable.family_older_sister));
        wordList.add(new Word("younger sister", "kolliti", R.raw.family_younger_sister, R.drawable.family_younger_sister));
        wordList.add(new Word("grandmother", "ama", R.raw.family_grandmother, R.drawable.family_grandmother));
        wordList.add(new Word("grandfather", "paapa", R.raw.family_grandfather, R.drawable.family_grandfather));
    }
}
