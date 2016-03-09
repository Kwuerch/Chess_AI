package board;

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;
import java.lang.Iterable;
import java.util.Iterator;
import pieces.ChessPiece;
import ai.BoardValue;

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

   /**
    * Constructor for Board
    */
   public Board(){
      board = new ChessPiece[64];
   }

   /**
    * @return the value of the board
    */
    public int getValue(){ //TODO: Implement getValue from Abstract Class
      return -1;
    }

   /**
    * @param int the desired direction of iteration
    * @return a board iterator that iterates through the direction specified
    */
   public Iterator<ChessPiece> boardIterator(int direction, int index){
      return new BoardIterator(direction, index);
   }
   public Iterator<ChessPiece> iterator(){
      //return new Iterator(3, 0);
      return new BoardIterator(3,0);
   }
   private class BoardIterator implements Iterator<ChessPiece>{
      public int buffer;
      public int minIndex;
      public int maxIndex;
      public int index;

      public BoardIterator(int direction, int index){
         //this.direction = direction;
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
      /*
      switch(direction){
         case 0:
            buffer = 7;
            break;
         case 1:
            buffer = 8;
            break;
         case 2:
            buffer = 9;
            break;
         case 3:
            buffer = 1;
            break;
         case 4:
            buffer = -7;
            break;
         case 5:
            buffer = -8;
            break;
         case 6:
            buffer = -9;
            break;
         case 7:
            buffer = -1;
            break;
         default:
            buffer = 1;
            break;
      }*/

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
       * Removes and item from the iterator
       * @throws UnsupportedOperationException
       */
      public void remove(){
         throw new UnsupportedOperationException();
      }
   }
}
