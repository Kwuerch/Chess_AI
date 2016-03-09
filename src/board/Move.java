package board;

import pieces.ChessPiece;

/**
 * Move Class
 *
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class Move{
   private static int QUIET = 0;
   private static int PAWN_DBL = 1;
   private static int EN_PASSANT = 2;
   private static int CASTLE = 3;
   private static int PROMOTION = 4;

   private ChessPiece cp;
   private int start;
   private int end;
   private int moveType;

   public Move(ChessPiece cp, int start, int end, int moveType){

   }

   public String toString(){
      String result = "Move From: " + start + " To: " + end +
         " of Type " + moveType;

      return result;
   }

}
