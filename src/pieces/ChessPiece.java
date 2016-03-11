package pieces;

import board.Board;
import board.BoardIterator;
import board.Move;
import ai.PieceValue;
import java.util.List;

/**
 * ChessPiece Class
 * 
 * @author Kyle Wuerch
 * @version Program 7
 */

public abstract class ChessPiece extends PieceValue{
	private boolean white;
	
	public ChessPiece(boolean white) {
		this.white = white;
	}

   /**
    * movesGen
    * Add moves to a piece's move List after receiving a reference to such list
    * Will only add one move for non multi moves
    * ** Multi is defined to mean a moves that goes more than one space
    */
   public void movesGen(List<Move> moves, BoardIterator<ChessPiece> it, int index, boolean multi){
      boolean hitPiece = false;
      if(multi){
         while(it.hasNext()){
            if(it.next() != null){
               hitPiece = true;
            }
            moves.add(new Move(index, it.index(), Move.QUIET)); 
            if(hitPiece){
               break;
            }
         }
      }else{
         if(it.hasNext()){
            it.next();
            moves.add(new Move(index, it.index(), Move.QUIET)); 
         }
      }
   }

   public abstract List<Move> getMoves();

   public abstract void determineMoves(int index);

   public abstract int getValue();

   /*
   public String debugString(){
      String result = "Moves " + getClass().getName();
		for(int r = 0; r < moves.length; r ++) {
			for(int c = 0; c < moves[0].length; c++) {
				if(moves[r][c]) {
					result += " X ";				
				}else {
					result += " O ";
				}
			 
			}
         result += "\n";
		}
      result += "\n";
		
      result += "AoE " + getClass().getName();
		for(int r = 0; r < AoE.length; r ++) {
			for(int c = 0; c < AoE[0].length; c++) {
				if(AoE[r][c]) {
               result += " X ";
				}else {
               result += " O ";
				}
			 
			}
         result += "\n";
		}
      result += "\n";

      return result;
   }
   */
}
