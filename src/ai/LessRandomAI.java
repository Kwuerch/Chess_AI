package ai;

import board.Board;
import board.Move;

import java.util.List;
import java.util.ArrayList;

/**
 * **LessRandomAI Class*
 *
 * A class that determines moves as an AI less randomly
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class LessRandomAI extends AI {
   public LessRandomAI(String name, boolean color) {
      super(name, color);
   }

   /**
    * makeMove
    *
    * Makes a random move on the board
    */
   public Move makeMove(Board board) {
      return determineMove(board);
   }

   /**
    * determineMove
    *
    * @return a random move to be played
    */
   private Move determineMove(Board board) {
      int guess;
		int index = 0;
		double previousMaxScore = 0;
		double maxScore = 0;
		Move moveToMake = null;

		List<Move> moves = board.getMoves(super.isWhite());
		ArrayList<Board> boards = new ArrayList<Board>();
		ArrayList<Double> scores = new ArrayList<Double>();
		for (Move m: moves) {
			Board branchOne = new Board(board);
			branchOne.move(m);
			boards.add(branchOne);
			scores.add(branchOne.getValue(isWhite()));	
			List<Move> blackMoves = board.getMoves(!isWhite());	

			double max = 0;
			for (int i = 0; i < scores.size(); i++) {
				if (scores.get(i) > max) {
					max = scores.get(i);
					index = i;
				}
			}
		}
		return moves.get(index);
	}
	



		/*
		List<Move> moves = board.getMoves(super.isWhite());
		for (Move m: moves) {
			maxScore = 0;
			Board branchOne = new Board(board);
			branchOne.move(m);
			List<Move> branchOneMoves = branchOne.getMoves(!isWhite());
			maxScore += branchOne.getValue(true);
			for (Move m2: branchOneMoves) {
				Board branchTwo = new Board(branchOne);
				branchTwo.move(m2);
				List<Move> branchTwoMoves = branchTwo.getMoves(isWhite());
				maxScore -= branchTwo.getValue(false);	
				if (moves.size() == 0) {
					return m;
				}
				if (maxScore < previousMaxScore) {
				}
				previousMaxScore = maxScore;

				/*
				for (Move m3: branchTwoMoves) {
					Board branchThree = new Board(branchTwo);
					branchThree.move(m3);
					List<Move> branchThreeMoves = branchThree.getMoves(!isWhite());
					maxScore += branchThree.getValue(true);
					for (Move m4: branchThreeMoves) {
						Board branchFour = new Board (branchThree);
						branchFour.move(m4);
						maxScore -= branchFour.getValue(false);
						if (maxScore < previousMaxScore) {
							moves.remove(m);
						}
						previousMaxScore = maxScore;
					}
					
				}*/
			//}
/*
		}

      while (moves.size() > 0) {
         guess = (int)(Math.random() * moves.size());
         if (super.isCheck(board, moves.get(guess))) {
            moves.remove(guess);
         } else {
            return moves.get(guess);
         }
      }

      if (isCheck(board, isWhite())) {
         return new Move(Move.CHECKMATE);
      } else {
         return new Move(Move.STALEMATE);
      }
	*/
   //}
}
