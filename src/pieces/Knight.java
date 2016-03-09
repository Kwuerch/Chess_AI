package pieces;

import board.Board;
import board.Move;
import java.util.ArrayList;
import java.util.List;

/**
 * Knight Class
 * @author Kyle Wuerch
 * @version Program 7
 */
public class Knight extends ChessPiece {
   Board board;
   List<Move> moves;

	public Knight(Board board, boolean white) {
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
    * determineMoves
    * Determines the all the possible moves for this piece
    */
   public void determineMoves(){

   }

   public String toString(){
      return " N ";
   }
}
