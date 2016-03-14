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
		board.move(determineMove(board));
   }

	/**
	 * determineMove
	 * determines the next move to make
	 *
	 * @return a calculated move to be played
	 */
   public Move determineMove(Board board) {
		List<Move> moves = board.getMoves(super.isWhite());
		List<Board> boards;
		boolean color = isWhite();
		
		
		
		return null;
   }

	/**
	 * findMax
	 *
	 * Finds the maximum score in an array.
	 * @return int value of the max score in an array
	 */
	private int findMax(int[] scores) {
		int max = scores[0];
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= max) {
				max = scores[i];
			}
		}
		return max;
	}

	/**
	 * findMin
	 *
	 * Finds the minimum score in an array
	 * @return int value of the minimum score in an array
	 */
	private int findMin(int[] scores) {
		int min = scores[0];
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] <= min) {
				min = scores[i];
			}
		}
		return min;
	}
}
