package pieces;

import board.Move;

import java.util.List;

/**
 * Invalid Class
 *
 * An object to placed around the board to make determining edges easier
 *
 * @author Kyle Wuerch and Sean Wallace
 * @version Program 7
 */
public class Invalid extends ChessPiece {
   /**
    * Invalid Constructor
    *
    * calls super constructor
    */
   public Invalid() {
      super(true);
   }

   /**
    * Added to make the super happy
    *
    * @throws UnsupportedOperationException
    */
   public void determineMoves() {
      throw new UnsupportedOperationException();
   }

   /**
    * Added to make the super happy
    *
    * @throws UnsupportedOperationException
    */
   public List<Move> getMoves() {
      throw new UnsupportedOperationException();
   }

   /**
    * Added to make the super happy
    *
    * @throws UnsupportedOperationException
    */
   public void determineMoves(int index) {
      throw new UnsupportedOperationException();
   }

   /**
    * Added to make the super happy
    *
    * @throws UnsupportedOperationException
    */
   public double getValue() {
      throw new UnsupportedOperationException();
   }
	
	/**
	 * toString
    *
	 * @return String representation of the piece
	 */
	public String toString() {
		return "I";
	}
}
