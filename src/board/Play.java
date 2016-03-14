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

      //AI playerW = new IntermediateAI("Shrek", true);
		AI playerW = new RandomAI("Shrek", true);
      AI playerB = new RandomAI("Fiona", false);

      playGame(playerW, playerB, board);
   }

   private static void playGame(AI playerW, AI playerB, Board board) {
      boolean whiteTurn = true;
      while (true) {
         if (whiteTurn) {
            Move m;
            if(board.getNumPieces() == 2){
               m = new Move(Move.STALEMATE);
            }else{
               m = playerW.makeMove(board);
            }

            if(m.isCheckmate() || m.isStalemate()){
               endGame(m);
               break;
            }else{
               board.move(m);
               System.out.println(board);
               whiteTurn = !whiteTurn;
            }
         } else {
            Move m;
            if(board.getNumPieces() == 2){
               m = new Move(Move.STALEMATE);
            }else{
               m = playerB.makeMove(board);
            }

            if(m.isCheckmate() || m.isStalemate()){
               endGame(m);
               break;
            }else{
               board.move(m);
               System.out.println(board);
               whiteTurn = !whiteTurn;
            }
         }
      }
   }

   private static void endGame(Move m){
      if(m.isCheckmate()){
         System.out.println("Checkmate");
      }else{
         System.out.println("Stalemate");
      }
   }
}
