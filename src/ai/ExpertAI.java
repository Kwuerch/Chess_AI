package ai;

import board.Board;
import board.Move;

import java.util.List;

/**
 * ExpertAI Class
 *
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class ExpertAI extends AI {
   private static double PERCENT = 1;
   private static int RAND_MULT = (int)(100/PERCENT);
   private static int MAX_DEPTH = 2;
   /**
    * ExpertAI Constructor
    *
    * Calls the super constructor
    */
   public ExpertAI(String name, boolean color) {
      super(name, color);
      System.out.println(RAND_MULT);
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
					double val = getMoveValue(board, m, isWhite(), 1, 0);
					if (val > max) {
						maxMove = m;
						max = val;
					}
				}
			}

      if(maxMove == null){
         if(isCheck(board, isWhite())){
            if(isWhite()){
               return new Move(Move.CHECKMATE, true);
            }else{
               return new Move(Move.CHECKMATE, false);
            }
         }else{
            return new Move(Move.STALEMATE);
         }
      }

		return maxMove;	
   }
   /**
    * getMoveValue
    *
    * A recursive method that makes theoretical moves and determines the average value for a move
    */
	public double getMoveValue(Board board, Move move, boolean turnWhite, int branchCount, int depth) {
		Board newBoard = new Board(board);
      newBoard.move(move);

		// Check Base Case
		if (newBoard.isCheckmate(!turnWhite)) {
			return 100.0;
		} else if (branchCount == 0 || depth >= MAX_DEPTH) {
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
                  int chance  = (int)(Math.random() * RAND_MULT);
                  // PERCENT chance of going another branch
                  if(chance == 0){
                     sum += getMoveValue(opBoard, ourMove, turnWhite, branchCount, depth + 1);
                  }else{
                     sum += getMoveValue(opBoard, ourMove, turnWhite, branchCount -1, depth + 1);
                  }
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

}
