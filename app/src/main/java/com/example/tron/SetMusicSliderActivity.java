package com.example.tron;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SetMusicSliderActivity extends Activity implements OnSeekBarChangeListener {
    private AudioManager audioManager;
    private int volume = 0;
    /**
     * This onCreate initialized the seekbar for Music.
     * reference code: https://mycodeandlife.wordpress.com/2012/07/13/android-seekbar-to-set-the-volume/
     * @param inputBundle input bundle.
     */
    protected void onCreate(Bundle inputBundle) {
        super.onCreate(inputBundle);
        setContentView(R.layout.activity_settings);

        SeekBar musicSeekBar = findViewById(R.id.musicSeekBar);
        //ChooseRandomSongActivity song = new ChooseRandomSongActivity();
        //MediaPlayer mediaPlayer = song.chooseRandomSong(getApplicationContext());
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //mediaPlayer.start();
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        musicSeekBar.setMax(maxVolume);
        musicSeekBar.setProgress(currentVolume);
        musicSeekBar.setOnSeekBarChangeListener(this);
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean arg2) {
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
        volume = progress;
    }
    public void onStartTrackingTouch(SeekBar arg0) {
        // stuff here
    }
    public void onStopTrackingTouch(SeekBar arg0) {
        // stuff here
    }
}
