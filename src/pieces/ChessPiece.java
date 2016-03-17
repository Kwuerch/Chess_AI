package pieces;

import board.Board;
import board.BoardIterator;
import board.Move;
import java.util.List;

/**
 * ** ChessPiece Abstract Class **
 * 
 * @author Kyle Wuerch
 * @version Program 7
 */

public abstract class ChessPiece extends PieceValue {
	private boolean white;

   /**
    * ChessPiece Constructor
    *
    * Sets white to true if the piece is white
    * false otherwise
    */
	public ChessPiece(boolean white) {
		this.white = white;
	}

   /**
    * movesGen
    *
    * Add moves to a piece's move List after receiving a reference to such list
    * Will only add one move for non multi moves
    * ** Multi is defined to mean a moves that goes more than one space
    */
   public void movesGen(List<Move> moves, BoardIterator<ChessPiece> it, int index, boolean multi) {
      boolean hitPiece;
      ChessPiece p;

		if (multi) {
         while (it.hasNext()) {
            hitPiece = false;
            p = it.next();

            if (p != null) {
               hitPiece = true;
            }

            // Stop Iteration if run into piece
            if (hitPiece) {
               // Only add a move if the piece is a different color
               if (p.white != white) {
                  moves.add(new Move(index, it.index(), Move.ATTACK)); 
               }
               break;
            }
            moves.add(new Move(index, it.index(), Move.QUIET)); 
         }
      } else {
         if (it.hasNext()) {
            p = it.next();
            // Only add a move if the piece is a different color
            if (p == null) {
               moves.add(new Move(index, it.index(), Move.QUIET)); 
            } else if (p.white != white) {
               moves.add(new Move(index, it.index(), Move.ATTACK)); 
            }
         }
      }
   }

   /**
    * getMoves
    *
    * @return a List of Moves that a piece can make
    */
   public abstract List<Move> getMoves();

   /**
    * determineMoves
    *
    * a void method that makes the pieces calculate all of
    * its possible moves
    */
   public abstract void determineMoves(int index);

   /**
    * getValue
    *
    * @return the Value of a piece
    */
   public abstract double getValue();

   /**
    * isWhite
    *
    * @return true if the piece is white, false if black
    */
   public boolean isWhite() {
      return white;
   }
}
