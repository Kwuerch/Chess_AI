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
		
		//DONT FORGET TO UPDATE THIS IN MOVE
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
	
	public void Move() {
		madeMove = true;
	}

   public String toString(){
      return " P ";
   }
	
}
