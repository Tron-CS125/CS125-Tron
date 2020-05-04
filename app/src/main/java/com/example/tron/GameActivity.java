package com.example.tron;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tron.GameLogic.GridLogic;

public class GameActivity extends AppCompatActivity {

    private DrawStuff drawStuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        drawStuff = findViewById(R.id.drawStuff);
        configureRightButton();
        configureLeftButton();
        configureRestartButton();
    }

    private void configureRightButton() {
        Button rightButton = findViewById(R.id.rightButton);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawStuff.rightButton();
            }
        });
    }

    private void configureLeftButton() {
        Button leftButton = findViewById(R.id.leftButton);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawStuff.leftButton();
            }
        });
    }

    public void configureRestartButton() {
        Button restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawStuff.restartGame();
            }
        });
    }
}