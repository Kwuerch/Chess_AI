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
public abstract class AI{
   private boolean isWhite;
   private String name;

   public AI(String name, boolean isWhite){
      this.isWhite = isWhite;
      this.name = name;
   }

   /**
    * makeMove
    *
    * @return the move the ai has decided to make
    */
   public abstract void makeMove(Board board);


   /**
    * getName
    *
    * @return the name of the player
    */
   public String getName(){
      return name;
   }


   /**
    * isWhite
    *
    * @return if the player's color is white
    */
   public boolean isWhite(){
      return isWhite;
   }
}
