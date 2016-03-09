/**
 * King Class
 * 
 * @author Kyle Wuerch
 * @version Program 7
 */

public class King extends ChessPiece{
   ChessPiece[][] board;
   boolean[][] moves;
	
	public King(ChessPiece[][] board, boolean white) {
		super(white);
      this.board = board;

      moves = new boolean[8][8];
	}

   /**
    * getMoves
    * @return the boolean representation of the possible moves
    */
   public boolean[][] getMoves(){
      return moves;
   }

   public String toString(){
      return " K ";
   }
   
}
