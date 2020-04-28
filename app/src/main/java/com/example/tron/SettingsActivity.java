package com.example.tron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        configureBackButton();
        configureDesignButton();
        configureColorButton();


    }
    private void configureBackButton() {
        Button backButton = (Button) findViewById(R.id.backFromOptions);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, MainActivity.class));
            }
        });
    }
    private void configureDesignButton() {
        Button designButton = (Button) findViewById(R.id.designButton);
        designButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, DesignActivity.class));
            }
        });
    }
    private void configureColorButton() {
        Button colorButton = (Button) findViewById(R.id.colorButton);
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SettingsActivity.this, FinalColorActivity.class));
            }
        });
    }
}
