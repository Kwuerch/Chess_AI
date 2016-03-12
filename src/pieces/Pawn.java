package pieces;

import board.Board;
import board.BoardIterator;
import board.Move;
import java.util.ArrayList;
import java.util.List;

/**
 * Pawn Class
 * 
 * Author: Kyle Wuerch
 * Copyright 2015
 */

public class Pawn extends ChessPiece{
	boolean madeMove;
   List<Move> moves;
   Board board;
	
	public Pawn(Board board, boolean madeMove, boolean white) {
		super(white);
		
      this.board = board;
		this.madeMove = madeMove;
      
      moves = new ArrayList<Move>();
	}

   /**
    * getMoves
    * @return the boolean representation of possible moves
    */
   public List<Move> getMoves(){
      return moves;
   }

   /**
    * determineMoves
    * Add the possible moves to the List of Moves
    */
   public void determineMoves(int index){
      BoardIterator<ChessPiece> it = board.boardIterator(Board.UP_LEFT, index); 
      movesGen(it, index, true);

      it = board.boardIterator(Board.UP, index); 
      movesGen(it, index, false);

      it = board.boardIterator(Board.UP_RIGHT, index); 
      movesGen(it, index, true);
   }

   /**
    * movesGen
    * Add moves to a piece's move List after receiving a reference to such list
    * Will only add one move for non multi moves
    * ** Multi is defined to mean a moves that goes more than one space
    */
   public void movesGen(BoardIterator<ChessPiece> it, int index, boolean diag){
      boolean hitPiece;
      ChessPiece p;

      if(it.hasNext()){
         p = it.next();

         // Add Diagonal Attacks
         if(diag){
            if(diag && p != null && p.isWhite() != isWhite()){
               moves.add(new Move(index, it.index(), Move.QUIET)); 
            }
            return;
         }


         // Add Singal and Double Pawn Straight Moves
         if(madeMove){
            if(p != null){
               if(p.isWhite() != isWhite()){
                  moves.add(new Move(index, it.index(), Move.QUIET)); 
               }
            }else{
               moves.add(new Move(index, it.index(), Move.QUIET));
            }
         }else{
            if(p == null && it.hasNext()){
               p = it.next();
               if(p != null){
                  if(p.isWhite() != isWhite()){
                     moves.add(new Move(index, it.index(), Move.PAWN_DBL));
                  }
               }else{
                  moves.add(new Move(index, it.index(), Move.PAWN_DBL));
               }
            }
         }

      }

      while(it.hasNext()){
         hitPiece = false;
         p = it.next();
         System.out.println(p + " at " + it.index());

         if(p != null){
            hitPiece = true;
         }

         // Stop Iteration if run into piece
         if(hitPiece){
            // Only add a move if the piece is a different color
            if(p.isWhite() != isWhite()){
               moves.add(new Move(index, it.index(), Move.QUIET)); 
            }

            break;
         }

         moves.add(new Move(index, it.index(), Move.QUIET)); 
      }

   }
   /**
    * getValue
    * @return the value of the piece
    */
   public int getValue(){
      return 1;
   }

   /**
    * madeMove
    * Call when piece is moved
    */
   public void madeMove(){
      madeMove = false;
   }


   /**
    * toString
    * @return a String representation of the piece
    */
   @Override
   public String toString(){
      return "P"; 
   }
}
