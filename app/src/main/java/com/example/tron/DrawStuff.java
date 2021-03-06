package com.example.tron;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.tron.GameLogic.GridLogic;
import com.example.tron.GameLogic.SnakeElement;

import java.util.ArrayList;
import java.util.List;

public class DrawStuff extends View {

    DisplayMetrics metrics = getResources().getDisplayMetrics();

    /**
     * paint color of the snake
     */
    private Paint rectPaint;

    /**
     * Paint color of the grid lines
     */
    private Paint linePaint;

    /**
     * first body part of the snake
     */
    private static SnakeElement firstBody;

    private static SnakeElement fruit;

    /**
     * List of SnakeElement objects that comprise of the full snake
     */
    private static List<SnakeElement> fullSnake = new ArrayList<>();

    /**
     * verticle grid lines that get drawn
     */
    private float[] verticalLines;
    /**
     * horizontal grid lines that get drawn
     */
    private float[] horizontalLines;

    /**
     * array of booleans with 1 true value determining direction snake is going
     * goes [North, East, South, West]
     */
    private static boolean[] direction = new boolean[4];

    /**
     * Gridpos of last body part, default is y - 1
     */
    private int[] lastBodyLastPos;

    /**
     * score of game as in amount of fruit collected
     */
    public static int score = 0;

    /**
     * amount of ticks that have passed
     */
    private static int tick = 0;

    /**
     * boolean whether game is running
     */
    private static boolean gameState = true;

    Context context;

