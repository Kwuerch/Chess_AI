package ai;

import board.Board;
import board.Move;

import java.util.List;

/**
 * **RandomAI Class*
 *
 * A class that determines moves as an AI randomly
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class RandomAI extends AI {
   public RandomAI(String name, boolean color) {
      super(name, color);
   }

   /**
    * makeMove
    *
    * Makes a random move on the board
    */
   public void makeMove(Board board) {
      board.move(determineMove(board));
   }

   /**
    * determineMove
    *
    * @return a random move to be played
    */
   private Move determineMove(Board board) {
      List<Move> moves = board.getMoves(super.isWhite());
      int guess;
      
      while (moves.size() > 0) {
         guess = (int)(Math.random() * moves.size());
         if (super.isCheck(board, moves.get(guess))) {
            moves.remove(guess);
         }else{
            return moves.get(guess);
         }
      }
      return null; //Should return checkmate or stalemate
   }
}
