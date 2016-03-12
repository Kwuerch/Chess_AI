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
	
  /**
    * Constructor for Board
    */
   public Board(){
      board = new ChessPiece[100];
      moves = new ArrayList<Move>();
      setupBoard();
      findMoves();
   }

   /**
    * setupBoard
    * Add the correct pieces to the board
    */
   private void setupBoard(){
		int buffer = 1;
		for (int i = 0; i < 91; i+=10){
			board[i] = new Invalid();
		}
		for (int i = 9; i < 100; i+=10){
			board[i] = new Invalid();
		}
		for (int i = 1; i < 9; i++){
			board[i] = new Invalid();
		}
		for (int i = 91; i < 99; i++){
			board[i] = new Invalid();
		}
      board[11] = new Rook(this, false);
      board[12] = new Bishop(this, false);
      board[17] = new Bishop(this, false);
      board[18] = new Rook(this, false);

      board[81] = new Rook(this, true);
      board[82] = new Bishop(this, true);
      board[87] = new Bishop(this, true);
      board[88] = new Rook(this, true);
   }

   /**
    * findMoves
    * Adds the moves of all pieces of the current board 
    */
   private void findMoves(){
		BoardIterator<ChessPiece> it = iterator();
		while (it.hasNext()){
			int index = it.index();
			ChessPiece p = it.next();
			if(p != null){
				System.out.println(index);
				p.determineMoves(index);
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
      if(p.toString().equals("P")){ // If piece is a pawn
         ((Pawn)p).madeMove();
      }
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
         if(board[i] != null && !board[i].toString().equals("K")){ // If a King
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
          if(p.toString().equals("K")){ // If a king
             if(p.isWhite() == isWhite){
                return false;
             }
          }
       }
       // Therefore King has no moves

       // If Opponent end move is King: Checkmate
       for(Move m: moves){
          ChessPiece p = board[m.getEnd()];
          if(p.toString().equals("K")){ // If a King
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
      return new NormalIterator();
   }

   /**
    * toString
    * @return a String representation of the Board
    */
   public String toString(){
		String result = "";
		int min = 56;
		int index = 0;

		ChessPiece[] array = new ChessPiece[64];
		BoardIterator<ChessPiece> it = iterator();

		while (it.hasNext()){
			array[index++] = it.next();	
		}

		while(min > -1){
         for(int i = min; i < min + 8; i++){
            if(array[i] == null){
               result += " O";
            }else{
               result += " " +  array[i].toString();
            }
         }
         result += "\n";
         min -= 8;
      }

      return result;   
   }

	private class NormalIterator extends BoardIterator<ChessPiece>{
		private int index;
		private int min = 11;
		private int max = 88;
		
		/**
		 * Constructor for NormalIterator
		 */
		public NormalIterator(){
			index = min;
		}

		/**
       * Determines whether there is another spot in the direction specified
       * @return boolean true if there is a next element
       */
      public boolean hasNext(){
			if (index <= max){
				return true;
			}	
			return false;
		}

      /**
       * Gets the next chesspiece in the iterator and adds to iterator index
       * @return the current ChessPiece
       */
      public ChessPiece next(){
			if (!hasNext()){
				throw new NoSuchElementException();
			}
			if (index%10 == 8){
				index += 3;
				return board[index - 3];
			}else{
				return board[index++];
			}
		}

      /**
       * Removes and item from the iterator
       * @throws UnsupportedOperationException
       */
      public void remove(){
			throw new UnsupportedOperationException();
		}

      /**
       * getIndex
       * @return the current index of the iterator
       */
      public int index(){
			return index;
		}

		
	}
   private class MyIterator extends BoardIterator<ChessPiece>{
      private int buffer;
      private int index;

      /**
       * Constructor of BoardIterator taking parameters for direction and index
       * @param int the desired direction of iteration
       * @param int the desired starting index of the iterator
       */
      public MyIterator(int direction, int index){
         switch(direction){
            case UP_LEFT:
               buffer = 9;
               break;
            case UP:
               buffer = 10;
               break;
            case UP_RIGHT:
               buffer = 11;
               break;
            case RIGHT:
               buffer = 1;
               break;
            case DOWN_RIGHT:
               buffer = -9;
               break;
            case DOWN:
               buffer = -10;
               break;
            case DOWN_LEFT:
               buffer = -11;
               break;
            case LEFT:
               buffer = -1;
               break;
         }
         this.index = index;
      }

      /**
       * Determines whether there is another spot in the direction specified
       * @return boolean true if there is a next element
       */
      public boolean hasNext(){
			ChessPiece p = board[index + buffer];
			
			if (p == null){
				return true;
			}else if(!p.toString().equals("I")){ // If piece is not invalid
				return true;
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
