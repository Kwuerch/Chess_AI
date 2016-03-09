package pieces;

/**
 * Knight Class
 * @author Kyle Wuerch
 * @version Program 7
 */
public class Knight extends ChessPiece {
   ChessPiece[][] board;
   boolean[][] moves;

	public Knight(ChessPiece[][] board, boolean white) {
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
