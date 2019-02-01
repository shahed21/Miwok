package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class WordCommonActivity extends AppCompatActivity {
    final String LOG_TAG = WordCommonActivity.class.getSimpleName();
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(LOG_TAG, "onStop");
        releaseMediaPlayer();
    }

    protected void finishCreation(Activity activity, ArrayList<Word> wordList, int colorResourceId) {
        WordAdapter adapter = new WordAdapter(activity, wordList, colorResourceId);
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
