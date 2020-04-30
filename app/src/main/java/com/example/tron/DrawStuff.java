package com.example.tron;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;


import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.tron.GameLogic.SnakeElement;

import java.util.HashMap;
import java.util.Map;

public class DrawStuff extends View {

    DisplayMetrics metrics = getResources().getDisplayMetrics();
    private Paint rectPaint;
    private Paint linePaint;
    private SnakeElement firstBody;
    private Map<Integer, SnakeElement> fullSnake = new HashMap<>();
    private int bodyLength;
    /**
     * size of square of grid (Ex. 25 x 25).
     */
    private int size;
    /**
     * Spacing between each square of grid.
     */
    private int spacing;
    /**
     * boardSize(should be same as size but able to be changed).
     */
    private int boardSize;
    /**
     * Drawable for center box of grid
     */
    private float[] verticalLines;
    private float[] horizontalLines;

    public DrawStuff(Context context) {
        super(context);
        init(null);
    }

    public DrawStuff(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DrawStuff(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DrawStuff(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    protected void init(@Nullable AttributeSet set) {
        rectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectPaint.setColor(Color.GREEN);
        linePaint.setColor(Color.BLACK);
        linePaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        makeLines(canvas);
        createBody();
        for (int i = 0; i < fullSnake.size(); i++) {
            canvas.drawRect(fullSnake.get(i).getRect(), rectPaint);
        }
        canvas.drawLines(horizontalLines, linePaint);
        canvas.drawLines(verticalLines, linePaint);
    }

    private void makeLines(Canvas canvas) {
        int temp;
        float startX;
        float stopX;
        float startY;
        float stopY;

        int width = canvas.getWidth();

        // SIZE MUST ALWAYS BE ODD NUMBER ABOVE 5
        size = 15;
        spacing = width / size;
        boardSize = size * spacing;
        firstBody = new SnakeElement((int) Math.floor(size/2), (int) Math.floor(size/2));

        verticalLines = new float[(size + 1) * 4];
        //vertical lines
        for (int i = 0; i <= size; i++) {

            startX = i * spacing;
            startY = 0;

            stopX = startX;
            stopY = boardSize;
            if (i == Math.floor((int)(size/2))) {
                firstBody.setLeftSide((int) startX);
            }
            if (i == Math.ceil((int)(size/2)) + 1) {
                firstBody.setRightSide((int) startX);
            }
            temp = i * 4;
            verticalLines[temp] = startX;
            verticalLines[temp + 1] = startY;
            verticalLines[temp + 2] = stopX;
            verticalLines[temp + 3] = stopY;
        }

        horizontalLines = new float[(size + 1) * 4];
        //horizontal lines
        for (int i = 0; i <= size; i++) {

            startX = 0;
            startY = i * spacing;

            stopX = boardSize;
            stopY = startY;
            if (i == Math.floor((int)(size/2))) {
                firstBody.setTopSide((int) startY);
            }
            if (i == Math.floor((int)(size/2)) + 1) {
                firstBody.setBottomSide((int) startY);
                bodyLength = i;
            }
            temp = i * 4;
            horizontalLines[temp] = startX;
            horizontalLines[temp + 1] = startY;
            horizontalLines[temp + 2] = stopX;
            horizontalLines[temp + 3] = stopY;
        }
        fullSnake.put(0, firstBody);
    }

    private void createBody() {
        for (int i = 1; i <= 4; i++) {
            SnakeElement body = new SnakeElement(firstBody.getGridPos()[0], firstBody.getGridPos()[1] + i);
            body.setBottomSide(firstBody.getBottomSide()+ (spacing * i));
            body.setLeftSide(firstBody.getLeftSide());
            body.setRightSide(firstBody.getRightSide());
            body.setTopSide(firstBody.getTopSide() + (spacing * i));
            fullSnake.put(i, body);
        }
    }


}
