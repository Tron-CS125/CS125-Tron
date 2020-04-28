package com.example.tron;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SnakeActivity extends MainActivity {
    //code for snake arena goes here
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button next = findViewById(R.id.startGameButton);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
