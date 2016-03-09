/**
 * Program 7
 * @author Kyle Wuerch
 */

/**
 *  0 1 2 3 4 5 6 7	BLACK
 *0 R N B Q K B N R
 *1 P P P P P P P P
 *2 0 0 0 0 0 0 0 0
 *3 0 0 0 0 0 0 0 0 
 *4 0 0 0 0 0 0 0 0
 *5 0 0 0 0 0 0 0 0
 *6 P P P P P P P P
 *7 R N B Q K B N R
 *				    WHITE
 */

public class Game{
   private ChessPiece[][] board;

   /** 
    * Game Constructor
    * Sets up the intial game conditions for play
    */
   public Game(){
      board = new ChessPiece[8][8];
      initializeGame();
   }
   
   /**
    * Initialize Game
    * Add the default pieces to the board
    */
	private void initializeGame() {
      /*
		for(int i = 0; i< 8; i ++) {
			//Add Black Pieces
			board[1][i] = new Pawn(board, false, false);
			
			//Add White pieces
			board[6][i] = new Pawn(board, false, true);
		}
      */
	
      // Add Rooks
		board[0][0] = new Rook(board, false);
		board[0][7] = new Rook(board, false);
		board[7][0] = new Rook(board, true);
		board[7][7] = new Rook(board, true);
     /** 
      // Add Knights
		board[0][1] = new Knight(board, false);
		board[0][6] = new Knight(board, false);
		board[7][1] = new Knight(board, true);
		board[7][6] = new Knight(board, true);
		
      // Add Bishops
		board[0][2] = new Bishop(board, false);
		board[0][5] = new Bishop(board, false);
		board[7][2] = new Bishop(board, true);
		board[7][5] = new Bishop(board, true);
		
      // Add Queens
		board[0][3] = new Queen(board, false);
		board[7][3] = new Queen(board, true);

      // Add Kings
		board[0][4] = new King(board, false);
		board[7][4] = new King(board, true);
      */
	}
   
   /**
    * GetBoard
    * @return a reference to the board array
    */
   public ChessPiece[][] getBoard(){
      return board;
   }

   /**
    * Game toString
    * @return a string that represents the current game
    */
   public String toString(){
      String result = "";
      
      result += " ";
      for(char col = 'A'; col <= 'H'; col++){
         result += " " + col + " ";
      }
      result += "\n";
      for(int i = 0; i < board.length; i ++){
         result += (i + 1) + "";
         for(int j = 0; j < board[0].length; j++){
            if(board[i][j] == null){
               result += " O ";
            }else{
               result += board[i][j];
            }
         }
         result += "\n";
      }

      return result;
   }
}
