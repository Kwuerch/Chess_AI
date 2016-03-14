package ai;

import board.Board;
import board.BoardIterator;
import board.Move;

import pieces.ChessPiece;

import java.util.List;

/**
 *  ** AI Class **
 *
 *  Determines what moves to make and makes them
 *
 *  @author Kyle Wuerch an Sean Wallace
 *  @version Program 7
 */
public abstract class AI {
   private boolean isWhite;
   private String name;

   public AI(String name, boolean isWhite) {
      this.isWhite = isWhite;
      this.name = name;
   }

   /**
    * makeMove
    *
    * @return the move the ai has decided to make
    */
   public abstract void makeMove(Board board);

   /**
    * inCheck
    *
    * @return whether or not a specific move puts or leaves the king in check of the current AI
    */
   public boolean isCheck(Board board, Move move) {
      Board newBoard = new Board(board);

      // There should always be a king
      BoardIterator<ChessPiece> it = newBoard.iterator();
      ChessPiece p;
      int index = -1;

      // Find the index of the king
      while(it.hasNext()){
         index = it.index();
         p = it.next();      
         if(p != null && p.getClass().toString().equals("class pieces.King") && 
               p.isWhite() == isWhite){
            break;
         }
      }

      System.out.println("isWhite: " + isWhite + "King is at index: " + index);

      // return true if a move of the opponent is set to end on the king
      List<Move> moves = newBoard.getMoves(!isWhite);

      for(Move m: moves){
         if(m.getEnd() == index){
            return true;
         }
      }
      return false;
   }

   /**
    * getName
    *
    * @return the name of the player
    */
   public String getName() {
      return name;
   }

   /**
    * isWhite
    *
    * @return if the player's color is white
    */
   public boolean isWhite() {
      return isWhite;
   }
}
