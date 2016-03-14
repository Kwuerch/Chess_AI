package board;

import pieces.ChessPiece;
import ai.RandomAI;
import ai.IntermediateAI;
import ai.AI;

import java.util.List;

/**
 * Play
 *
 * Play Class runs a game until end
 *
 * @author Kyle Wuerch and Sean Wallace
 * @version Program 7
 */
public class Play {
   public static void main(String[] args) {
      Board board = new Board();

      AI playerW = new IntermediateAI("Shrek", true);
		//AI playerW = new RandomAI("Shrek", true);
      AI playerB = new RandomAI("Fiona", false);

      playGame(playerW, playerB, board);
   }

   private static void playGame(AI playerW, AI playerB, Board board) {
      boolean whiteTurn = true;
      while (true) {
         if (whiteTurn) {
            playerW.makeMove(board);
            System.out.println(board);
            whiteTurn = !whiteTurn;
         } else {
            playerB.makeMove(board);
            System.out.println(board);
            whiteTurn = !whiteTurn;
         }
      }
   }
}
