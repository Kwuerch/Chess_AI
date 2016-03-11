package board;

import pieces.ChessPiece;

import java.util.Iterator;

public class Driver{
   public static void main(String[] args){
      Board b = new Board();
      BoardIterator<ChessPiece> it = b.iterator();
      while(it.hasNext()){
         ChessPiece p = it.next();
         if(p != null){
            p.determineMoves(it.index());
            for(Move m: p.getMoves()){
               System.out.println(m);
            }
         }
      }
      System.out.println(b);
   }
}
