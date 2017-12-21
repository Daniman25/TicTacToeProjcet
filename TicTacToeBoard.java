package com.ouilikon.daniel.tictactoegameproject;

/**
 * Created by 301082 on 12/13/17.
 */


import android.graphics.Canvas;
import android.graphics.Paint;

public class TicTacToeBoard
{
    private int myTopEdge;                      // Top Edge of TTT Board
    private int myLeftEdge;                     // Left Edge of TTT Board
    private int mySquareWidth;                  // Width of TTT Board

    public final char PLAYER1_SYMBOL = 'x';
    public final char PLAYER2_SYMBOL = 'o';

    // default constructor

    public TicTacToeBoard()
    {
        myTopEdge = 50;
        myLeftEdge = 600;
        mySquareWidth = 100;
    }

    // "other" constructor

    public TicTacToeBoard(int topEdge, int leftEdge, int squareWidth)
    {
        myTopEdge = topEdge;
        myLeftEdge = leftEdge;
        mySquareWidth = squareWidth;
    }

    // modifier methods
    public void setTopEdge(int topEdge)
    {
        myTopEdge = topEdge;
    }

    public void setLeftEdge(int leftEdge)
    {
        myLeftEdge = leftEdge;
    }

    public void setSquareWidth(int squareWidth)
    {
        mySquareWidth = squareWidth;
    }

    public void drawBoard(Canvas canvas, Paint pen)
    {
        canvas.drawLine(myLeftEdge, myTopEdge + mySquareWidth, myLeftEdge + mySquareWidth * 3, myTopEdge + mySquareWidth, pen);           // top horizontal line
        canvas.drawLine(myLeftEdge, myTopEdge + mySquareWidth * 2, myLeftEdge + mySquareWidth * 3, myTopEdge + mySquareWidth * 2, pen);   // bottom horizontal line
        canvas.drawLine(myLeftEdge + mySquareWidth,       myTopEdge, myLeftEdge + mySquareWidth,     myTopEdge + mySquareWidth * 3, pen); // left vertical line
        canvas.drawLine(myLeftEdge + mySquareWidth * 2,   myTopEdge, myLeftEdge + mySquareWidth * 2, myTopEdge + mySquareWidth * 3, pen); // right vertical line

    }

    public void placeLetter(Canvas canvas, Paint pen, char symbol, int row, int col)
    {
        if (row == 0 && col == 0 && symbol == PLAYER1_SYMBOL)               // x in upper-left corner
        {
            canvas.drawLine(myLeftEdge, myTopEdge, myLeftEdge + mySquareWidth, myTopEdge + mySquareWidth, pen);
            canvas.drawLine(myLeftEdge, myTopEdge + mySquareWidth, myLeftEdge + mySquareWidth, myTopEdge, pen);
        }
        // TODO: add else if's here
        if (row == 0 && col == 1 && symbol == PLAYER2_SYMBOL)               // o in upper-middle position
        {
            canvas.drawCircle(Math.round(myLeftEdge + mySquareWidth * 1.5), Math.round(myTopEdge + mySquareWidth / 2), Math.round(mySquareWidth / 2), pen);
        }
        // TODO: add else if's here
    }
    // TODO: add checks for win detection, draw game detection, cheat detection, etc.
}


