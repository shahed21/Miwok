package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> wordList = new ArrayList<Word>();
        wordList.add(new Word("father", "әpә", R.drawable.family_father));
        wordList.add(new Word("mother", "әṭa", R.drawable.family_mother));
        wordList.add(new Word("son", "angsi", R.drawable.family_son));
        wordList.add(new Word("daughter", "tune", R.drawable.family_daughter));
        wordList.add(new Word("older brother", "taachi", R.drawable.family_older_brother));
        wordList.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother));
        wordList.add(new Word("older sister", "teṭe", R.drawable.family_older_sister));
        wordList.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister));
        wordList.add(new Word("grandmother", "ama", R.drawable.family_grandmother));
        wordList.add(new Word("grandfather", "paapa", R.drawable.family_grandfather));
        WordAdapter adapter = new WordAdapter(this, wordList, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Word selectedWord = (Word) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(), selectedWord.getDefaultTranslation(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
