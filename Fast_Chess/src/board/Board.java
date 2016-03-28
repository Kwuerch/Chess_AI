package board;

/**
 * Board Class
 *
 * A board represented by bit boards for each piece
 * MSB = top left of the board
 * LSB = bottom right of the board
 */
public class Board{
   private long WHITE_PAWN;
   private long WHITE_KING;
   private long WHITE_KNIGHT;
   private long WHITE_QUEEN;
   private long WHITE_BISHOP;
   private long WHITE_ROOK;

   private long BLACK_PAWN;
   private long BLACK_KING;
   private long BLACK_KNIGHT;
   private long BLACK_QUEEN;
   private long BLACK_BISHOP;
   private long BLACK_ROOK;

   // For Testing Purposes TODO: Remove
   private long MOVES_BP;
   private long MOVES_BK;
   private long MOVES_BN;
   private long MOVES_BQ;

   byte[] attacks;

   /**
    * Default Board Constructor
    *
    * Sets the values for a board
    */
   public Board(){
      attacks = new byte[64];
      MOVES_BP = 0;
      MOVES_BK = 0;
      MOVES_BN = 0;
      MOVES_BQ = 0;
      setupBoard();
   }

   
   /**
    * move
    *
    * Moves a piece from a start to end
    */
   public void move(){

   }

   /**
    * setupBoard
    *
    * Set the default values for a Chess Board
    */
   public void setupBoard(){
      //BLACK_PAWN   = 0b0000000011111111000000000000000000000000000000000000000000000000L;
      BLACK_PAWN   = 0b0000000001000010000000000000000000000000000000000000000000000000L;
      BLACK_KING   = 0b0000100000000000000000000000000000000000000000000000000000000000L;
      BLACK_QUEEN  = 0b0001000000000000000000000000000000000000000000000000000000000000L;
      BLACK_BISHOP = 0b0010010000000000000000000000000000000000000000000000000000000000L;
      BLACK_KNIGHT = 0b0100001000000000000000000000000000000000000000000000000000000000L;
      BLACK_ROOK   = 0b1000000100000000000000000000000000000000000000000000000000000000L;

      WHITE_PAWN   = 0b0000000000000000000000000000000000000000000000001111111100000000L;
      WHITE_KING   = 0b0000000000000000000000000000000000000000000000000000000000001000L;
      WHITE_QUEEN  = 0b0000000000000000000000000000000000000000000000000000000000010000L;
      WHITE_BISHOP = 0b0000000000000000000000000000000000000000000000000000000000100100L;
      WHITE_KNIGHT = 0b0000000000000000000000000000000000000000000000000000000001000010L;
      WHITE_ROOK   = 0b0000000000000000000000000000000000000000000000000000000010000001L;
   }

   /**
    * testMoveGen
    */
   public void generateMoves(){
      MOVES_BN = MoveGen.movesKnight(blackBoard(), BLACK_KNIGHT);
      MOVES_BK = MoveGen.movesKing(blackBoard(), BLACK_KING);
      MOVES_BP = MoveGen.movesBlackPawn(whiteBoard(), fullBoard(), BLACK_PAWN);
      MOVES_BQ = MoveGen.movesQueen(blackBoard(), BLACK_QUEEN);
   }


   /**
    * whiteBoard
    *
    * @return the all the white bitBoards or'd together
    */
   public long whiteBoard(){
      return WHITE_ROOK | WHITE_KNIGHT | WHITE_BISHOP | WHITE_QUEEN | WHITE_QUEEN |  WHITE_PAWN;

   }

   /**
    * blackBoard
    *
    * @return the all the black bitBoards or'd together
    */
   public long blackBoard(){
      return BLACK_ROOK | BLACK_KNIGHT | BLACK_BISHOP | BLACK_QUEEN | BLACK_QUEEN |  BLACK_PAWN;
   }

   /**
    * fullBoard
    *
    * @return all the bitBoards or'd together
    */
   public long fullBoard(){
      return BLACK_ROOK | BLACK_KNIGHT | BLACK_BISHOP | BLACK_QUEEN | BLACK_QUEEN |  BLACK_PAWN |
      WHITE_ROOK | WHITE_KNIGHT | WHITE_BISHOP | WHITE_QUEEN | WHITE_QUEEN |  WHITE_PAWN;
   }

   /**
    * toString
    *
    * @return a String representation of the board
    */
   public String toString(){
      String result = "";
      for(int i = 63; i > -1; i--){
         if((i+1) % 8  == 0){
            result += "\n";
         }


         if((BLACK_PAWN >> i & 1)  == 1){
            result += " ♙";
         }else if((WHITE_PAWN >> i & 1) == 1){
            result += " ♟";
         }else if((BLACK_BISHOP >> i & 1) == 1){
            result += " ♗";
         }else if((BLACK_KNIGHT >> i & 1) == 1){
            result += " ♘";
         }else if((BLACK_ROOK >> i & 1) == 1){
            result += " ♖";
         }else if((WHITE_BISHOP >> i & 1) == 1){
            result += " ♝";
         }else if((WHITE_KNIGHT >> i & 1) == 1){
            result += " ♞";
         }else if((WHITE_ROOK >> i & 1) == 1){
            result += " ♜";
         }else if((WHITE_QUEEN >> i & 1) == 1){
            result += " ♛";
         }else if((BLACK_QUEEN >> i & 1) == 1){
            result += " ♕";
         }else if((WHITE_KING >> i & 1) == 1){
            result += " ♚";
         }else if((BLACK_KING >> i & 1) == 1){
            result += " ♔";
         }else{
            result += " ☐";
         }
      }
      return result;
   }

   /**
    * movesToString
    *
    * @return a String representation of the moves 
    */
   public String movesToString(){
      String result = "";
      for(int i = 63; i > -1; i--){
         if((i+1) % 8  == 0){
            result += "\n";
         }


         if((MOVES_BQ >> i & 1 ) == 1){
            result += " ♕";
         }else if((MOVES_BP >> i & 1)  == 1){
            result += " ♙";
         }else if((MOVES_BN >> i & 1) == 1){
            result += " ♘";
         }else if((MOVES_BK >> i & 1) == 1){
            result += " ♔";
         }else{
            result += " ☐";
         }
      }
      return result;
   }
}
