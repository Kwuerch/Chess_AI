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
      List<Move> moves1 = board.getMoves(super.isWhite());
		List<Move> moves2 = board.getMoves(super.isWhite());
		List<Move> moves3 = board.getMoves(super.isWhite());

      int guess1;
		int guess2;
		int guess3;
      
		Move move1 = null;
		Move move2 = null;
		Move move3 = null;

		Board board1 = new Board(board);
		Board board2 = new Board(board);
		Board board3 = new Board(board);

      while (move1 == null) {
         guess1 = (int)(Math.random() * moves1.size());
         if (super.isCheck(board1, moves1.get(guess1))) {
            moves1.remove(guess1);
         } else {
         	move1 = moves1.get(guess1);
         }
      }
		while (move2 == null) {
         guess2 = (int)(Math.random() * moves2.size());
         if (super.isCheck(board2, moves2.get(guess2))) {
            moves2.remove(guess2);
         } else {
         	move2 = moves2.get(guess2);
         }
      }
		while (move3 == null) {
         guess3 = (int)(Math.random() * moves3.size());
         if (super.isCheck(board3, moves3.get(guess3))) {
            moves3.remove(guess3);
         } else {
         	move3 = moves3.get(guess3);
         }
      }
		if (move1 != null) {
			System.out.println("Virtually Made move 1");
			board1.move(move1);
			}
		if (move2 != null) {
			board2.move(move2);
			System.out.println("Virtually Made move 2");
		}
		if (move3 != null) {
			board3.move(move3);
			System.out.println("Virtually Made move 3");
		}
		System.out.println(move1);
		System.out.println(move2);
		System.out.println(move3);
		// Find board with max value
		if (board1.getValue(isWhite()) > board2.getValue(isWhite())) {
			if (board1.getValue(isWhite()) > board3.getValue(isWhite())) {
				System.out.println("Move 1 biggest");
				return move1;
			}

		} else {
			if (board2.getValue(isWhite()) > board3.getValue(isWhite())) {
				System.out.println("Move 2 biggest");
				return move2;
			}
			System.out.println("Move 3 biggest");
			return move3;
		}

		if (move1 != null ) {
			return move1;
		}
		if (move2 != null) {
			return move2;
		}
		if (move3 != null) {
			return move3;
		}

      if (isCheck(board, isWhite())){
         return new Move(Move.CHECKMATE);
      } else {
         return new Move(Move.STALEMATE);
      }
	}
}
