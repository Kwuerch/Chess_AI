package ai;

import board.Board;
import board.Move;

import java.util.List;
/**
 * IntermediateAI Class
 *
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class IntermediateAI extends AI {
	private int branchCount;

   /**
    * IntermediateAI constructor
    *
    * Calls the AI super and sets the branch count to 1
    */
   public IntermediateAI(String name, boolean color) {
      super(name, color);
		branchCount = 1;	
   }

   /**
    * IntermediateAI constructor
    *
    * Calls the AI super and sets the branch count to the argument branchCount 
    */
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
		//Move move = determineMove(board);
		//System.err.println(move);
		//return move;
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

   /**
    * bestMove
    *
    * @return the best Move given the number of branches to look at
    */
   public Move bestMove(Board board) {
		double max = -100000;
		Move maxMove = null;
		List<Move> moves = board.getMoves(isWhite());

			for (Move m: moves) {
				if (isCheck(board, m, isWhite())) {
					System.err.println("Move is trash: Move puts king in check");
					continue;
				} else {
					double val = getMoveValue(board, m, isWhite(), branchCount);
					if (val > max) {
						//System.err.println(m.toString());
						System.err.println("\nDiscovered New Max!");
						maxMove = m;
						max = val;
					}
				}
			}

      if (maxMove == null) {
         if (isCheck(board, isWhite())) {
            if (isWhite()) {
               return new Move(Move.CHECKMATE, true);
            } else {
               return new Move(Move.CHECKMATE, false);
            }
         } else {
            return new Move(Move.STALEMATE);
         }
      }
		return maxMove;	
   }

   /**
    * getMoveValue
    *
    * A recursive method that makes theoretical moves and determines the average value for a move
	 * @return double number representing the value of a board after making a move
    */
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
		double value = sum / (size);
		System.err.println("\n");
		System.err.println("");
		System.err.println("");
		System.err.println(newBoard);
		System.err.print("Move value: " + value);
		return value;
		//return sum / (size);
	}
}
