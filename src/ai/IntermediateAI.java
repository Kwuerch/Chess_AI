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
	private int branchCount;
   public IntermediateAI(String name, boolean color) {
      super(name, color);
		branchCount = 1;	
   }
	public IntermediateAI(String name, boolean color, int branchCount) {
		this(name, color);
		this.branchCount = branchCount;
	
	}

   /**
    * makeMove
    *
    * makes a decently educated move on the board
    */
   public Move makeMove(Board board) {
		return determineMove(board);
   }

	/**
	 * determineMove
	 * determines the next move to make
	 *
	 * @return a calculated move to be played
	 */
	public Move determineMove(Board board) {
		Move bestMove = bestMove(board);
			
		return bestMove;
	}

   public Move bestMove(Board board) {
		double max = -100000;
		Move maxMove = null;
		List<Move> moves = board.getMoves(isWhite());

			for (Move m: moves) {
				if (isCheck(board, m, isWhite())) {
					continue;
				} else {
					double val = getMoveValue(board, m, isWhite(), branchCount);
					if (val > max) {
						maxMove = m;
						max = val;
					}
				}
			}

      if(maxMove == null){
         if(isCheck(board, isWhite())){
            return new Move(Move.CHECKMATE);
         }else{
            return new Move(Move.STALEMATE);
         }
      }

		return maxMove;	
   }

	public double getMoveValue(Board board, Move move, boolean turnWhite, int branchCount) {
		Board newBoard = new Board(board);
      newBoard.move(move);

		// Check Base Case
		if (newBoard.isCheckmate(!turnWhite)) {
			return 100.0;
		} else if (branchCount == 0) {
			return newBoard.getValue(turnWhite);
		}

		// Continue Going Deeper
		List<Move> opMoves = newBoard.getMoves(!turnWhite);
		double sum = 0;
		double size = 0;
		for (Move opMove: opMoves) { // Opponent Turn
			if (!isCheck(newBoard, opMove, !turnWhite)) {
				Board opBoard = new Board(newBoard);
				List<Move> ourMoves = opBoard.getMoves(turnWhite);
				for (Move ourMove: ourMoves) {
					if (!isCheck(opBoard, ourMove, turnWhite)) {
						sum += getMoveValue(opBoard, ourMove, turnWhite, branchCount -1);
						size ++;
					}	
				}
			}
		}	

		if (size == 0) {
			return 0.0;
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
