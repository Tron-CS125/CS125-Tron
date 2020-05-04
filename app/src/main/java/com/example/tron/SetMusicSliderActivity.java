//package com.example.tron;
//
//import android.app.Activity;
//import android.content.Context;
//import android.media.AudioManager;
//import android.media.MediaPlayer;
//import android.net.sip.SipSession;
//import android.os.Bundle;
//import android.widget.SeekBar;
//import android.widget.SeekBar.OnSeekBarChangeListener;
//
//
//public class SetMusicSliderActivity extends Activity implements OnSeekBarChangeListener {
//    private SeekBar musicSeekBar;
//    private AudioManager audioManager;
//    private int volume = 0;
//
//    /**
//     * This onCreate initialized the seekbar for Music.
//     * reference code: https://mycodeandlife.wordpress.com/2012/07/13/android-seekbar-to-set-the-volume/
//     * @param inputBundle input bundle.
//     */
//    protected void onCreate(Bundle inputBundle) {
//        super.onCreate(inputBundle);
//        setContentView(R.layout.activity_settings);
//
//        musicSeekBar = findViewById(R.id.musicSeekBar);
//
//        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//
//        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
//        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
//
//        musicSeekBar.setMax(maxVolume);
//        musicSeekBar.setProgress(currentVolume);
//        musicSeekBar.setOnSeekBarChangeListener();
//    }
//
//    public void setOnSeekBarChangeListener (SeekBar.OnSeekBarChangeListener input) {
//        input.
//    }
//
//    public void onProgressChanged(SeekBar seekBar, int progress, boolean arg2) {
//        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
//        volume = progress;
//    }
//    public void onStartTrackingTouch(SeekBar arg0) { }
//    public void onStopTrackingTouch(SeekBar arg0) { }
//}
//
