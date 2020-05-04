package com.example.tron;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DesignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);

        configureBackFromDesignButton();

        configureSmallArenaButton();
        configureMediumArenaButton();
        configureLargeArenaButton();

        configureSlowPlayerSpeed();
        configureMediumPlayerSpeed();
        configureFastPlayerSpeed();

        Button smallArenaButton = findViewById(R.id.smallArena);
        Button mediumArenaButton = findViewById(R.id.normalArena);
        Button largeArenaButton = findViewById(R.id.largeArena);

        Button slowPlayerSpeed = findViewById(R.id.slowSpeed);
        Button mediumPlayerSpeed = findViewById(R.id.normalSpeed);
        Button fastPlayerSpeed = findViewById(R.id.fastSpeed);

        GlobalSpeedVariables s = GlobalSpeedVariables.getInstance();
        GlobalArenaSizeVariables a = GlobalArenaSizeVariables.getInstance();

        int sT = s.getData();
        int aT = a.getData();
        switch (sT) {
            case (175):
                slowPlayerSpeed.setBackgroundColor(Color.GREEN);
                mediumPlayerSpeed.setBackgroundColor(Color.LTGRAY);
                fastPlayerSpeed.setBackgroundColor(Color.LTGRAY);
                break;
            case (125):
                slowPlayerSpeed.setBackgroundColor(Color.LTGRAY);
                mediumPlayerSpeed.setBackgroundColor(Color.GREEN);
                fastPlayerSpeed.setBackgroundColor(Color.LTGRAY);
                break;
            case (75):
                slowPlayerSpeed.setBackgroundColor(Color.LTGRAY);
                mediumPlayerSpeed.setBackgroundColor(Color.LTGRAY);
                fastPlayerSpeed.setBackgroundColor(Color.GREEN);
                break;
        }
        switch (aT) {
            case (15):
                smallArenaButton.setBackgroundColor(Color.GREEN);
                mediumArenaButton.setBackgroundColor(Color.LTGRAY);
                largeArenaButton.setBackgroundColor(Color.LTGRAY);
                break;
            case (23):
                smallArenaButton.setBackgroundColor(Color.LTGRAY);
                mediumArenaButton.setBackgroundColor(Color.GREEN);
                largeArenaButton.setBackgroundColor(Color.LTGRAY);
                break;
            case (35):
                smallArenaButton.setBackgroundColor(Color.LTGRAY);
                mediumArenaButton.setBackgroundColor(Color.LTGRAY);
                largeArenaButton.setBackgroundColor(Color.GREEN);
                break;
        }

    }

    private void configureBackFromDesignButton() {
        Button backButton = findViewById(R.id.backToSettingsFromDesign);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DesignActivity.this, SettingsActivity.class));
            }
        });

    }

    private void configureSmallArenaButton() {
        final Button smallArenaButton = findViewById(R.id.smallArena);
        final Button mediumArenaButton = findViewById(R.id.normalArena);
        final Button largeArenaButton = findViewById(R.id.largeArena);
        smallArenaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalArenaSizeVariables g = GlobalArenaSizeVariables.getInstance();
                g.setData(15);
                smallArenaButton.setBackgroundColor(Color.GREEN);
                mediumArenaButton.setBackgroundColor(Color.LTGRAY);
                largeArenaButton.setBackgroundColor(Color.LTGRAY);
            }
        });
    }

    private void configureMediumArenaButton() {
        final Button smallArenaButton = findViewById(R.id.smallArena);
        final Button mediumArenaButton = findViewById(R.id.normalArena);
        final Button largeArenaButton = findViewById(R.id.largeArena);
        mediumArenaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalArenaSizeVariables g = GlobalArenaSizeVariables.getInstance();
                g.setData(23);
                smallArenaButton.setBackgroundColor(Color.LTGRAY);
                mediumArenaButton.setBackgroundColor(Color.GREEN);
                largeArenaButton.setBackgroundColor(Color.LTGRAY);
            }
        });
    }

    private void configureLargeArenaButton() {
        final Button smallArenaButton = findViewById(R.id.smallArena);
        final Button mediumArenaButton = findViewById(R.id.normalArena);
        final Button largeArenaButton = findViewById(R.id.largeArena);
        largeArenaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalArenaSizeVariables g = GlobalArenaSizeVariables.getInstance();
                g.setData(35);
                smallArenaButton.setBackgroundColor(Color.LTGRAY);
                mediumArenaButton.setBackgroundColor(Color.LTGRAY);
                largeArenaButton.setBackgroundColor(Color.GREEN);
            }
        });
    }

    private void configureSlowPlayerSpeed() {
        final Button slowPlayerSpeed = findViewById(R.id.slowSpeed);
        final Button mediumPlayerSpeed = findViewById(R.id.normalSpeed);
        final Button fastPlayerSpeed = findViewById(R.id.fastSpeed);
        slowPlayerSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalSpeedVariables g = GlobalSpeedVariables.getInstance();
                g.setData(175);
                slowPlayerSpeed.setBackgroundColor(Color.GREEN);
                mediumPlayerSpeed.setBackgroundColor(Color.LTGRAY);
                fastPlayerSpeed.setBackgroundColor(Color.LTGRAY);
            }
        });
    }

    private void configureMediumPlayerSpeed() {
        final Button slowPlayerSpeed = findViewById(R.id.slowSpeed);
        final Button mediumPlayerSpeed = findViewById(R.id.normalSpeed);
        final Button fastPlayerSpeed = findViewById(R.id.fastSpeed);
        mediumPlayerSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalSpeedVariables g = GlobalSpeedVariables.getInstance();
                g.setData(125);
                slowPlayerSpeed.setBackgroundColor(Color.LTGRAY);
                mediumPlayerSpeed.setBackgroundColor(Color.GREEN);
                fastPlayerSpeed.setBackgroundColor(Color.LTGRAY);
            }
        });
    }

    private void configureFastPlayerSpeed() {
        final Button slowPlayerSpeed = findViewById(R.id.slowSpeed);
        final Button mediumPlayerSpeed = findViewById(R.id.normalSpeed);
        final Button fastPlayerSpeed = findViewById(R.id.fastSpeed);
        fastPlayerSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GlobalSpeedVariables g = GlobalSpeedVariables.getInstance();
                g.setData(75);
                slowPlayerSpeed.setBackgroundColor(Color.LTGRAY);
                mediumPlayerSpeed.setBackgroundColor(Color.LTGRAY);
                fastPlayerSpeed.setBackgroundColor(Color.GREEN);
            }
        });
    }
}
