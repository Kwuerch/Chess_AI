package board;

import pieces.*;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

/**
 * DirectionalIterator Class
 * Iterates through board in direction specified and finds ChessPieces
 *
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7 
 */
public class DirectionalIterator extends BoardIterator<ChessPiece> {
	private int buffer;
	private int index;
	private ChessPiece[] board;

	/**
	 * Constructor of Directional taking parameters for board, direction and index
    *
	 * @param ChessPiece[] the current board to iterate over
	 * @param int the desired direction of iteration
	 * @param int the desired starting index of the iterator
	 */
	public DirectionalIterator(ChessPiece[] board, int direction, int index) {
		switch (direction) {
			case Board.UP_LEFT:
				buffer = 9;
				break;
			case Board.UP:
				buffer = 10;
				break;
			case Board.UP_RIGHT:
				buffer = 11;
				break;
			case Board.RIGHT:
				buffer = 1;
				break;
			case Board.DOWN_RIGHT:
				buffer = -9;
				break;
			case Board.DOWN:
				buffer = -10;
				break;
			case Board.DOWN_LEFT:
				buffer = -11;
				break;
			case Board.LEFT:
				buffer = -1;
				break;
		}
		this.index = index;
		this.board = board;
	}

	/**
	 * Determines whether there is another spot in the direction specified
    *
	 * @return boolean true if there is a next element
	 */
	public boolean hasNext() {
	ChessPiece p = board[index + buffer];
	
		if (p == null) {
			return true;
		} else if (!p.toString().equals("I")) { // If piece is not invalid
			return true;
		}
		return false;	
	}

	/**
	 * Gets the next chesspiece in the iterator and adds to iterator index
    *
	 * @return the next ChessPiece
	 */
	public ChessPiece next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		
		index += buffer;
		return board[index];
	}

	/**
	 * getIndex
    *
	 * @return the current index of the iterator
	 */
	public int index() {
		return index;
	}
	
	/**
	 * Removes and item from the iterator
    *
	 * @throws UnsupportedOperationException
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
