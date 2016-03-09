package pieces;

import board.Board;
import board.Move;
import java.util.ArrayList;
import java.util.List;

/**
 * Bishop Class
 * 
 * @author Kyle Wuerch
 * @version Program 7
 */
public class Bishop extends ChessPiece{
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
   public List<Move> getMoves(){
      return moves;
   }

   /**
    * toString
    * @return string representation of Bishop
    */
   @Override
   public String toString(){
      return " B ";
   }
	
}
