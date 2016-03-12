package board;

import pieces.ChessPiece;

import java.util.List;
import java.util.Iterator;

public class Driver{
   public static void main(String[] args){
      Board b = new Board();
      List<Move> moves = b.getMoves();
      for(Move m: moves){
         System.out.println(m);
      }

<<<<<<< HEAD
      System.out.println(b);
=======

      //System.out.println(b);
>>>>>>> 39013a98c90c31da9d5162f554417184c5590119
   }
}
