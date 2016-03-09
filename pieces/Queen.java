package pieces;

/**
 * Queen Class
 * 
 * @author Kyle Wuerch
 * @version Program 7
 */
public class Queen extends ChessPiece {
   ChessPiece[][] board;
   boolean[][] moves;

	public Queen(ChessPiece[][] board, boolean white) {
		super(white);
      this.board = board;

      moves = new boolean[8][8];
	}

   /**
    * getMoves
    * @return the boolean representation of possible moves
    */
   public boolean[][] getMoves(){
      return moves;
   }

   public String toString(){
      return " Q ";
   }
	
}
