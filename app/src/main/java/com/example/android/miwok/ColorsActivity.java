package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends WordCommonActivity {
    final String LOG_TAG = ColorsActivity.class.getSimpleName();
    final private int mColorResourceId = R.color.category_colors;
    private ArrayList<Word> wordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        createWordList();
        finishCreation(this, wordList,mColorResourceId);
    }

    private void createWordList() {
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
