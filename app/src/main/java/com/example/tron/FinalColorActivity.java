package com.example.tron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
    final private int pink = Color.rgb(255, 165, 255);

    private static boolean colorOpened = true;

    private ImageView redText;
    private ImageView orangeText;
    private ImageView yellowText;
    private ImageView greenText;
    private ImageView tealText;
    private ImageView blueText;
    private ImageView purpleText;
    private ImageView pinkText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_color);
        configureButtons();
        redText = findViewById(R.id.redColorText);
        orangeText = findViewById(R.id.orangeColorText);
        yellowText = findViewById(R.id.yellowColorText);
        greenText = findViewById(R.id.greenColorText);
        tealText = findViewById(R.id.tealColorText);
        blueText = findViewById(R.id.blueColorText);
        purpleText = findViewById(R.id.purpleColorText);
        pinkText = findViewById(R.id.pinkColorText);

        GlobalColorVariables g = GlobalColorVariables.getInstance();
        if (colorOpened) {
            colorOpened = false;
            g.setData(red);
            redText.setVisibility(View.VISIBLE);
            orangeText.setVisibility(View.GONE);
            yellowText.setVisibility(View.GONE);
            greenText.setVisibility(View.GONE);
            tealText.setVisibility(View.GONE);
            blueText.setVisibility(View.GONE);
            purpleText.setVisibility(View.GONE);
            pinkText.setVisibility(View.GONE);
        } else {
            int x = g.getData();
            if (x == red) {
                redText.setVisibility(View.VISIBLE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.GONE);
            } else if (x == orange) {
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.VISIBLE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.GONE);
            } else if (x == yellow) {
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.VISIBLE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.GONE);
            } else if (x == green) {
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.VISIBLE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.GONE);
            } else if (x == teal) {
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.VISIBLE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.GONE);
            } else if (x == blue) {
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.VISIBLE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.GONE);
            } else if (x == purple) {
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.VISIBLE);
                pinkText.setVisibility(View.GONE);
            } else if (x == pink) {
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.VISIBLE);
            }
        }
    }

    private void configureButtons() {
        Button backButton = findViewById(R.id.backToSettingsFromColor);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FinalColorActivity.this, SettingsActivity.class));
            }
        });
        Button redButton = findViewById(R.id.redButton);
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalColorVariables g = GlobalColorVariables.getInstance();
                g.setData(red);
                redText.setVisibility(View.VISIBLE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.GONE);
            }
        });
        Button orangeButton = findViewById(R.id.orangeButton);
        orangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalColorVariables g = GlobalColorVariables.getInstance();
                g.setData(orange);
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.VISIBLE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.GONE);
            }
        });
        Button yellowButton = findViewById(R.id.yellowButton);
        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalColorVariables g = GlobalColorVariables.getInstance();
                g.setData(yellow);
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.VISIBLE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.GONE);
            }
        });
        Button greenButton = findViewById(R.id.greenButton);
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalColorVariables g = GlobalColorVariables.getInstance();
                g.setData(green);
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.VISIBLE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.GONE);
            }
        });
        Button tealButton = findViewById(R.id.tealButton);
        tealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalColorVariables g = GlobalColorVariables.getInstance();
                g.setData(teal);
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.VISIBLE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.GONE);
            }
        });
        Button blueButton = findViewById(R.id.blueButton);
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalColorVariables g = GlobalColorVariables.getInstance();
                g.setData(blue);
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.VISIBLE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.GONE);
            }
        });
        Button purpleButton = findViewById(R.id.purpleButton);
        purpleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalColorVariables g = GlobalColorVariables.getInstance();
                g.setData(purple);
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.VISIBLE);
                pinkText.setVisibility(View.GONE);
            }
        });
        Button pinkButton = findViewById(R.id.pinkButton);
        pinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalColorVariables g = GlobalColorVariables.getInstance();
                g.setData(pink);
                redText.setVisibility(View.GONE);
                orangeText.setVisibility(View.GONE);
                yellowText.setVisibility(View.GONE);
                greenText.setVisibility(View.GONE);
                tealText.setVisibility(View.GONE);
                blueText.setVisibility(View.GONE);
                purpleText.setVisibility(View.GONE);
                pinkText.setVisibility(View.VISIBLE);
            }
        });
    }
}
