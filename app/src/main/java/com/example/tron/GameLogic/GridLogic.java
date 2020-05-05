package com.example.tron.GameLogic;

public class GridLogic {
    /**
     * Desired size of board ex 15 * 15
     */
    private static int size = 23;

    /**
     * Spacing between grid squares
     */
    private static float spacing;

    /**
     * total board size
     */
    private static float boardsize;

    /**
     * score for the current game
     */
    private static int score;

    public static void setSize(int setSize) {
        size = setSize;
    }

    public static int getSize() {
        return size;
    }

    public static void setSpacing(float setSpacing) {
        spacing = setSpacing;
    }

    public static float getSpacing() {
        return spacing;
    }

    public static void setBoardsize(float setBoardSize) {
        boardsize = setBoardSize;
    }

    public static float getBoardsize() {
        return boardsize;
    }
}
