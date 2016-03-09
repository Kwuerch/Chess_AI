package pieces;

import board.Board;
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

   public abstract List<Move> getMoves();

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
