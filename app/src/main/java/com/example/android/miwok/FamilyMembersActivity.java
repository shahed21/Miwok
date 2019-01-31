package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> wordList = new ArrayList<Word>();
        wordList.add(new Word("father", "әpә"));
        wordList.add(new Word("mother", "әṭa"));
        wordList.add(new Word("son", "angsi"));
        wordList.add(new Word("daughter", "tune"));
        wordList.add(new Word("older brother", "taachi"));
        wordList.add(new Word("younger brother", "chalitti"));
        wordList.add(new Word("older sister", "teṭe"));
        wordList.add(new Word("younger sister", "kolliti"));
        wordList.add(new Word("grandmother", "ama"));
        wordList.add(new Word("grandfather", "paapa"));
        WordAdapter adapter = new WordAdapter(this, wordList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
