package com.example.tron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Set;

public class FinalColorActivity extends AppCompatActivity {
    /**
     * red color int.
     */
    final private int red = Color.rgb(255, 48, 33);
    /**
     * orange color int.
     */
    final private int orange = Color.rgb(255, 137, 33);
    /**
     * yellow color int.
     */
    final private int yellow = Color.rgb(255, 240, 33);
    /**
     * green color int.
     */
    final private int green = Color.rgb(44, 255, 33);
    /**
     * blue color int.
     */
    final private int blue = Color.rgb(33, 137, 255);
    /**
     * teal color int.
     */
    final private int teal = Color.rgb(33, 255, 218);
    /**
     * purple color int.
     */
    final private int purple = Color.rgb(181, 33, 255);
    /**
     * pink color int.
     */
    final private int pink = Color.rgb(255, 165, 0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_color);

        configureBackFromColorsButton();
    }
    private void configureBackFromColorsButton() {
        Button backButton = (Button) findViewById(R.id.backToSettingsFromColor);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FinalColorActivity.this, SettingsActivity.class));
            }
        });
    }
}
