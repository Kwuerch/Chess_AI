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
    * Add the possible moves to the List of Moves
    */
   public void determineMoves(int index){
      //TODO
   }

   /**
    * getValue
    * @return the value of the piece
    */
   public int getValue(){
      return 3;
   }

   /**
    * toString
    * @return a String representation of the piece
    */
   @Override
   public String toString(){
      return "N";
   }
}
