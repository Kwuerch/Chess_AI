package board;

import pieces.ChessPiece;

/**
 * Move Class
 *
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class Move{
   public static int QUIET = 0;
   public static int PAWN_DBL = 1;
   public static int EN_PASSANT = 2;
   public static int ATTACK = 3;
   public static int CASTLE = 4; 
   public static int PROMOTION = 5;

   private ChessPiece cp;
   private int start;
   private int end;
   private int moveType;

   /**
    * Move Constructor
    * Sets the instance variables to the arguments sent in
    */
   public Move(int start, int end, int moveType){
      this.start = start;
      this.end = end;
      this.moveType = moveType;
   }

   /**
    * @return the index for the piece to go
    */
   public int getEnd(){
      return end;
   }

   /**
    * @return the index of the piece to move
    */
   public int getStart(){
      return start;
   }


   /**
    * toString
    * @return a String representation of the object
    */
   @Override
   public String toString(){
      String result = "Move From: " + start + " To: " + end +
         " of Type " + moveType;

      return result;
   }

}
