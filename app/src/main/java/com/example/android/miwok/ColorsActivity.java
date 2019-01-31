package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> wordList = new ArrayList<Word>();
        wordList.add(new Word("red", "weṭeṭṭi", R.raw.color_red, R.drawable.color_red));
        wordList.add(new Word("green", "chokokki", R.raw.color_green, R.drawable.color_green));
        wordList.add(new Word("brown", "ṭakaakki", R.raw.color_brown, R.drawable.color_brown));
        wordList.add(new Word("gray", "ṭopoppi", R.raw.color_gray, R.drawable.color_gray));
        wordList.add(new Word("black", "kululli", R.raw.color_black, R.drawable.color_black));
        wordList.add(new Word("white", "kelelli", R.raw.color_white, R.drawable.color_white));
        wordList.add(new Word("dusty yellow", "ṭopiisә", R.raw.color_dusty_yellow, R.drawable.color_dusty_yellow));
        wordList.add(new Word("mustard yellow", "chiwiiṭә", R.raw.color_mustard_yellow, R.drawable.color_mustard_yellow));
        WordAdapter adapter = new WordAdapter(this, wordList, R.color.category_colors);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Word selectedWord = (Word) parent.getItemAtPosition(position);
                mMediaPlayer = MediaPlayer.create(parent.getContext(),selectedWord.getmAudioResourceID());
                mMediaPlayer.start();
                Toast.makeText(parent.getContext(), selectedWord.getDefaultTranslation(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
