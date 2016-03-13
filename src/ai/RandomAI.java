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
public class RandomAI extends AI{
   public RandomAI(String name, boolean color){
      super(name, color);
   }

   /**
    * makeMove
    *
    * Makes a random move on the board
    */
   public void makeMove(Board board){
      board.move(determineMove(board));
   }

	/**
	 * Inefficient random movement generation methodology.
	 * 1. Get List of possible moves
	 * 		Default Iterator, next to a random location until !null
	 * 2. Pick a random corresponding iterator
	 * 		Dependant on piece found, pick random directional iterator
	 * 3. If the iterator !hasNext(), reset to step 1
	 * 4. Make the move (iterator hasNext())
	 */
   /**
    * determineMove
    *
    * @return a random move to be played
    */
   private Move determineMove(Board board){
      List<Move> moves = board.getMoves(super.isWhite());
      int guess = (int)(Math.random() * moves.size());
      System.out.println("Size of array: " + moves.size() + " Guess: " + guess);
      return moves.get(guess);
   }
}
