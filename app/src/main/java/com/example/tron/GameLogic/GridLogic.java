package com.example.tron.GameLogic;

public class GridLogic {
    /**
     * Desired size of board ex 15 * 15
     */
    private static int size;

    /**
     * Spacing between grid squares
     */
    private static int spacing;

    /**
     * total board size
     */
    private static int boardsize;

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

    public static void setSpacing(int setSpacing) {
        spacing = setSpacing;
    }

    public static int getSpacing() {
        return spacing;
    }

    public static void setBoardsize(int setBoardSize) {
        boardsize = setBoardSize;
    }

    public static int getBoardsize() {
        return boardsize;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int setScore) {
        score = setScore;
    }
}
