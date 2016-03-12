package board;

import pieces.*;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

/**
 * ** KnightIterator Class **
 *
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class KnightIterator extends BoardIterator<ChessPiece>{
	public static final int UP_LEFT = 0;
	public static final int UP_RIGHT = 1;
	public static final int DOWN_LEFT = 2;
	public static final int DOWN_RIGHT = 3;
	
	private int buffer;
	private int index;
	private ChessPiece[] board;

	/**
	 * Constructor of KnightIterator taking parameters for board, direction, and index
	 * @param ChessPiece[] the current board to iterate over
	 * @param int the desired direction of iteration
	 * @param int the desired starting index of the iterator
	 */
	public KnightIterator(ChessPiece[] board, int direction, int index){
		switch(direction){
			case UP_LEFT:
				buffer = 19;
				break;
			case UP_RIGHT:
				buffer = 21;
				break;
			case DOWN_LEFT:
				buffer = -21;
				break;
			case DOWN_RIGHT:
				buffer = -19;
				break;
		}
		this.index = index;
		this.board = board;
	}
	
	/**
 	 * Determines whether there is another spot in the direction specified
	 * @return boolean true if there is a next element
 	 */
	public boolean hasNext(){
		ChessPiece p = board[index + buffer];

		if (p == null){
			return true;
		}else if(!p.toString().equals("I")){
			return true;
		}
		return false;
	}

	/**
	 * Gets the next chesspiece in the iterator and adds to the iterator index
	 * @return the next ChessPiece
 	 */
	public ChessPiece next(){
		if (!hasNext()){
			throw new NoSuchElementException();
		}
		index += buffer;
		return board[index];
	}
	
	/**
	 * Gets the current index
	 * @return the current integer index of the iterator
 	 */
	public int index(){
		return index;
	}

	/**
	 * This (remove) method is not supported and throws an exception
	 * @throws UnsupportedOperationException
 	 */
	public void remove(){
		throw new UnsupportedOperationException();
	}

}
