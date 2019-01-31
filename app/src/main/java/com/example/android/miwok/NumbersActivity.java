package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<Word> wordList = new ArrayList<Word>();
        wordList.add(new Word("one", "lutti"));
        wordList.add(new Word("two", "otiiko"));
        wordList.add(new Word("three", "tolookosu"));
        wordList.add(new Word("four", "oyyisa"));
        wordList.add(new Word("five", "massokka"));
        wordList.add(new Word("six", "temmokka"));
        wordList.add(new Word("seven", "kenekaku"));
        wordList.add(new Word("eight", "kawinta"));
        wordList.add(new Word("nine", "wo’e"));
        wordList.add(new Word("ten", "na’aacha"));
        WordAdapter adapter = new WordAdapter(this, wordList);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
