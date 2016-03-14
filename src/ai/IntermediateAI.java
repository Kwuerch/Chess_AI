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
		Move goodMove = bestMove(board);
		
		return goodMove;
	}
   public Move bestMove(Board board) {
		double max = 0;
		Move maxMove = null; // Possible Danger
		List<Move> moves = board.getMoves(isWhite());
		for (Move m: moves) {
			if (isCheck(board, m, isWhite())) {
				continue;
			} else {
				double val = getMoveValue(board, m, isWhite(), 1);
				System.out.println(val);
				if (val > max) {
					maxMove = m;
					max = val;
				}
			}
		}

		return maxMove;	
   }

	public double getMoveValue(Board board, Move move, boolean turnWhite, int branchCount) {
		Board newBoard = new Board(board);
		if (!isCheck(newBoard, move, turnWhite)) {	
			newBoard.move(move);
		}
		// Check Base Case
		if (newBoard.isCheckmate(!turnWhite)) {
			return 100.0;
		} else if (branchCount == 0) {
			return newBoard.getValue(turnWhite);
		}
		// Continue Going Deeper
		List<Move> opMoves = newBoard.getMoves(!turnWhite);
		double sum = 0;
		int size = 0;
		for (Move m: opMoves) { // Black Turn
			if (isCheck(newBoard, m, !turnWhite)) {
				continue;
			} else {
				Board opBoard = new Board(newBoard);
				List<Move> moves = opBoard.getMoves(turnWhite);
				for (Move m2: moves) {
					if (isCheck(opBoard, m2, turnWhite)) {
						continue;
					} else {
						sum += getMoveValue(opBoard, m2, turnWhite, branchCount -1);
						size ++;
					}	
				}	
			}
		}	
		return sum / (size);
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
