package ai;
import java.util.Random;
/**
 * **RandomAI Class*
 *
 * A class that determines moves as an AI randomly
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class RandomAI extends AI{
   public RandomAI(int color){
      super(color);
		Random random = new Random();
   }
   public void DetermineMove(){
	// While(random piece's random iterator !hasNext())
	/**
	 * Inefficient random movement generation methodology.
	 * 1. Get List of possible moves
	 * 		Default Iterator, next to a random location until !null
	 * 2. Pick a random corresponding iterator
	 * 		Dependant on piece found, pick random directional iterator
	 * 3. If the iterator !hasNext(), reset to step 1
	 * 4. Make the move (iterator hasNext())
	 */

   }
}
