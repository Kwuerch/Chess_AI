package ai;
import java.lang.UnsupportedOperationException;
import java.lang.Iterable;
import java.util.Iterator;
/**
 * ** Board Class **
 * Represents the chess board, implements iterator and finds ChessPieces.
 *
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class Board implements Iterable<ChessPiece>{
   public java.util.Iterator<ChessPiece> iterator(){
      return new BoardIterator();
   }
   private class BoardIterator implements Iterator<ChessPiece>{
      public boolean hasNext(){
      }
      public ChessPiece next(){
      }
      public void remove(){
         throw new UnsupportedOperationException();
      }
   }
}


