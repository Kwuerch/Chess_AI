package board;

import ai.Value;

/**
 *  BoardValue Abstract Class
 *
 *  An class that represents the value of a board
 *
 *  @author Kyle Wuerch and Sean Wallace
 *  @version Program 7
 */
public abstract class BoardValue implements Value {
   /**
    * getValue
    *
    * @return the value of the board 
    * @param : which player is current
    */
   public abstract double getValue(boolean isWhite);

   /**
    * getValue
    * @return the value of the board for the white player
    */
   public abstract double getValue();
}
