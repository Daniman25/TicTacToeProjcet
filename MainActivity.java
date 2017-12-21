/**
 TicTacToeGameProject
 @author Daniel Ouilikon Period 5/6
 */
/*
package com.minich.drawingdemotictactoe;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity
{
    DemoView demoView;          // custom view for this demo program's Activity (not using
    // R.layout.activity_main that Android Studio provides by default
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        demoView = new DemoView(this);
        setContentView(demoView);
    }
    private class DemoView extends View
    {
        public DemoView(Context context)
        {
            super(context);
        }
        @Override protected
        void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            int screenWidth = getWidth();      // width of the View object but can be thought of as the canvas width
            int screenHeight = getHeight();    // canvas height (TODO: figure out how to account for height of action bar)
            Paint paint = new Paint();              // general, miscellaneous paint tasks
            Paint greenPen = new Paint();           // green "pen" that does not fill
            greenPen.setColor(Color.GREEN);
            greenPen.setStyle(Paint.Style.STROKE);  // creating a "pen" that does not fill in regions
            greenPen.setStrokeWidth(10);            // width of the pen's stroke
            //greenPen.setAntiAlias(true);			// smooth edges
            // paint the background of the View's canvas
            //paint.setColor(Color.BLACK);
            //canvas.drawPaint(paint);
            // draw a tic tac toe board
            TicTacToeBoard myBoard = new TicTacToeBoard(0, 0, screenWidth / 3);
            myBoard.drawBoard(canvas, greenPen);
            myBoard.placeLetter(canvas, greenPen, 'x', 0, 0);
            myBoard.placeLetter(canvas, greenPen, 'o', 0, 1);
            // TODO: fill the board with 5 x's and 4 o's showing a tie game using the 'ttt' variables above &/or additional variables (no magic numbers)
        }
    }
}

*/

/**
 Daniel Ouilikon
 @author John Doe Period 5/6
 */

package com.ouilikon.daniel.tictactoegameproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity
{
    TicTacToeBoardView ticTacToeBoardView;      // View with tic tac toe board

    // initialize the Activity with the View of the tic tac toe board
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ticTacToeBoardView = new TicTacToeBoardView(this);
        setContentView(ticTacToeBoardView);
    }

    // tic tac toe board view
    private class TicTacToeBoardView extends View
    {
        private String board[][] = {{"","",""},{"","",""},{"","",""}};  // tic tac toe board
        private String playerTurn = "x";                                // whose turn is it "x" or "o"
        private boolean XIsWinner = false;                              // did x win?

        public TicTacToeBoardView(Context context)
        {
            super(context);
        }

        // draw tic tac toe board
        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);

            Paint paint = new Paint();
            paint.setStrokeWidth(3);
            paint.setColor(Color.BLUE);
            paint.setStyle(Paint.Style.STROKE);

            int screenWidth = getWidth();      // width of the View object but can be thought of as the canvas width
            int screenHeight = getHeight();    // canvas height (TODO: figure out how to account for height of action bar)

            Paint greenPen = new Paint();           // green "pen" that does not fill
            greenPen.setColor(Color.GREEN);
            greenPen.setStyle(Paint.Style.STROKE);  // creating a "pen" that does not fill in regions
            greenPen.setStrokeWidth(10);            // width of the pen's stroke
            //greenPen.setAntiAlias(true);			// smooth edges

            // draw tic tac toe board

            // vertical lines
            //canvas.drawLine(100, 0, 100, 300, paint);
            //canvas.drawLine(200, 0, 200, 300, paint);
            //canvas.drawLine(0, 100, 300, 100, paint);
            //canvas.drawLine(0, 200, 300, 200, paint);

            // draw x's and o's
            if (board[0][0].equals("x"))
            {
                // place x in top left corner of board
                canvas.drawLine(0, 0, 100, 100, paint);
                canvas.drawLine(100,  0, 0, 100, paint);
            }
            else if (board[0][0].equals("o"))
            {
                // draw circle in top left corner of board
                canvas.drawCircle();
            }

            if (board[0][1].equals("x"))
            {
                // place x in top middle of board
                canvas.drawLine(100, 0, 200, 100, paint);
                canvas.drawLine(200, 0, 100, 100, paint);
            }
            else if (board[0][1].equals("o"))
            {
                // draw circle top middle of board
            }

            // more if/else if statements for rest of the board

            // announcing winner or draw
            if (XIsWinner)
            {
                canvas.drawText("X Wins", 10, 10, paint);
            }




            // draw a tic tac toe board

            TicTacToeBoard myBoard = new TicTacToeBoard(0, 0, screenWidth / 3);

            myBoard.drawBoard(canvas, greenPen);

            myBoard.placeLetter(canvas, greenPen, 'x', 0, 0);
            myBoard.placeLetter(canvas, greenPen, 'o', 0, 1);






        }

        // detect jeremy's touch
        public boolean onTouchEvent(MotionEvent event)
        {

            if (event.getAction() == MotionEvent.ACTION_UP)
            {
                double x = event.getX();     // x coordinate of user's click
                double y = event.getY();     // y coordinate of user's click

                // determine player's last move
                if (x >= 0 && x <= 100 && y >= 0 && y <= 100)        // board[0][0]
                {
                    board[0][0] = playerTurn;
                }
                else if (x >= 100 && x <= 200 && y >= 0 && y <= 100) // board[0][1]
                {
                    board[0][1] = playerTurn;
                }
                else if (x >= 100 && x <= 200 && y >= 0 && y <= 100) // board[0][2]
                {
                    board[0][2] = playerTurn;
                }
                else if (x >= 100 && x <= 200 && y >= 0 && y <= 100) // board[1][1]
                {
                    board[1][0] = playerTurn;
                }
                else if (x >= 100 && x <= 200 && y >= 0 && y <= 100) // board[1][2]
                {
                    board[1][1] = playerTurn;
                }
                else if (x >= 100 && x <= 200 && y >= 0 && y <= 100) // board[1][1]
                {
                    board[1][2] = playerTurn;
                }
                else if (x >= 100 && x <= 200 && y >= 0 && y <= 100) // board[2][0]
                {
                    board[2][0] = playerTurn;
                }
                else if (x >= 100 && x <= 200 && y >= 0 && y <= 100) // board[2][1]
                {
                    board[2][1] = playerTurn;
                }
                else if (x >= 100 && x <= 200 && y >= 0 && y <= 100) // board[2][2]
                {
                    board[2][2] = playerTurn;
                }



                // win/draw detection
                if (board[0][0].equals("x") && board[0][1].equals("x") && board[0][2].equals("x"))
                {
                    XIsWinner = true;
                }
                // else if...

                // toggling player turn
                if (playerTurn.equals("x"))
                {
                    playerTurn = "o";
                }
                else
                {
                    playerTurn = "x";
                }

                invalidate();        // redraw the View by calling onDraw
            }

            return true;

        }// end of onTouchEvent

    }// end of TicTacToeBoardView class
}
