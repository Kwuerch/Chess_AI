package pieces;


import board.Board;
import board.Move;
import java.util.ArrayList;
import java.util.List;

/**
 * King Class
 * 
 * @author Kyle Wuerch
 * @version Program 7
 */

public class King extends ChessPiece{
   Board board; 
   List<Move> moves;

	
	public King(Board board, boolean white) {
		super(white);
      this.board = board;

      moves = new ArrayList<Move>();
	}

   /**
    * getMoves
    * @return the boolean representation of the possible moves
    */
   public List<Move> getMoves(){
      return moves;
   }

   /**
    * getValue
    * @return the value of the piece
    */
   public int getValue(){
      return Integer.MAX_VALUE;
   }

   /**
    * toString
    * @return a String representation of the piece
    */
   @Override
   public String toString(){
      return " K ";
   }
   
}
