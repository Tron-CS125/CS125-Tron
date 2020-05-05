package com.example.tron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.tron.DrawStuff.score;

public class GameOverActivity extends AppCompatActivity {

    GameActivity game = new GameActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        String message = "Score: " + (score * 100);
        TextView textView = (TextView)findViewById(R.id.scoreText);
        textView.setText(message);
        configureRestartButton();
        configureMainMenuButton();
    }
    public void configureRestartButton() {
        Button restartButton = findViewById(R.id.restartButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOverActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
    }
    public void configureMainMenuButton() {
        Button restartButton = findViewById(R.id.mainMenuButton);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
