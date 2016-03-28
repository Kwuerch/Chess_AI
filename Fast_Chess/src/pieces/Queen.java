package pieces;

import board.Board;
import board.BoardIterator;
import board.Move;
import java.util.ArrayList;
import java.util.List;

/**
 * Queen Class
 * 
 * @author Kyle Wuerch and Sean Wallace
 * @version Program 7
 */
public class Queen extends ChessPiece {
   private List<Move> moves;
   private Board board;

   /**
    * Queen constructor
    *
    * calls the super constructor and initializes the list of Moves
    */
	public Queen(Board board, boolean white) {
		super(white);
      this.board = board;

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

      BoardIterator<ChessPiece> it = board.boardIterator(Board.UP, index); 
      super.movesGen(moves, it, index, true);

      it = board.boardIterator(Board.UP_RIGHT, index);
      super.movesGen(moves, it, index, true);

      it = board.boardIterator(Board.RIGHT, index);
      super.movesGen(moves, it, index, true);

      it = board.boardIterator(Board.DOWN_RIGHT, index);
      super.movesGen(moves, it, index, true);

      it = board.boardIterator(Board.DOWN, index);
      super.movesGen(moves, it, index, true);

      it = board.boardIterator(Board.LEFT, index);
      super.movesGen(moves, it, index, true);

      it = board.boardIterator(Board.DOWN_LEFT, index);
      super.movesGen(moves, it, index, true);

      it = board.boardIterator(Board.UP_LEFT, index); 
      super.movesGen(moves, it, index, true);
   }
   
   /**
    * getValue
    *
    * @return the value of the piece
    */
   public double getValue() {
      return 6;
   }

   /**
    * toString
    *
    * @return a String representation of the piece
    */
   @Override
   public String toString() {
      if (!isWhite()) {
         return "♕";
      } else {
         return "♛";
      }
   }
}