    public DrawStuff(Context context) {
        super(context);
        this.context = context;
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

    /**
     * kinda like the constructor for this class, is run before the canvas is made
     * @param set i honestly don't know what this is
     */
    protected void init(@Nullable AttributeSet set) {
        rectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        rectPaint.setColor(Color.GREEN);
        linePaint.setColor(Color.BLACK);
        linePaint.setStyle(Paint.Style.STROKE);
        tick = 0;
        startGame();
    }

    public void everyTick() {
        //150 = normal speed
        ///225 = slow speed
        ///75 = fast speed
        GlobalSpeedVariables v = GlobalSpeedVariables.getInstance();
        new CountDownTimer(15000000, v.getData()) {

            public void onTick(long millisUntilFinished) {
                if (gameState) {
                    postInvalidate();
                } else {
                    cancel();
                }
            }

            public void onFinish() {
                cancel();
                gameState = false;
            }
        }.start();
    }

    /**
     * Draws the stuff
     * @param canvas canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        makeLines(canvas);
        if (tick == 0) {
            score = 0;
            createBody();
            createFruit();
            everyTick();
        }
        while (collectFruit()) {
            addBody();
            createFruit();
        }
        for (int i = 0; i < fullSnake.size(); i++) {
            canvas.drawRect(fullSnake.get(i).getRect(), fullSnake.get(i).getBodyPaint());
        }
        if ((!checkValidGridPos(firstBody.getGridPos()) || snakeRule()) && gameState) {
            gameState = false;
            try {
                endGame();
            } catch (Exception e) {
                Log.println(Log.WARN, "Exception", "boobs " + e);
            }
        } else {
            moveInDirection();
            canvas.drawLines(horizontalLines, linePaint);
            canvas.drawLines(verticalLines, linePaint);
            canvas.drawRect(fruit.getRect(), fruit.getBodyPaint());
            lastBodyLastPos = fullSnake.get(fullSnake.size() - 1).getGridPos();
            tick++;
        }
    }

    /**
     * makes the lines for the grid, also creates the firstBody snake;
     * @param canvas canvas
     */
    private void makeLines(Canvas canvas) {
        int temp;
        float startX;
        float stopX;
        float startY;
        float stopY;

        float width = canvas.getWidth();

        // SIZE MUST ALWAYS BE ODD NUMBER ABOVE 9
        //small: 15
        //normal: 23
        //large: 35
        GlobalArenaSizeVariables x = GlobalArenaSizeVariables.getInstance();
        GridLogic.setSize(x.getData());
        if (GridLogic.getSize() <= 0) {
            GridLogic.setSize(23);
        }
        GridLogic.setSpacing(width / GridLogic.getSize());

        GridLogic.setBoardsize(GridLogic.getSize() * GridLogic.getSpacing());

        verticalLines = new float[(GridLogic.getSize() + 1) * 4];
        //vertical lines
        for (int i = 0; i <= GridLogic.getSize(); i++) {

            startX = i * GridLogic.getSpacing();
            startY = 0;

            stopX = startX;
            stopY = GridLogic.getBoardsize();


            temp = i * 4;
            verticalLines[temp] = startX;
            verticalLines[temp + 1] = startY;
            verticalLines[temp + 2] = stopX;
            verticalLines[temp + 3] = stopY;
        }
        horizontalLines = new float[(GridLogic.getSize() + 1) * 4];
        //horizontal lines
        for (int i = 0; i <= GridLogic.getSize(); i++) {

            startX = 0;
            startY = i * GridLogic.getSpacing();

            stopX = GridLogic.getBoardsize();
            stopY = startY;
            temp = i * 4;
            horizontalLines[temp] = startX;
            horizontalLines[temp + 1] = startY;
            horizontalLines[temp + 2] = stopX;
            horizontalLines[temp + 3] = stopY;
        }
        if (tick == 0) {
            direction[0] = true;
            direction[1] = false;
            direction[2] = false;
            direction[3] = false;
            firstBody = new SnakeElement((int) Math.floor(GridLogic.getSize()/2), (int) Math.floor(GridLogic.getSize()/2));
            GlobalColorVariables g = GlobalColorVariables.getInstance();
            firstBody.setBodyPaint(g.getData());
            fullSnake.add(firstBody);
            fullSnake.add(firstBody);
        }
    }

    /**
     * creates the SnakeElement Objects besides firstBody
     */
    private void createBody() {
        for (int i = 1; i <= 4; i++) {
            SnakeElement body = new SnakeElement(firstBody.getGridPos()[0], firstBody.getGridPos()[1] + i);
            body.setBodyPaint(Color.GREEN);
            fullSnake.add(body);
        }
        int[] gridPos = fullSnake.get(fullSnake.size() - 1).getGridPos();
        gridPos[1] = gridPos[1] + 1;
        lastBodyLastPos = gridPos;
    }

    /**
     * moves single body part up
     */
    private static void moveUp() {
        followBody();
        int[] pos = new int[2];
        pos[0] = (firstBody.getGridPos()[0]);
        pos[1] = (firstBody.getGridPos()[1] - 1);
        firstBody.setGridPos(pos);
    }

    /**
     * moves single body part down
     */
    private static void moveDown() {
        followBody();
        int[] pos = new int[2];
        pos[0] = (firstBody.getGridPos()[0]);
        pos[1] = (firstBody.getGridPos()[1] + 1);
        firstBody.setGridPos(pos);
    }

    /**
     * moves firstBody left
     */
    private static void moveLeft() {
        followBody();
        int[] pos = new int[2];
        pos[0] = (firstBody.getGridPos()[0] - 1);
        pos[1] = (firstBody.getGridPos()[1]);
        firstBody.setGridPos(pos);
    }

    /**
     * mvoes single body part right
     */
    private static void moveRight() {
        followBody();
        int[] pos = new int[2];
        pos[0] = (firstBody.getGridPos()[0] + 1);
        pos[1] = (firstBody.getGridPos()[1]);
        firstBody.setGridPos(pos);
    }

    /**
     * function that assigns each body part to the body part in front of it's position besides firstBody
     */
    private static void followBody() {
        int[] pos = firstBody.getGridPos();
        int[] temp;
        for (int i = 1; i < fullSnake.size(); i++) {
            temp = fullSnake.get(i).getGridPos();
            fullSnake.get(i).setGridPos(pos);
            pos = temp;
        }
    }

    /**
     * Adds a body part to the snake and also updates score
     */
    private void addBody() {
        SnakeElement body = new SnakeElement(lastBodyLastPos[0], lastBodyLastPos[1]);
        fullSnake.add(body);
        score++;
    }

    /**
     * creates the fruit square as a snakeEleemnt Object
     */
    private void createFruit() {
        int[] gridPos = createRandomGridPos();
        fruit = new SnakeElement(gridPos[0], gridPos[1]);
        fruit.setBodyPaint(Color.CYAN);
    }

    /**
     * Generates a random valid position on the board
     * @return gridpos as int[x, y]
     */
    private int[] createRandomGridPos() {
        int[] gridPos = new int[2];
        gridPos[0] = (int)Math.floor((Math.random() * GridLogic.getSize()));
        gridPos[1] = (int)Math.floor((Math.random() * GridLogic.getSize()));
        return gridPos;
    }

    /**
     * check's if the specified gridpos is valid
     * @param gridPos grid pos to be checked
     * @return boolean whether a position is valid
     */
    private boolean checkValidGridPos(int[] gridPos) {
        for (int i : gridPos) {
            if (i > GridLogic.getSize() - 1 || i < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * returns whether a snake is violating the snake rule
     * @return if the snake is on top of itself
     */
    private boolean snakeRule() {
        int counter = 0;
        for (int i = 1; i < fullSnake.size(); i++) {
            if (counter != 0) {
                if (firstBody.getGridPos()[0] == fullSnake.get(i).getGridPos()[0]
                        && firstBody.getGridPos()[1] == fullSnake.get(i).getGridPos()[1]) {
                    return true;
                }
            }
            counter++;
        }
        return false;
    }

    /**
     * returns whether a snake bodypart is on the same square as the fruit
     * @return boolean whether the snake is on the same square as the fruit
     */
    private boolean collectFruit() {
        for (SnakeElement b : fullSnake) {
            if (b.getGridPos()[0] == fruit.getGridPos()[0] && b.getGridPos()[1] == fruit.getGridPos()[1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * moves the snake in the direction it is going
     */
    private static void moveInDirection() {
        for (int i = 0; i < direction.length; i++) {
            if (direction[i]) {
                if (i == 0) {
                    moveUp();
                }
                if (i == 1) {
                    moveRight();
                }
                if (i == 2) {
                    moveDown();
                }
                if (i == 3) {
                    moveLeft();
                }
                break;
            }
        }
    }

    /**
     * updates the directions to move the snake where it should be going if right button is pushed
     */
    public static void rightButton() {
        for (int i = 0; i < direction.length; i++) {
            if (direction[i]) {
                if (i == 0) {
                    direction[0] = false;
                    direction[1] = true;
                }
                if (i == 1) {
                    direction[1] = false;
                    direction[2] = true;
                }
                if (i == 2) {
                    direction[2] = false;
                    direction[1] = true;
                }
                if (i == 3) {
                    direction[3] = false;
                    direction[0] = true;
                }
                break;
            }
        }
    }

    /**
     * updates the directions to move the snake where it should be going if left button is pushed
     */
    public static void leftButton() {
        for (int i = 0; i < direction.length; i++) {
            if (direction[i]) {
                if (i == 0) {
                    direction[0] = false;
                    direction[3] = true;
                }
                if (i == 1) {
                    direction[1] = false;
                    direction[0] = true;
                }
                if (i == 2) {
                    direction[2] = false;
                    direction[3] = true;
                }
                if (i == 3) {
                    direction[3] = false;
                    direction[2] = true;
                }
                break;
            }
        }
    }

    public void endGame() {
        Intent i = new Intent(context, GameOverActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    /**
     * starts the game
     */
    public void startGame() {
        tick = 0;
        gameState = true;
        fullSnake.clear();
        postInvalidate();
    }


}
