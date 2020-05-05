package com.example.tron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static boolean songStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (!songStarted) {
            //picks a song from the jukebox and plays it when the app opens. song loops
            songStarted = true;
            ChooseRandomSongActivity songInstance = new ChooseRandomSongActivity();
            MediaPlayer song = songInstance.chooseRandomSong(getApplicationContext());
            song.setLooping(true);
            song.start();
            GlobalMusicVariables x = GlobalMusicVariables.getInstance();
            x.setData(song);
            //default values: arena = 23x23, speed = 125, color = red
            GlobalArenaSizeVariables arenaSize = GlobalArenaSizeVariables.getInstance();
            arenaSize.setData(23);

            GlobalColorVariables playerColor = GlobalColorVariables.getInstance();
            playerColor.setData(Color.rgb(255, 48, 33));

            GlobalSpeedVariables playerSpeed = GlobalSpeedVariables.getInstance();
            playerSpeed.setData(125);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureStartButton();
        configureSettingsButton();
    }

    private void configureStartButton() {
        Button startButton = findViewById(R.id.startGameButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
    }

    private void configureSettingsButton() {
        Button settingsButton = findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
    }
}