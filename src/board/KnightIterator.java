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
		this.index = index;
		this.board = board;
	}
	
	public boolean hasNext(){
		return false;
	}
	public ChessPiece next(){
		return board[0];
	}
	
	public int index(){
		return index;
	}

	public void remove(){
		throw new UnsupportedOperationException();
	}

}
