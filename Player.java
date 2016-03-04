/**
 *  ** Player Interface ** 
 *
 *  An interface that describes a Player  
 *
 *  @author Kyle Wuerch and Sean Wallace
 *  @version Program 7
 */
public interface Player{
   /**
    * move
    *
    * Moves the piece described by the current location to the
    * final location
    *
    * @throws InvalidArgumentException
    */
   public void move(Cell cur, Cell fin);

   /**
    * getName
    *
    * @return the name of the player
    */
   public String getName();
}
