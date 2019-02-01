package com.example.android.miwok;

import android.app.Activity;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
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
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mAfChangeListener;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
            if (mAfChangeListener!=null) {
                mAudioManager.abandonAudioFocus(mAfChangeListener);
            }
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(LOG_TAG, "onStop");
        releaseMediaPlayer();
    }

    protected void finishCreation(Activity activity, ArrayList<Word> wordList, int colorResourceId) {
        mAudioManager = (AudioManager) this.getSystemService(this.AUDIO_SERVICE);
        mAfChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {
                if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                    // Pause playback because your Audio Focus was
                    // temporarily stolen, but will be back soon.
                    // i.e. for a phone call
                    if (mMediaPlayer!=null) {
                        mMediaPlayer.pause();
                    }
                } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                    // Stop playback, because you lost the Audio Focus.
                    // i.e. the user started some other playback app
                    // Remember to unregister your controls/buttons here.
                    // And release the kra — Audio Focus!
                    // You’re done.
                    if (mMediaPlayer!=null) {
                        mMediaPlayer.stop();
                        releaseMediaPlayer();
                    }
                    if (mAfChangeListener!=null) {
                        mAudioManager.abandonAudioFocus(mAfChangeListener);
                    }
                } else if (focusChange ==
                        AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                    // Lower the volume, because something else is also
                    // playing audio over you.
                    // i.e. for notifications or navigation directions
                    // Depending on your audio playback, you may prefer to
                    // pause playback here instead. You do you.
                    if (mMediaPlayer!=null) {
                        mMediaPlayer.pause();
                    }
                } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                    // Resume playback, because you hold the Audio Focus
                    // again!
                    // i.e. the phone call ended or the nav directions
                    // are finished
                    // If you implement ducking and lower the volume, be
                    // sure to return it to normal here, as well.
                    if (mMediaPlayer!=null) {
                        mMediaPlayer.start();
                    }
                }
            }
        };
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
                if (requestAudioFocus(
                        mAfChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT)) {
                    mMediaPlayer = MediaPlayer.create(
                            parent.getContext(),
                            selectedWord.getmAudioResourceID());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
                Toast.makeText(
                        parent.getContext(),
                        selectedWord.getDefaultTranslation(),
                        Toast.LENGTH_SHORT).show();
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

    /**
     * This method is needed because AudioManager.requestAudioFocus with OnFocusChangeListener is
     * deprecated after API 26.
     * @param focusChangeListener
     * @param streamType
     * @param audioFocusGain
     * @return
     */
    private boolean requestAudioFocus(AudioManager.OnAudioFocusChangeListener focusChangeListener,
                                     int streamType, int audioFocusGain) {
        int r;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            r = mAudioManager.requestAudioFocus(
                    new AudioFocusRequest.Builder(audioFocusGain)
                            .setAudioAttributes(
                                    new AudioAttributes.Builder()
                                            .setLegacyStreamType(streamType)
                                            .build())
                            .setOnAudioFocusChangeListener(focusChangeListener)
                            .build());
        } else {
            //noinspection deprecation
            r = mAudioManager.requestAudioFocus(focusChangeListener, streamType, audioFocusGain);
        }

        return r == AudioManager.AUDIOFOCUS_REQUEST_GRANTED;
    }
}
