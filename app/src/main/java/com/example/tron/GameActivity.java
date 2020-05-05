package com.example.tron;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tron.GameLogic.GridLogic;

import static java.security.AccessController.getContext;

public class GameActivity extends AppCompatActivity {

    private DrawStuff drawStuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Context context = GameActivity.this;
        drawStuff = new DrawStuff(context);
//        Button b = findViewById(R.id.endGameButton);
//        b.setVisibility(View.GONE);
        configureRightButton();
        configureLeftButton();
//        configureRestartButton();
        configureEndGameButton();
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

//    public void configureRestartButton() {
//        Button restartButton = findViewById(R.id.restartButton);
//        restartButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                drawStuff.restartGame();
//            }
//        });
//    }
    public void configureEndGameButton() {
        Button endGameButton = findViewById(R.id.endGameButton);
        endGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawStuff.endGame();
            }
        });
    }

    public void endGame() {
        Intent intent = new Intent(GameActivity.this, GameOverActivity.class);
        startActivity(intent);
    }
}