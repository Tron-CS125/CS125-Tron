package com.example.tron;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import androidx.annotation.Nullable;

public final class ChooseRandomSongActivity extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public final MediaPlayer chooseRandomSong() {
        MediaPlayer player;
        int songChoice = (int)(Math.random() * 7);
        switch (songChoice) {
            case (0):
                player = MediaPlayer.create(getApplicationContext(), R.raw.bg_music);
                break;
            case (1):
                player = MediaPlayer.create(getApplicationContext(), R.raw.bg_music2);
                break;
            case (2):
                player = MediaPlayer.create(getApplicationContext(), R.raw.bg_music3);
                break;
            case (3):
                player = MediaPlayer.create(getApplicationContext(), R.raw.bg_music4);
                break;
            case (4):
                player = MediaPlayer.create(getApplicationContext(), R.raw.bg_music5);
                break;
            case (5):
                player = MediaPlayer.create(getApplicationContext(), R.raw.bg_music6);
                break;
            case (6):
                player = MediaPlayer.create(getApplicationContext(), R.raw.bg_music7);
                break;
            default:
                player = MediaPlayer.create(getApplicationContext(), R.raw.bg_music8);
                break;
        }
        return player;
    }

}
