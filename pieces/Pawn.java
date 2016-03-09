package pieces;

/**
 * Pawn Class
 * 
 * Author: Kyle Wuerch
 * Copyright 2015
 */

public class Pawn extends ChessPiece{
	boolean madeMove;
   ChessPiece[][] board;
   boolean[][] moves;
	
	public Pawn(ChessPiece[][] board, boolean madeMove, boolean white) {
		super(white);
		
		//DONT FORGET TO UPDATE THIS IN MOVE
      this.board = board;
		this.madeMove = madeMove;

      moves = new boolean[8][8];
	}

   /**
    * getMoves
    * @return the boolean representation of possible moves
    */
   public boolean[][] getMoves(){
      return moves;
   }
	
	public void Move() {
		madeMove = true;
	}

   public String toString(){
      return " P ";
   }
	
}
