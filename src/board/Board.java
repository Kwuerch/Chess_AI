package board;

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
      board[0] = new Rook(this, false);
      board[1] = new Bishop(this, false);
      board[6] = new Bishop(this, false);
      board[7] = new Rook(this, false);

      board[56] = new Rook(this, true);
      board[57] = new Bishop(this, true);
      board[62] = new Bishop(this, true);
      board[63] = new Rook(this, true);
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
      return new MyIterator(direction, index);
   }

   /**
    * iterator
    * @return a default iterator to go through each space
    */
   public BoardIterator<ChessPiece> iterator(){
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
					System.out.println("ContainsNum returned true");
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
            // If normal then index will only increase by one
            if(index <= maxIndex){
               return true;
            }else{
               //return false;
            }
         }
			if (){

			}
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
         
         // Return the next piece 
         // Never returns the first item
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
