package board;

import ai.BoardValue;
import pieces.*;
import java.util.List;
import java.util.ArrayList;
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

   private ChessPiece[] board;
   private List<Move> moves;
   private int currentValue;
	
	// Diagonal values for UP_RIGHT and DOWN_LEFT
	public static final int[] diag1 = {48, 57};
	public static final int[] diag2 = {40, 49, 58};
	public static final int[] diag3 = {32, 41, 50, 59};
	public static final int[] diag4 = {24, 33, 42, 51, 60};
	public static final int[] diag5 = {16, 25, 34, 43, 52, 61};
	public static final int[] diag6 = {8, 17, 26, 35, 44, 53, 62};
	public static final int[] diag7 = {0, 9, 18, 27, 36, 45, 54, 63};
	public static final int[] diag8 = {1, 10, 19, 28, 37, 46, 55};
	public static final int[] diag9 = {2, 11, 20, 29, 38, 47};
	public static final int[] diag10 = {3, 12, 21, 30, 39};
	public static final int[] diag11 = {4, 13, 22, 31};
	public static final int[] diag12 = {5, 14, 23};
	public static final int[] diag13 = {6, 15};
	
	// Diagonal values for UP_LEFT and DOWN_RIGHT
	public static final int[] diag_1 = {1, 8};
	public static final int[] diag_2 = {2, 9, 16};
	public static final int[] diag_3 = {3, 10, 17, 24};
	public static final int[] diag_4 = {4, 11, 18, 25, 32};
	public static final int[] diag_5 = {5, 12, 19, 26, 33, 40};
	public static final int[] diag_6 = {6, 13, 20, 27, 34, 41, 48};
	public static final int[] diag_7 = {7, 14, 21, 28, 35, 42, 49, 56};
	public static final int[] diag_8 = {15, 22, 29, 36, 43, 50, 57};
	public static final int[] diag_9 = {23, 30, 37, 44, 51, 58};
	public static final int[] diag_10 = {31, 38, 45, 52, 59};
	public static final int[] diag_11 = {39, 46, 53, 60};
	public static final int[] diag_12 = {47, 54, 61};
	public static final int[] diag_13 = {55, 62};

   /**
    * Constructor for Board
    */
   public Board(){
      board = new ChessPiece[64];
      moves = new ArrayList<Move>();
      setupBoard();
      findMoves();
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
    * findMoves
    * Adds the moves of all pieces of the current board 
    */
   private void findMoves(){
      for(int i = 0; i < board.length; i++){
         ChessPiece p = board[i];
         if(p != null){
            p.determineMoves(i);
            moves.addAll(p.getMoves());
         }
      }
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
    * getValue
    * @return the value of the white player's pieces
    */
   public int getValue(){
      return getValue(true);
   }

   /**
    * getValue
    * @param : Which Player to Calculate for 
    * @return the value of all the pieces of a certain color 
    * TODO: Improve and Test
    */
    public int getValue(boolean isWhite){
      int currentValue = 0;

      for (int i = 0; i < board.length; i++){
         // Kings have infinite value, do no consider in pointage
         if(board[i] != null && !board[i].getClass().toString().equals("King")){
            if(board[i].isWhite() == isWhite){
               currentValue += board[i].getValue();
            }
         }
      }
      return currentValue;
    }

   /**
    * getMoves
    * @return all the possible moves for the current board
    */
    public List<Move> getMoves(){
       return moves;
    }

   /**
    * @return if the player with a specific color is in checkmate
    * TODO: Improve and test
    */
    public boolean isCheckmate(boolean isWhite){
       // If Current Player King has moves: Not Checkmate
       for(Move m: moves){
          ChessPiece p = board[m.getStart()];
          if(p.getClass().toString().equals("King")){
             if(p.isWhite() == isWhite){
                return false;
             }
          }
       }
       // Therefore King has no moves

       // If Opponent end move is King: Checkmate
       for(Move m: moves){
          ChessPiece p = board[m.getEnd()];
          if(p.getClass().toString().equals("King")){
             if(p.isWhite() != isWhite){
                return true;
             }
          }
       }
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
		 * Determines if an integer is contains within an array.
		 * Used extensively within hasNext().
		 * @param int the integer to search for
		 * @param int[] an array that might contain the integer
		 */
		private boolean containsNum(int num, int[]array){
			for (int i = 0; i < array.length; i++){
				if (num == array[i]){
					return true;
					}
				}
				return false;
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
			
			int bound = 0;
			// UP RIGHT
			if (buffer == 2){
				if (containsNum(index, diag1)){
					bound = 57;
				}
				if (containsNum(index, diag2)){
					bound = 58;
				}
				if (containsNum(index, diag3)){
					bound = 59;
				}
				if (containsNum(index, diag4)){
					bound = 60;
				}
				if (containsNum(index, diag5)){
					bound = 61;
				}
				if (containsNum(index, diag6)){
					bound = 62;
				}
				if (containsNum(index, diag7)){
					bound = 63;
				}
				if (containsNum(index, diag8)){
					bound = 55;
				}
				if (containsNum(index, diag9)){
					bound = 47;
				}
				if (containsNum(index, diag10)){
					bound = 39;
				}
				if (containsNum(index, diag11)){
					bound = 31;
				}
				if (containsNum(index, diag12)){
					bound = 23;
				}
				if (containsNum(index, diag13)){
					bound = 15;
				}
			}
			// DOWN LEFT
			if (buffer == 6){
				if (containsNum(index, diag1)){
					bound = 48;
				}
				if (containsNum(index, diag2)){
					bound = 40;
				}
				if (containsNum(index, diag3)){
					bound = 32;
				}
				if (containsNum(index, diag4)){
					bound = 24;
				}
				if (containsNum(index, diag5)){
					bound = 16;
				}
				if (containsNum(index, diag6)){
					bound = 8;
				}
				if (containsNum(index, diag7)){
					bound = 0;
				}
				if (containsNum(index, diag8)){
					bound = 1;
				}
				if (containsNum(index, diag9)){
					bound = 2;
				}
				if (containsNum(index, diag10)){
					bound = 3;
				}
				if (containsNum(index, diag11)){
					bound = 4;
				}
				if (containsNum(index, diag12)){
					bound = 5;
				}
				if (containsNum(index, diag13)){
					bound = 6;
				}	
			}
			// UP_LEFT
			if (buffer == 0){
				if (containsNum(index, diag_1)){
					bound = 8;
				}
				if (containsNum(index, diag_2)){
					bound = 16;
				}
				if (containsNum(index, diag_3)){
					bound = 24;
				}
				if (containsNum(index, diag_4)){
					bound = 32;
				}
				if (containsNum(index, diag_5)){
					bound = 40;
				}
				if (containsNum(index, diag_6)){
					bound = 48;
				}
				if (containsNum(index, diag_7)){
					bound = 56;
				}
				if (containsNum(index, diag_8)){
					bound = 57;
				}
				if (containsNum(index, diag_9)){
					bound = 58;
				}
				if (containsNum(index, diag_10)){
					bound = 59;
				}
				if (containsNum(index, diag_11)){
					bound = 60;
				}
				if (containsNum(index, diag_12)){
					bound = 61;
				}
				if (containsNum(index, diag_13)){
					bound = 62;
				}	
			}

			// DOWN_RIGHT
			if (buffer == 4){
				if (containsNum(index, diag_1)){
					bound = 1;
				}
				if (containsNum(index, diag_2)){
					bound = 2;
				}
				if (containsNum(index, diag_3)){
					bound = 3;
				}
				if (containsNum(index, diag_4)){
					bound = 4;
				}
				if (containsNum(index, diag_5)){
					bound = 5;
				}
				if (containsNum(index, diag_6)){
					bound = 6;
				}
				if (containsNum(index, diag_7)){
					bound = 7;
				}
				if (containsNum(index, diag_8)){
					bound = 15;
				}
				if (containsNum(index, diag_9)){
					bound = 23;
				}
				if (containsNum(index, diag_10)){
					bound = 31;
				}
				if (containsNum(index, diag_11)){
					bound = 39;
				}
				if (containsNum(index, diag_12)){
					bound = 47;
				}
				if (containsNum(index, diag_13)){
					bound = 55;
				}	
			}
			if (buffer == 4 || buffer == 0 || buffer == 6 || buffer ==2){
				if (index < bound){
					return true;
				}
			}
			
			// UP
			if (buffer == 8){
				if (index < 7*buffer - (7 - index%8)){
					return true;
				}
			}

			// DOWN
			if (buffer == -8){
				if(index > index%8){
					return true;
				}
			}

			// LEFT
			if (buffer == -1){
				//if (index > index + 7*buffer + (7 - index%8){
				if (index > 8*(index/8)){
					return true;
				}	
			}

			// RIGHT
			if (buffer == 1){
				if (index < index + 7*buffer - index%8){
					return true;
				}	
			}

			/*
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
			*/
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
