package board;

import pieces.ChessPiece;
import ai.RandomAI;
import ai.IntermediateAI;
import ai.ExpertAI;
import ai.AI;

import java.util.List;

/**
 * Play Class
 *
 * Play Class runs a game until end
 *
 * @author Kyle Wuerch and Sean Wallace
 * @version Program 7
 */
public class Play {
   private static int moves = 0;
   private static final int MAX_MOVES = 500;

   /**
    * Main Method
    *
    * Runs the game until checkmate, stalemate, or max number of
    * moves mad
    */
   public static void main(String[] args) {
      Board board = new Board();

		AI playerW = new IntermediateAI("Shrek", true, 1);
      //AI playerB = new IntermediateAI("Fiona", true);
		AI playerB = new RandomAI("Fiona", false);
      playGame(playerW, playerB, board);
   }

   /**
    * playGame
    *
    * Begins the game
    */
   private static void playGame(AI playerW, AI playerB, Board board) {
      boolean whiteTurn = true;
      while (true) {
         if (whiteTurn) {
            Move m;
            if(moves++ > MAX_MOVES || board.getNumPieces() == 2){
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
            if(moves++ > MAX_MOVES || board.getNumPieces() == 2){
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

   /**
    * endGame
    *
    * ends the game
    */
   private static void endGame(Move m){
      if(m.isCheckmate()){
         if(m.getStart() == 0){
            System.out.println("Checkmate: Black Got Shrekt!");
         }else{
            System.out.println("Checkmate: White Got Shrekt!");
         }
      }else{
         System.out.println("Stalemate: It's a Tie :(");
      }
   }
}
