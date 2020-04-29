package com.example.tron.GameLogic;

import android.graphics.Rect;

public class SnakeElement {
    private int topSide;
    private int bottomSide;
    private int leftSide;
    private int rightSide;
    private int[] gridPos;
    private Rect rect = new Rect();

    public SnakeElement(int xPos, int yPos) {
        gridPos = new int[2];
        gridPos[0] = xPos;
        gridPos[1] = yPos;
    }
    public SnakeElement() { }

    public void setTopSide(int setTopSide) {
        topSide = setTopSide;
        updateRect();
    }
    public void setBottomSide(int setBottomSide) {
        bottomSide = setBottomSide;
        updateRect();
    }
    public void setLeftSide(int setLeftSide) {
        leftSide = setLeftSide;
        updateRect();
    }
    public void setRightSide(int setRightSide) {
        rightSide = setRightSide;
        updateRect();
    }
    public int getTopSide() {
        return topSide;
    }
    public int getBottomSide() {
        return bottomSide;
    }
    public int getLeftSide() {
        return leftSide;
    }
    public int getRightSide() {
        return rightSide;
    }
    public int[] getGridPos() {
        return gridPos;
    }
    public void setGridPos(int[] setGridPos) {
        gridPos = setGridPos;
    }
    private void updateRect() {
        rect.top = getTopSide();
        rect.bottom = getBottomSide();
        rect.left = getLeftSide();
        rect.right = getRightSide();
    }
    public Rect getRect() {
        return rect;
    }
}
