package com.example.tron;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;


import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DrawStuff extends View {

    DisplayMetrics metrics = getResources().getDisplayMetrics();
    private Rect rect;
    private Paint rectPaint;
    private Paint linePaint;
    private float[] horizontalLines;
    private float[] verticalLines;
    private float dimensions = 1000;

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
        rect = new Rect();
        rectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.BLACK);
        linePaint.setStyle(Paint.Style.STROKE);
        // size is going to be input by user 1-5 sizes is a thing i guess, gonna keep it 1 for now
        // drawLines goes [x0, y0, x1, y1] etc.
        int size = 21;
        horizontalLines = new float[(size * 4)];
        verticalLines = new float[size * 4];
        // horizontal lines
        float offset = dimensions / size;
        float lastCoord = (((horizontalLines.length - 4)/4) * offset) + 24;
        for (int i = 0; i < horizontalLines.length; i += 4) {
            horizontalLines[i] = 24;
            horizontalLines[i + 1] = (offset * (i/4)) + 24;
            horizontalLines[i + 2] = lastCoord;
            horizontalLines[i + 3] = (offset * (i/4)) + 24;
        }
        // verticle lines
        for (int i = 0; i < verticalLines.length; i += 4) {
            verticalLines[i + 1] = 24;
            verticalLines[i] = (offset * (i/4)) + 24;
            verticalLines[i + 3] = lastCoord;
            verticalLines[i + 2] = (offset * (i/4)) + 24;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        rect.left = 0;
        rect.top = 0;
        rect.right = 1000;
        rect.bottom = 1000;
        rectPaint.setColor(Color.BLACK);
        canvas.drawLines(horizontalLines, linePaint);
        canvas.drawLines(verticalLines, linePaint);
//        canvas.drawRect(rect, rectPaint);
    }
}
