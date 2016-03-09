package ai;

import gui.ArtificialPlayer;

/**
 *  ** AI Class **
 *
 *  Determines what moves to make and makes them
 *
 *  @author Kyle Wuerch an Sean Wallace
 *  @version Program 7
 */
public class AI extends ArtificalPlayer{
   Board board;

   /**
    * Constructor
    * Sets super values to their asigned values
    */
   public AI(String name, int white){
      super("The Best", white);
      board = new Board();
   }

   /**
    * updateWith 
    * updates the AI's representation of the board
    */
   public void updateWith(Move m){
      board.update(m);
   }
   
   /**
    * Runs at the beginning of the turn
    */
   protected void startTurnProtected(){

   }
   
   /**
    * Runs at the end of the turn
    */
   protected void startTurnProtected(){

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
