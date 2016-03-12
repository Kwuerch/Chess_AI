package board;

import pieces.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.Iterable;
import java.util.Iterator;

/**
 * ** Board Class **
 * Represents the chess board, implements iterator and finds ChessPieces.
 * Note: White is always the bottom starting at index 11.
 *
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class Board extends BoardValue implements Iterable<ChessPiece>{
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
      /*
      board[11] = new Rook(this, false);
      board[12] = new Bishop(this, false);
      board[17] = new Bishop(this, false);
      board[18] = new Rook(this, false);

      board[81] = new Rook(this, true);
      board[82] = new Bishop(this, true);
      board[87] = new Bishop(this, true);
      board[88] = new Rook(this, true);
      */
      board[73] = new King(this, true);
      board[75] = new King(this, false);
      board[25] = new Queen(this, true);
      board[62] = new Pawn(this, true);
      board[32] = new Pawn(this, false, true);
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
      return new DirectionalIterator(board, direction, index);
   }

   /**
    * iterator
    * @return a default iterator to go through each space
    */
   public BoardIterator<ChessPiece> iterator(){
      return new NormalIterator(board);
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
}
