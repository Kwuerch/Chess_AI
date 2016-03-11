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


      System.out.println(b);
   }
}
