/**
 *         ** Option Class **
 * A Static Class to Determine Possible Moves
 * and Area of Effect in ChessPiece Classes
 *
 * @author Kyle Wuerch
 * @version Program 7
 */
public class Option{

   public static void determineOptions(ChessPiece[][] board){
      for(int row = 0; row < board.length; row ++){
         for(int col = 0; col < board[row].length; col++){
            if(board[row][col] != null){
               board[row][col].determineMoves(board, row, col);
            }

         }
      }
   }
   /**
    * multiDiagonal
    * Determines the Possible Moves and Store them in the Array Passed by Reference
    */
   public static void multi(ChessPiece[][] board, boolean[][] moves, int row, int  col, int rowIt, int colIt){
		while(row < 8 && row > -1 && col < 8 && col > -1) {
			row = row + rowIt;
			col = col + colIt;

			if(row == 8 || row == -1 || col == 8 || col == -1) {
				break;
			}
						
			if(board[row][col] != null) {
				break;
			}else {
				moves[row][col] = true;
			}
		}
   }

   public static void multiUpRight(ChessPiece[][] board, boolean[][] moves, int row, int col){
      multi(board, moves, row, col, -1, 1);
   }

   public static void multiUpLeft(ChessPiece[][] board, boolean[][] moves, int row, int col){
      multi(board, moves, row, col, -1, -1);
   }

   public static void multiDownLeft(ChessPiece[][] board, boolean[][] moves, int row, int col){
      multi(board, moves, row, col, 1, -1);
   }

   public static void multiDownRight(ChessPiece[][] board, boolean[][] moves, int row, int col){
      multi(board, moves, row, col, 1, 1);
   }

   public static void multiLeft(ChessPiece[][] board, boolean[][] moves, int row, int col){
      multi(board, moves, row, col, 0, -1);
   }

   public static void multiRight(ChessPiece[][] board, boolean[][] moves, int row, int col){
      multi(board, moves, row, col, 0, 1);
   }

   public static void multiUp(ChessPiece[][] board, boolean[][] moves, int row, int col){
      multi(board, moves, row, col, 1, 0);
   }

   public static void multiDown(ChessPiece[][] board, boolean[][] moves, int row, int col){
      multi(board, moves, row, col, -1, 0);
   }

}
