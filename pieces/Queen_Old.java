/**
 * Queen Class
 * 
 * Author: Kyle Wuerch
 * Copyrigth 2015
 */

public class Queen extends ChessPiece {
	boolean[][] occupied;

	public Queen(int row, int col, boolean white) {
		super(row, col, white);
		occupied = new boolean[8][8];
		updateMoves(Play.b);
		updateAoE(Play.b);
	}
	
	public void updateMoves(Board board) {
		//Cant forget that bishop cant pass through objects
		
		//Set all spots to false
		for(int row = 0; row < moves.length; row ++) {
			for(int col = 0; col < moves[-0].length; col ++) {
				moves[row][col] = false;
				occupied[row][col] = false;
			}
		}
		
		//Update Occupied spots
		for(ChessPiece p: board) {
			occupied[p.getRow()][p.getCol()] = true;
		}
		
		//Row and Col Iterators
		int rowIt = getRow();
		int colIt = getCol();

		//  \
		//   \ diagnoal left above
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			rowIt = rowIt - 1;
			colIt = colIt - 1;
			
			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
			
			if(occupied[rowIt][colIt]) {
				break;
			}else {
				moves[rowIt][colIt] = true;
			}
		}
		
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();
		
		//  \
		//   \ diagonal left below
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			rowIt = rowIt + 1;
			colIt = colIt + 1;

			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
						
			if(occupied[rowIt][colIt]) {
				break;
			}else {
				moves[rowIt][colIt] = true;
			}
		}
		
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();
		
		//    /
		//   / diagonal right above
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			rowIt = rowIt - 1;
			colIt = colIt + 1;

			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
			
			if(occupied[rowIt][colIt]) {
				break;
			}else {
				moves[rowIt][colIt] = true;
			}
		}
		
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();
		
		//	  /
		//   / diagonal right below
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			rowIt = rowIt + 1;
			colIt = colIt - 1;

			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
			
			if(occupied[rowIt][colIt]) {
				break;
			}else {
				moves[rowIt][colIt] = true;
			}
		}
				
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();

		//   -- Straigh left
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			colIt --;
				
			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
					
			if(occupied[rowIt][colIt]) {
				break;
			}else {
				moves[rowIt][colIt] = true;
			}
		}
				
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();
				
		//  Straight Right --
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			colIt ++;

			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
								
			if(occupied[rowIt][colIt]) {
				break;
			}else {
				moves[rowIt][colIt] = true;
			}
		}
				
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();
				
		//    Straight Up ^
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			rowIt --;

			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
					
			if(occupied[rowIt][colIt]) {
				break;
			}else {
				moves[rowIt][colIt] = true;
			}
		}
				
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();
				
		//	  Straight Down v
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			rowIt ++;

			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1 ) {
				break;
			}
					
			if(occupied[rowIt][colIt]) {
				break;
			}else {
				moves[rowIt][colIt] = true;
			}
		}

	}
	
	public void updateAoE(Board board) {
		//Cant forget that bishop cant pass through objects
		
		//Set all spots to false
		for(int row = 0; row < AoE.length; row ++) {
			for(int col = 0; col < AoE[-0].length; col ++) {
				AoE[row][col] = false;
				occupied[row][col] = false;
			}
		}
		
		//Update Occupied spots
		for(ChessPiece p: board) {
			occupied[p.getRow()][p.getCol()] = true;
		}
		
		//Row and Col Iterators
		int rowIt = getRow();
		int colIt = getCol();

		//  \
		//   \ diagnoal left above
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			rowIt = rowIt - 1;
			colIt = colIt - 1;
			
			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
			
			if(occupied[rowIt][colIt]) {
				AoE[rowIt][colIt] = true;
				break;
			}else {
				AoE[rowIt][colIt] = true;
			}
		}
		
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();
		
		//  \
		//   \ diagonal left below
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			rowIt = rowIt + 1;
			colIt = colIt + 1;

			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
						
			if(occupied[rowIt][colIt]) {
				AoE[rowIt][colIt] = true;
				break;
			}else {
				AoE[rowIt][colIt] = true;
			}
		}
		
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();
		
		//    /
		//   / diagonal right above
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			rowIt = rowIt - 1;
			colIt = colIt + 1;

			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
			
			if(occupied[rowIt][colIt]) {
				AoE[rowIt][colIt] = true;
				break;
			}else {
				AoE[rowIt][colIt] = true;
			}
		}
		
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();
		
		//	  /
		//   / diagonal right below
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			rowIt = rowIt + 1;
			colIt = colIt - 1;

			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
			
			if(occupied[rowIt][colIt]) {
				AoE[rowIt][colIt] = true;
				break;
			}else {
				AoE[rowIt][colIt] = true;
			}
		}
				
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();

		//   -- Straigh left
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			colIt --;
				
			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
					
			if(occupied[rowIt][colIt]) {
				AoE[rowIt][colIt] = true;
				break;
			}else {
				AoE[rowIt][colIt] = true;
			}
		}
				
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();
				
		//  Straight Right --
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			colIt ++;

			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
								
			if(occupied[rowIt][colIt]) {
				AoE[rowIt][colIt] = true;
				break;
			}else {
				AoE[rowIt][colIt] = true;
			}
		}
				
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();
				
		//    Straight Up ^
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			rowIt --;

			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1) {
				break;
			}
					
			if(occupied[rowIt][colIt]) {
				AoE[rowIt][colIt] = true;
				break;
			}else {
				AoE[rowIt][colIt] = true;
			}
		}
				
		//Reset Row and Col Iterators
		rowIt = getRow();
		colIt = getCol();
				
		//	  Straight Down v
		while(rowIt < 8 && rowIt > -1 && colIt < 8 && colIt > -1) {
			rowIt ++;

			if(rowIt == 8 || rowIt == -1 || colIt == 8 || colIt == -1 ) {
				break;
			}
					
			if(occupied[rowIt][colIt]) {
				AoE[rowIt][colIt] = true;
				break;
			}else {
				AoE[rowIt][colIt] = true;
			}
		}

	}
}
