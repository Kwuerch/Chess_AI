package ai;

import board.Board;
import board.Move;

/**
 *  ** AI Class **
 *
 *  Determines what moves to make and makes them
 *
 *  @author Kyle Wuerch an Sean Wallace
 *  @version Program 7
 */
public class AI{
   private Board board;

   public AI(int color){
      board = new Board();

   }


   /**
    * updateWith 
    * updates the AI's representation of the board
    */
   public void updateWith(Move m){
      //board.update(m);
   }
   
   /**
    * Runs at the beginning of the turn
    */
   protected void startTurnProtected(){

   }
   
   /**
    * Runs at the end of the turn
    * endTurnProtected 
    */
   public void endTurnProtected(){

   }

   /**
    * getName
    *
    * @return the name of the player
    */
   public String getName(){
      return null;
   }
}
