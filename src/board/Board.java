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
   public static final int UP_LEFT = 0;
   public static final int UP = 1;
   public static final int UP_RIGHT = 2;
   public static final int RIGHT = 3;
   public static final int DOWN_RIGHT = 4;
   public static final int DOWN = 5;
   public static final int DOWN_LEFT = 6;
   public static final int LEFT = 7;

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
      board[0] = new Rook(this, true);
      board[1] = new Rook(this, true);
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
      System.out.println("Hell");
      return new MyIterator(direction, index);
   }


   /**
    * iterator
    * @return a default iterator to go through each space
    */
   public BoardIterator<ChessPiece> iterator(){
      System.out.println("E");
      return new MyIterator();
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
      public boolean normal; // True if a normal iterator

      /**
       * Constructor of BoardIterator taking parameters for direction and index
       * @param int the desired direction of iteration
       * @param int the desired starting index of the iterator
       */
      public MyIterator(int direction, int index){
         normal = false;
         switch(direction){
            case UP_LEFT:
               buffer = 7;
               break;
            case UP:
               buffer = 8;
               break;
            case UP_RIGHT:
               buffer = 9;
               break;
            case RIGHT:
               buffer = 1;
               break;
            case DOWN_RIGHT:
               buffer = -7;
               break;
            case DOWN:
               buffer = -8;
               break;
            case DOWN_LEFT:
               buffer = -9;
               break;
            case LEFT:
               buffer = -1;
               break;
            default:
               break;
         }

         this.index = index;
      }

      /**
      * Default BoardIterator constructor
      */
      public MyIterator(){
         buffer = 1;
         normal = true;
         maxIndex = 63;
         index = 0;
      }

      /**
       * Determines whether there is another spot in the direction specified
       * @return boolean true if there is a next element
       */
      public boolean hasNext(){
         if(normal){
            System.out.println(index);
            // If normal then index will only increase by one
            if(index <= maxIndex){
               return true;
            }else{
               return false;
            }
         }
			int[] diag1 = {48, 57};
			int[] diag2 = {40, 49, 58};
			int[] diag3 = {32, 41, 50, 59};
			int[] diag4 = {24, 33, 42, 51, 60};
			int[] diag5 = {16, 25, 34, 43, 52, 61};
			int[] diag6 = {8, 17, 26, 35, 44, 53, 62};
			int[] diag7 = {0, 9, 18, 27, 36, 45, 54, 63};
			int[] diag8 = {1, 10, 19, 28, 37, 46, 55};
			int[] diag9 = {2, 11, 20, 29, 38, 47};
			int[] diag10 = {3, 12, 21, 30, 39};
			int[] diag11 = {4, 13, 22, 31};
			int[] diag12 = {5, 14, 23};
			int[] diag13 = {6, 15};
			private boolean containsNum(int num, int[]array){
				for (int i = 0; i < array.length; i++){
						if (num == array[i]){
						return true;
						}
					}
					return false;
				}
			}
			// UP RIGHT
			if (buffer == 2){
				if (containsNum(index, diag1){
					
				}
					
			
			}
			// DOWN LEFT
			if (buffer == 6){
				if (
			}

			// UP_LEFT, LEFT_UP, DOWN_LEFT
			if (buffer == 7 || buffer == 0 || buffer == 6){
				if (index < index + (index%8)*buffer){
					return true;
				}
			}
			if (buffer == 1){
				if (index < index%8 + 7*buffer){
					return true;
				}
			}
			if (buffer == 2){
				if (index < index + buffer*(8 - index%8){
					return true;
				}
			}
			if (buffer == 3){
				if (index < index + 7*buffer - index%8){
					return true;
				}
			}
			if (buffer == 4){
				if (index > ){
					return true;
				}
			}
			if (buffer == 5){
				if(index > index%8){
					return true;
				}
			}

			/*
         if (buffer < 0){ //buffer is negative
            if (index <= index + 8*buffer - 8*(index%buffer)){
               return true;
            }
			if (k=
         }else{ //Buffer is positive (buffer is never 0)
            if (index > buffer){
               return true;
            }
         }
			*/
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
         
         // Return the element we are currently on
         index += buffer;
         return board[index - buffer];
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
