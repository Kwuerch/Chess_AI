package pieces;

import ai.Value;

/**
 *  PieceValue Abstract Class
 *
 *  An abstract class that represents the value of a piece  
 *
 *  @author Kyle Wuerch and Sean Wallace
 *  @version Program 7
 */

public abstract class PieceValue implements Value {
   /**
    * getValue
    *
    * @return the value of the Piece 
    */
   public abstract double getValue();
}
