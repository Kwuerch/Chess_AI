package board;
import pieces.*;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;
/**
 * NormalIterator Class
 * Iterates normally through the entire chess board and finds Chesspieces
 * 
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class NormalIterator extends BoardIterator<ChessPiece> {
	private int index;
	private int min = 21;
	private int max = 98;
	private ChessPiece[] board;
	
	/**
	 * Constructor for NormalIterator
	 */
	public NormalIterator(ChessPiece[] board) {
		index = min;
		this.board = board;
	}

	/**
    * hasNext
    *
	 * Determines whether there is another spot in the direction specified
    *
	 * @return boolean true if there is a next element
	 */
	public boolean hasNext() {
		if (index <= max) {
			return true;
		}	
		return false;
	}

	/**
    * next
    *
	 * Gets the next chesspiece in the iterator and adds to iterator index
    *
	 * @return the current ChessPiece
	 */
	public ChessPiece next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		if (index%10 == 8) {
			index += 3;
			return board[index - 3];
		} else {
			return board[index++];
		}
	}

	/**
    * remove
    *
	 * Removes and item from the iterator
    *
	 * @throws UnsupportedOperationException
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}
	/**
	 * getIndex
    *
	 * @return the current index of the iterator
	 */
	public int index() {
		return index;
	}
}
