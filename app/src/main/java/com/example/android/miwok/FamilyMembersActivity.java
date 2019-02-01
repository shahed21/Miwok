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

public class FamilyMembersActivity extends WordCommonActivity {
    final String LOG_TAG = FamilyMembersActivity.class.getSimpleName();
    final private int mColorResourceId = R.color.category_family;
    private ArrayList<Word> wordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        Log.v(LOG_TAG, "onCreate");
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        createWordList();
        finishCreation(this, wordList,mColorResourceId);
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
