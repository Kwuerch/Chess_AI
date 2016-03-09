package pieces;

/**
 * Rook Class
 * 
 * @author Kyle Wuerch
 * @version Program 7
 */
public class Rook extends ChessPiece{
   ChessPiece[][] board;
   boolean moves[][];


	public Rook(ChessPiece[][] board, boolean white) {
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

   public void determineMoves(ChessPiece[][] board, int row, int col){
   }

   public String toString(){
      return " R ";
   }
}
