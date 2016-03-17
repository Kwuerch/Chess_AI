package board;

import pieces.ChessPiece;

/**
 * Move Class
 *
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class Move {
   public static int QUIET = 0;
   public static int PAWN_DBL = 1;
   public static int EN_PASSANT = 2;
   public static int ATTACK = 3;
   public static int CASTLE = 4; 
   public static int PROMOTION = 5;
   public static int CHECKMATE = 6;
   public static int STALEMATE = 7;

   private int start;
   private int end;
   private int moveType;

   /**
    * Move Constructor
    * Sets the instance variables to the arguments sent in
    */
   public Move(int start, int end, int moveType) {
      this.start = start;
      this.end = end;
      this.moveType = moveType;
   }

   /**
    * Move Constructor
    *
    * Creates a move that ends the game
    */
   public Move(int endGame){
      start = -1;
      end = -1;
      moveType = endGame;
   }

   /**
    * Move Constructor
    *
    * Creates a move that ends the game that denotes 
    * the loser:
    * start == 1 means white lost
    * start == 0 means black lost
    */
   public Move(int endGame, boolean isWhite){
      if (isWhite) {
         start = 1;
         end = 1;
      }else{
         start = 0;
         end = 0;
      }
      moveType = endGame;
   }

   /**
    * getEnd
    *
    * @return the index for the piece to go
    */
   public int getEnd() {
      return end;
   }

   /**
    * getStart
    *
    * @return the index of the piece to move
    */
   public int getStart() {
      return start;
   }

   
   /**
    * isCheckmate
    *
    * @return if the game has ended in stalemate
    */
   public boolean isCheckmate(){
      if(moveType == CHECKMATE){
         return true;
      }
      return false;
   }

   
   /**
    * isStalemate
    *
    * @return if the game has ended in stalemate
    */
   public boolean isStalemate(){
      if(moveType == STALEMATE){
         return true;
      }
      return false;
   }

   /**
    * getMoveType
    *
    * @return the moveType
    */
   public int getMoveType(){
      return moveType;
   }


   /**
    * toString
    *
    * @return a String representation of the object
    */
   @Override
   public String toString() {
      String result = "Move From: " + start + " To: " + end +
         " of Type " + moveType;

      return result;
   }
}
