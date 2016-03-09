/**
 * The Main Class
 * 
 * @author Kyle Wuerch
 * @version Program 7
 */
public class Play {
	public static void main(String args[]) {
      Game g  = new Game();
      System.out.println(g);
      Option.determineOptions(g.getBoard());

      ChessPiece[][] board = g.getBoard();
      for(int row = 0; row < board.length; row ++){
         for(int col = 0; col < board[row].length; col++){
            if(board[row][col] != null){
               boolean[][] moves = board[row][col].getMoves();
               for(int row2 = 0; row2 < board.length; row2 ++){
                  for(int col2 = 0; col2 < board[row2].length; col2++){
                     if(moves[row2][col2]){
                        System.out.print(" X");
                     }else{
                        System.out.print(" O");
                     }
                  }
                  System.out.println();
               }
               System.out.println();
            }

         }
      }
      
	}
}
