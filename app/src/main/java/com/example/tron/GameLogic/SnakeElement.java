package com.example.tron.GameLogic;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class SnakeElement {
    /**
     * Position of objecct on the board, as in [x, y]
     */
    private int[] gridPos;

    /**
     * created rectangle of object
     */
    private Rect rect = new Rect();

    /**
     * Paint of the object
     */
    private Paint bodyPaint = new Paint();

    /**
     * Sets objects grid position and makes the object rectangle
     * @param xPos Object's x coordinate
     * @param yPos Object's y coordinate
     */
    public SnakeElement(int xPos, int yPos) {
        gridPos = new int[2];
        gridPos[0] = xPos;
        gridPos[1] = yPos;
        makeRect();
        bodyPaint.setColor(Color.GREEN);
    }

    /**
     * Creates the Object rectangle
     */
    private void makeRect() {
        rect.top = gridPos[1] * GridLogic.getSpacing();
        rect.bottom = (gridPos[1] + 1) * GridLogic.getSpacing();
        rect.left = gridPos[0] * GridLogic.getSpacing();
        rect.right = (gridPos[0] + 1) * GridLogic.getSpacing();
    }

    /**
     * return's object grid position
     * @return object grid position as in [x, y]
     */
    public int[] getGridPos() {
        return gridPos;
    }

    /**
     * sets object grid position
     * @param setGridPos grid position of object as in [x, y]
     */
    public void setGridPos(int[] setGridPos) {
        gridPos = setGridPos;
        makeRect();
    }

    /**
     * returns rect of object
     * @return Rect of Object
     */
    public Rect getRect() {
        return rect;
    }

    /**
     * sets color for object as an int
     * @param color int for the object's color
     */
    public void setBodyPaint(int color) {
        bodyPaint.setColor(color);
    }

    /**
     * return's Paint for object
     * @return Paint for object
     */
    public Paint getBodyPaint() {
        return bodyPaint;
    }
}
