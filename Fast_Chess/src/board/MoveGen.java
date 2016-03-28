package board;

/**
 * MoveGen Class
 *
 * This Class is a test class
 * to determine the correct bit manipulation
 * for move generation of pieces
 *
 * @author Kyle Wuerch
 * @version 1.0
 */
public class MoveGen{
   //Must Consider "Edge of Board"
   public static long movesQueen(long ourBoard, long Queen){
      long MOVES = 0;

      for(int i = 1; i < 8; i ++){
         //MOVES |= Queen >>> i & ~ourBoard;
         MOVES |= Queen >>> (7*i) & ~ourBoard;
         MOVES |= Queen >>> (8*i) & ~ourBoard;
         MOVES |= Queen >>> (9*i) & ~ourBoard;
         //MOVES |= Queen << i & ~ourBoard;
         MOVES |= Queen << (7*i) & ~ourBoard;
         MOVES |= Queen << (8*i) & ~ourBoard;
         MOVES |= Queen << (9*i) & ~ourBoard;
      }

      return MOVES; 
   }
   public static long movesKing(long ourBoard, long King){
      long MOVES = 0;

      MOVES |= King >>> 1 & ~ourBoard;
      MOVES |= King >>> 7 & ~ourBoard;
      MOVES |= King >>> 8 & ~ourBoard;
      MOVES |= King >>> 9 & ~ourBoard;
      MOVES |= King << 1 & ~ourBoard;
      MOVES |= King << 7 & ~ourBoard;
      MOVES |= King << 8 & ~ourBoard;
      MOVES |= King << 9 & ~ourBoard;

      return MOVES; 
   }

   public static long movesKnight(long ourBoard, long Knight){
      long MOVES = 0;

      MOVES |= Knight >>> 10 & ~ourBoard;
      MOVES |= Knight >>> 17 & ~ourBoard;
      MOVES |= Knight >>> 15 & ~ourBoard;
      MOVES |= Knight >>> 6 & ~ourBoard;
      MOVES |= Knight << 10 & ~ourBoard;
      MOVES |= Knight << 17 & ~ourBoard;
      MOVES |= Knight << 15 & ~ourBoard;
      MOVES |= Knight << 6 & ~ourBoard;

      return MOVES; 
   }

   public static long movesWhitePawn(long opBoard, long fullBoard, long Pawn){
      long MOVES = 0;

      //Diagonal Attack
      MOVES |= Pawn << 7 & opBoard;
      MOVES |= Pawn << 9 & opBoard;

      //Singular Forward Move
      MOVES |= Pawn << 7 & ~fullBoard;

      return MOVES; 
   }

   public static long movesBlackPawn(long opBoard, long fullBoard, long Pawn){
      long MOVES = 0;

      //Diagonal Attack
      MOVES |= Pawn >>> 7 & opBoard;
      MOVES |= Pawn >>> 9 & opBoard;

      //Singular Forward Move
      MOVES |= Pawn >>> 8 & ~fullBoard;

      return MOVES; 
   }
}
