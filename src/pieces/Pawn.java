package pieces;

import board.Board;
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
      
   }

   /**
    * getValue
    * @return the value of the piece
    */
   public int getValue(){
      return 1;
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
