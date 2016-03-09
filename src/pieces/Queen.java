package pieces;

import board.Board;
import board.Move;
import java.util.ArrayList;
import java.util.List;

/**
 * Queen Class
 * 
 * @author Kyle Wuerch
 * @version Program 7
 */
public class Queen extends ChessPiece {
   List<Move> moves;
   Board board;

	public Queen(Board board, boolean white) {
		super(white);
      this.board = board;

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
    * getValue
    * @return the value of the piece
    */
   public int getValue(){
      return 9;
   }

   /**
    * toString
    * @return a String representation of the piece
    */
   @Override
   public String toString(){
      return " Q ";
   }
	
}
