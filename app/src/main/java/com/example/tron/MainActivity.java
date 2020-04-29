package com.example.tron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean songStarted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (!songStarted) {
            //picks a song from the jukebox and plays it when the app opens. song loops
            songStarted = true;
            ChooseRandomSongActivity songInstance = new ChooseRandomSongActivity();
            MediaPlayer song = songInstance.chooseRandomSong(getApplicationContext());
            song.setLooping(true);
            song.start();
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
                startActivity(new Intent(MainActivity.this, GameActivity.class));
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

    // this is basically a test method, don't mind it
    private void snakeLeftButton() {
        Button snakeLeftButton = (Button) findViewById(R.id.leftButton);
        snakeLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // snakeLeft();
            }
        });
    }

    // also test method lol
    private void snakeRightButton() {
        Button snakeRightButton = (Button) findViewById(R.id.rightButton);
        snakeRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // snakeRight();
            }
        });
    }
}