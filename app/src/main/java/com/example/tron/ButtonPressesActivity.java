package com.example.tron;

import android.view.View;

public class ButtonPressesActivity extends MainActivity {
    /**
     * opens the snake arena screen from the Start Game button on activity_main.
     */
    protected void startGame() {
        findViewById(R.id.startGameButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View unused) {
                setContentView(R.layout.activity_game);
            }
        });
    }

    /**
     * opens the settings button from the Settings button in activity_main.
     */
    protected void openSettings() {
        findViewById(R.id.settingsButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View unused) {
                setContentView(R.layout.activity_settings);
            }
        });
    }

    /**
     * opens the color menu from the Color button in player settings.
     */
    protected void openColorMenu() {
        findViewById(R.id.colorButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View unused) {
                setContentView(R.layout.activity_final_color);
            }
        });
    }

    /**
     * closes the color menu and exits to player settings.
     */
    protected void closeColorMenu() {
        findViewById(R.id.backToSettingsFromColor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View unused) {
                setContentView(R.layout.activity_settings);
            }
        });
    }
    /**
     * Opens the design menu from the Design button in player settings.
     */
    protected void openDesignMenu() {
        findViewById(R.id.designButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View unused) {
                setContentView(R.layout.activity_design);
            }
        });
    }
    /**
     * closes the design menu and exits to player settings.
     */
    protected void closeDesignMenu() {
        findViewById(R.id.backToSettingsFromDesign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View unused) {
                setContentView(R.layout.activity_design);
            }
        });
    }

    /**
     * closes the options menu and exits to start screen.
     */
    protected void closeOptions() {
        findViewById(R.id.backFromOptions).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View unused) {
                setContentView(R.layout.activity_main);
            }
        });
    }
}
