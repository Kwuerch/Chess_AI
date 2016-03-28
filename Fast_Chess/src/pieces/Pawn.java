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

public class Pawn extends ChessPiece {
	private boolean madeMove;
   private List<Move> moves;
   private Board board;

   /**
    * Pawn Constructor
    *
    * Constructor to take in if move has been made
    * Calls Super constructor and initializes the list of Moves
    */
	public Pawn(Board board, boolean white, boolean madeMove) {
		super(white);
		
      this.board = board;
		this.madeMove = madeMove;
      moves = new ArrayList<Move>();
	}
  
   /**
    * Pawn Constructor
    *
    * Constructor to assume no move has been made
    * Calls Super constructor and initializes the list of Moves
    */
	public Pawn(Board board, boolean white) {
		super(white);
		
      this.board = board;
		this.madeMove = false;
      
      moves = new ArrayList<Move>();
	}

   /**
    * getMoves
    *
    * @return the boolean representation of possible moves
    */
   public List<Move> getMoves() {
      return moves;
   }

   /**
    * determineMoves
    *
    * Add the possible moves to the List of Moves
    */
   public void determineMoves(int index) {
      // Remove all moves
      moves.clear();

      // If white moves go upward
      if (isWhite()) {
         BoardIterator<ChessPiece> it = board.boardIterator(Board.UP_LEFT, index); 
         movesGen(it, index, true);

         it = board.boardIterator(Board.UP, index); 
         movesGen(it, index, false);

         it = board.boardIterator(Board.UP_RIGHT, index); 
         movesGen(it, index, true);
      } else {
         BoardIterator<ChessPiece> it = board.boardIterator(Board.DOWN_LEFT, index); 
         movesGen(it, index, true);

         it = board.boardIterator(Board.DOWN, index); 
         movesGen(it, index, false);

         it = board.boardIterator(Board.DOWN_RIGHT, index); 
         movesGen(it, index, true);

      }
   }

   /**
    * movesGen
    *
    * Add moves to a piece's move List after receiving a reference to such list
    * Will only add one move for non multi moves
    * ** Multi is defined to mean a moves that goes more than one space
    */
   public void movesGen(BoardIterator<ChessPiece> it, int index, boolean diag) {
      boolean hitPiece;
      ChessPiece p;
      
      if (it.hasNext()) {
         p = it.next();

         // Add Diagonal Attacks
         if (diag) {
            if (p != null && p.isWhite() != isWhite()) {
               // Check if can take piece diagonally, and possibly promote diagonally
               if (!it.hasNext()) {
                  BoardIterator<ChessPiece> straigtIt;
                  if(isWhite()){
                     straigtIt = board.boardIterator(Board.UP, it.index());
                  }else{
                     straigtIt = board.boardIterator(Board.DOWN, it.index());
                  }

                  if (!straigtIt.hasNext()) {
                     moves.add(new Move(index, it.index(), Move.PROMOTION));
                  } else {
                     moves.add(new Move(index, it.index(), Move.ATTACK));
                  }
               } else {
                  moves.add(new Move(index, it.index(), Move.ATTACK)); 
               }
            }
            return;
         } else {
            // Add Promotion in Straigh Direction
            if (p == null && !it.hasNext()) {
               moves.add(new Move(index, it.index(), Move.PROMOTION));
               return;
            }
         }

         // Add Single and Double Pawn Straight Moves
         if (madeMove) {
            if (p == null) {
               moves.add(new Move(index, it.index(), Move.QUIET)); 
            }
         } else {
            if (p == null) {
               moves.add(new Move(index, it.index(), Move.QUIET));
               if (it.hasNext()) {
                  p = it.next();
                  if (p == null) {
                     moves.add(new Move(index, it.index(), Move.PAWN_DBL));
                  }
               }
            }
         }

      }
   }

   /**
    * getValue
    *
    * @return the value of the piece
    */
   public double getValue() {
      return 1;
   }

   /**
    * madeMove
    *
    * Call when piece is moved
    */
   public void madeMove() {
      madeMove = false;
   }

   /**
    * getMadeMove
    * 
    * @return if the pawn has made a move
    */
   public boolean getMadeMove() {
      return madeMove;
   }


   /**
    * toString
    *
    * @return a String representation of the piece
    */
   @Override
   public String toString() {
      if (!isWhite()) {
         return "♙";
      } else {
         return "♟";
      }
   }
}
