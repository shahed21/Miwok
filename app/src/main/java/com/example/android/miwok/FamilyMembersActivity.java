package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> wordList = new ArrayList<Word>();
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
        WordAdapter adapter = new WordAdapter(this, wordList, R.color.category_family);
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
