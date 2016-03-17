package board;

import java.util.Iterator;

/**
 * BoardIterator Interface
 *
 * An interface representing adding specific implementation to Iterator 
 *
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */

public abstract class BoardIterator<E> implements Iterator<E> {
	/**
	 * Determines whether there is another spot in the direction specified
    *
	 * @return boolean true if there is a next element
	 */
	public  abstract boolean hasNext();

	/**
	 * Gets the next chesspiece in the iterator and adds to iterator index
    *
	 * @return the next ChessPiece
	 */
	public abstract E next();

	/**
	 * Removes and item from the iterator
    *
	 * @throws UnsupportedOperationException
	 */
	public abstract void remove();

	/**
	 * getIndex
    *
	 * @return the current index of the iterator
	 */
	public abstract int index();
}
