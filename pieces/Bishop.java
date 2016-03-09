package pieces;

import core.Move;
import java.util.ArrayList;

/**
 * Bishop Class
 * 
 * @author Kyle Wuerch
 * @version Program 7
 */
public class Bishop extends ChessPiece{
   Board board;
   ArrayList<Move> moves;

   /**
    * Constructor
    * Initialize moves and setup reference to board
    */
	public Bishop(ChessPiece[][] board, boolean white) {
		super(white);
      this.board = board;

      moves = new ArrayList<Move>();;
	}

   /**
    * getMoves
    * @return the boolean representation of possible moves 
    */
   public boolean[][] getMoves(){

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
