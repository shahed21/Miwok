package com.example.android.miwok;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NumbersFragment extends WordCommonFragment {
    final String LOG_TAG = NumbersFragment.class.getSimpleName();
    final private int mColorResourceId = R.color.category_numbers;
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
        wordList.add(new Word("one", "lutti", R.raw.number_one, R.drawable.number_one));
        wordList.add(new Word("two", "otiiko", R.raw.number_two, R.drawable.number_two));
        wordList.add(new Word("three", "tolookosu", R.raw.number_three, R.drawable.number_three));
        wordList.add(new Word("four", "oyyisa", R.raw.number_four, R.drawable.number_four));
        wordList.add(new Word("five", "massokka", R.raw.number_five, R.drawable.number_five));
        wordList.add(new Word("six", "temmokka", R.raw.number_six, R.drawable.number_six));
        wordList.add(new Word("seven", "kenekaku", R.raw.number_seven, R.drawable.number_seven));
        wordList.add(new Word("eight", "kawinta", R.raw.number_eight, R.drawable.number_eight));
        wordList.add(new Word("nine", "wo’e", R.raw.number_nine, R.drawable.number_nine));
        wordList.add(new Word("ten", "na’aacha", R.raw.number_ten, R.drawable.number_ten));
    }
}
