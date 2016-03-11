package board;

import ai.BoardValue;
import pieces.*;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;
import java.lang.Iterable;
import java.util.Iterator;

/**
 * ** Board Class **
 * Represents the chess board, implements iterator and finds ChessPieces.
 *
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class Board extends BoardValue implements Iterable<ChessPiece>{
   public static int UP_LEFT = 0;
   public static int UP = 1;
   public static int UP_RIGHT = 2;
   public static int RIGHT = 3;
   public static int DOWN_RIGHT = 4;
   public static int DOWN = 5;
   public static int DOWN_LEFT = 6;
   public static int LEFT = 7;

   public ChessPiece[] board;
   private int currentValue;

   /**
    * Constructor for Board
    */
   public Board(){
      board = new ChessPiece[64];
      setupBoard();
   }

   /**
    * setupBoard
    * Add the correct pieces to the board
    */
   private void setupBoard(){
      board[0] = new Bishop(this, true);
      board[1] = new Bishop(this, true);
   }

   /**
    * Move
    *
    * Puts the piece on the designated end spot and sets
    * the start spot to null
    *
    * @param Move object denoting where to move the object
    */
   public void move(Move move){
      ChessPiece p = board[move.getStart()];
      board[move.getEnd()] = p;
      board[move.getStart()] = null;
   }


   /**
    * @return the value of the board
    */
    public int getValue(){
      int currentValue = 0;

      for (int i = 0; i < board.length; i++){
         if (board[i] != null){
            currentValue += board[i].getValue();
         }
      }
      return currentValue;
    }

    public boolean isCheckmate(boolean white){
       return false;
    }

   /**
    * @param int the desired direction of iteration
    * @return a board iterator that iterates through the direction specified
    */
   public BoardIterator<ChessPiece> boardIterator(int direction, int index){
      return new MyIterator(direction, index);
   }

   public Iterator<ChessPiece> iterator(){
      return new MyIterator(3,0);
   }

   /**
    * toString
    * @return a String representation of the Board
    */
   public String toString(){
      String result = "";

      int min = 56;
      while(min > -1){
         for(int i = min; i < min + 8; i++){
            if(board[i] == null){
               result += " O";
            }else{
               result += " " +  board[i].toString();
            }
         }
         result += "\n";
         min -= 8;
      }
      return result;   
   }

   private class MyIterator extends BoardIterator<ChessPiece>{
      public int buffer;
      public int minIndex;
      public int maxIndex;
      public int index;

      /**
       * Constructor of BoardIterator taking parameters for direction and index
       * @param int the desired direction of iteration
       * @param int the desired starting index of the iterator
       */
      public MyIterator(int direction, int index){
         if (direction == 0){
            buffer = 7;
         }
         else if (direction == 1){
            buffer = 8;
         }
         else if (direction == 2){
            buffer = 9;
         }
         else if (direction == 3){
            buffer = 1;
         }
         else if (direction == 4){
            buffer = -7;
         }
         else if (direction == 5){
            buffer = -8;
         }
         else if (direction == 6){
            buffer = -9;
         }
         else{ //direction == 7
            buffer = -1;
         }

         this.index = index;
      }

      /**
      * Default BoardIterator constructor
      */
      public MyIterator(){
         buffer = 3;
         index = 0;
      }

      /**
       * Determines whether there is another spot in the direction specified
       * @return boolean true if there is a next element
       */
      public boolean hasNext(){
         if (buffer < 0){ //buffer is negative
            if (index <= index + 8*buffer - 8*(index%buffer)){
               return true;
            }
         }
         else{ //Buffer is positive (buffer is never 0)
            if (index > buffer){
               return true;
            }
         }
         // Temporary:if (index <= 8*buffer && index >= 0)TODO: index >= 0 will not work
         return false;
      }

      /**
       * Gets the next chesspiece in the iterator and adds to iterator index
       * @return the next ChessPiece
       */
      public ChessPiece next(){
         if (!hasNext()){
            throw new NoSuchElementException();
         }
         index += buffer;
         return board[index];
      }

      /**
       * getIndex
       * @return the current index of the iterator
       */
      public int index(){
         return index;
      }
      
      /**
       * Removes and item from the iterator
       * @throws UnsupportedOperationException
       */
      public void remove(){
         throw new UnsupportedOperationException();
      }
   }
}
