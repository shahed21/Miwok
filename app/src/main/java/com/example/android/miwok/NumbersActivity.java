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

public class NumbersActivity extends AppCompatActivity {
    final String LOG_TAG = NumbersActivity.class.getSimpleName();
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> wordList = new ArrayList<Word>();
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
        WordAdapter adapter = new WordAdapter(this, wordList, R.color.category_numbers);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, int position, long id)
            {
                Word selectedWord = (Word) parent.getItemAtPosition(position);
                Log.v(LOG_TAG, "Current word: " + selectedWord);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(parent.getContext(),selectedWord.getmAudioResourceID());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
                Toast.makeText(parent.getContext(), selectedWord.getDefaultTranslation(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(LOG_TAG, "onStop");
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources
     */
    private void releaseMediaPlayer() {
        if (mMediaPlayer!=null) {
            mMediaPlayer.release();
            mMediaPlayer=null;
        }
    }
}
