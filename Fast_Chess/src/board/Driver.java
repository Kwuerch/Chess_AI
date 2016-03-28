package board;

/**
 * Driver Class
 *
 * Runs the Chess Program
 */
public class Driver{
   /**
    * Main Method
    */
   public static void main(String[] args){
      Board b = new Board();
      b.generateMoves();
      System.out.println(b);
      System.out.println(b.movesToString());

   }
}
