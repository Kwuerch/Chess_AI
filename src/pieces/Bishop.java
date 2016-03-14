package pieces;

import board.Board;
import board.Move;
import board.BoardIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * Bishop Class
 * 
 * @author Kyle Wuerch
 * @version Program 7
 */
public class Bishop extends ChessPiece {
   Board board;
   List<Move> moves;
   /**
    * Constructor
    * Initialize moves and setup reference to board
    */
	public Bishop(Board board, boolean white) {
		super(white);
      this.board = board;
      
      moves = new ArrayList<>();
	}

   /**
    * getMoves
    * @return the boolean representation of possible moves 
    */
   public List<Move> getMoves() {
      return moves;
   }

   /**
    * determineMoves
    * Go through the board and determine the possible moves
    * @param : The current index of the piece
    */
   public void determineMoves(int index) {
      // Remove all moves
      moves.clear();
      
      BoardIterator<ChessPiece> it = board.boardIterator(Board.UP_LEFT, index); 
      super.movesGen(moves, it, index, true);

      it = board.boardIterator(Board.UP_RIGHT, index);
      super.movesGen(moves, it, index, true);

      it = board.boardIterator(Board.DOWN_RIGHT, index);
      super.movesGen(moves, it, index, true);

      it = board.boardIterator(Board.DOWN_LEFT, index);
      super.movesGen(moves, it, index, true);
   }

   /**
    * getValue
    * @return the value of the piece
    */
   public int getValue() {
      return 3;
   }

   /**
    * toString
    * @return string representation of Bishop
    */
   @Override
   public String toString() {
      if(!isWhite()) {
         return "♗";
      } else {
         return "♝";
      }
   }
}
