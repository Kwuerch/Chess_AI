package ai;

import board.Board;
import board.Move;

import java.util.List;
/**
 * ** IntermediateAI Class*
 * Beats a RandomAI
 *
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class IntermediateAI extends AI {
   public IntermediateAI(String name, boolean color) {
      super(name, color);
   }

   /**
    * makeMove
    *
    * makes a decently educated move on the board
    */
   public void makeMove(Board board) {
   }

	/**
	 * determineMove
	 * determines the next move to make
	 *
	 * @return a calculated move to be played
	 */
   public void determineMove(Board board) {
		List<Move> moves = board.getMoves(super.isWhite());
   }
}
