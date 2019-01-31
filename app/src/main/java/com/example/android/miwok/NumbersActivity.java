package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        ArrayList<String> wordList = new ArrayList<String>();
        wordList.add(0,"one");
        wordList.add(1,"two");
        wordList.add(2,"three");
        wordList.add(3,"four");
        wordList.add(4,"five");
        wordList.add(5,"six");
        wordList.add(6,"seven");
        wordList.add(7,"eight");
        wordList.add(8,"nine");
        wordList.add(9,"ten");
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);
        for (int i =0; i<wordList.size(); i++) {
            Log.v(this.getClass().getSimpleName(), wordList.get(i));
            TextView wordView = new TextView(this);
            wordView.setText(wordList.get(i));
            rootView.addView(wordView);
        }
    }
}
