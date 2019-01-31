package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> wordList = new ArrayList<Word>();
        wordList.add(new Word("red", "weṭeṭṭi"));
        wordList.add(new Word("green", "chokokki"));
        wordList.add(new Word("brown", "ṭakaakki"));
        wordList.add(new Word("gray", "ṭopoppi"));
        wordList.add(new Word("black", "kululli"));
        wordList.add(new Word("white", "kelelli"));
        wordList.add(new Word("dusty yellow", "ṭopiisә"));
        wordList.add(new Word("mustard yellow", "chiwiiṭә"));
        WordAdapter adapter = new WordAdapter(this, wordList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
