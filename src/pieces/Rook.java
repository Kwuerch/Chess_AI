package pieces;

import board.Board;
import board.Move;
import java.util.ArrayList;
import java.util.List;

/**
 * Rook Class
 * 
 * @author Kyle Wuerch
 * @version Program 7
 */
public class Rook extends ChessPiece{
   Board board;
   List<Move> moves;

	public Rook(Board board, boolean white) {
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

   public void determineMoves(ChessPiece[][] board, int row, int col){
   }

   public String toString(){
      return " R ";
   }
}
