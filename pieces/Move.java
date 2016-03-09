/**
 * Move Class
 * Author: Kyle Wuerch
 * Copyright 2015
 */

public class Move {
	int row;
	int col;
	
	public Move(int myRow, int myCol) {
		row = myRow;
		col = myCol;		
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setRow(int myRow) {
		row = myRow;
	}
	
	public void setCol(int myCol) {
		col = myCol;
	}

}
