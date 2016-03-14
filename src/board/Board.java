package board;

import pieces.*;
import java.util.List;
import java.util.ArrayList;
import java.lang.Iterable;
import java.util.Iterator;

/**
 * ** Board Class **
 * Represents the chess board, implements iterator and finds ChessPieces.
 * Note: White is always the bottom starting at index 11.
 *
 * @author Kyle Wuerch, Sean Wallace
 * @version Program 7
 */
public class Board extends BoardValue implements Iterable<ChessPiece> {
	public static final int UP_LEFT = 0;
   public static final int UP = 1;
   public static final int UP_RIGHT = 2;
   public static final int RIGHT = 3;
   public static final int DOWN_RIGHT = 4;
   public static final int DOWN = 5;
   public static final int DOWN_LEFT = 6;
   public static final int LEFT = 7;

   private ChessPiece[] board;
   private List<Move> moves;
	
  /**
    * Constructor for Board
    */
   public Board() {
      board = new ChessPiece[120];
      moves = new ArrayList<Move>();
      setupBoard();
   }

   /**
    * Constructor for new Board from previous board
    */
   public Board(Board oldBoard) {
      board = new ChessPiece[120];
      moves = new ArrayList<Move>();
      ChessPiece[] oldBoardArr = oldBoard.getBoardArray();
      for (int i = 0; i < oldBoardArr.length; i++) {
         if (oldBoardArr[i] != null) {
            String type = oldBoardArr[i].getClass().toString();
            if (type.equals("class pieces.Invalid")) {
               board[i] = new Invalid();
            } else if (type.equals("class pieces.Pawn")) {
               Pawn p = (Pawn)oldBoardArr[i];
               board[i] = new Pawn(this, p.isWhite(), p.getMadeMove());
            } else if (type.equals("class pieces.Rook")) {
               Rook r = (Rook)oldBoardArr[i];
               board[i] = new Rook(this, r.isWhite());
            } else if (type.equals("class pieces.Bishop")) {
               Bishop b = (Bishop)oldBoardArr[i];
               board[i] = new Bishop(this, b.isWhite());
            } else if (type.equals("class pieces.Knight")) {
               Knight k = (Knight)oldBoardArr[i];
               board[i] = new Knight(this, k.isWhite());
            } else if (type.equals("class pieces.Queen")) {
               Queen q = (Queen)oldBoardArr[i];
               board[i] = new Queen(this, q.isWhite());
            } else { // Piece is King
               King k = (King)oldBoardArr[i];
               board[i] = new King(this, k.isWhite());
            }
         } else {
            board[i] = null;
         }
      }
   }

   /**
    * setupBoard
    * Add the correct pieces to the board
    */
   private void setupBoard() {
		int buffer = 1;
		// Invalids Left to right (bottom)
		for (int i = 1; i < 9; i++) {
			board[i] = new Invalid();
		}
		for (int i = 11; i < 19; i++) {
			board[i] = new Invalid();
		}
		// Invalids left to right (top)
		for (int i = 101; i < 109; i++) {
			board[i] = new Invalid();
		}
		for (int i = 111; i < 119; i++) {
			board[i] = new Invalid();
		}
		// Invalids bottom to top (left)
		for (int i = 0; i < 111; i+=10) {
			board[i] = new Invalid();
		}
		//Invalids bottom to top (right)
		for (int i = 9; i < 120; i+=10) {
			board[i] = new Invalid();
		}

      // Black
      board[91] = new Rook(this, false);
      board[98] = new Rook(this, false);

      board[92] = new Knight(this, false);
      board[97] = new Knight(this, false);

      board[93] = new Bishop(this, false);
      board[96] = new Bishop(this, false);

      board[94] = new Queen(this, false);
      board[95] = new King(this, false);

      for (int i = 81; i < 89; i++) {
         board[i] = new Pawn(this, false);
      }

      // White
      board[21] = new Rook(this, true);
      board[28] = new Rook(this, true);

      board[22] = new Knight(this, true);
      board[27] = new Knight(this, true);

      board[23] = new Bishop(this, true);
      board[26] = new Bishop(this, true);

      board[24] = new Queen(this, true);
      board[25] = new King(this, true);

      for (int i = 31; i < 39; i++) {
         board[i] = new Pawn(this, true);
      }
   }

   /**
    * findMoves
    * Adds the moves of all pieces of the current board 
    */
   private void findMoves(boolean isWhite) {
      moves.clear();
		BoardIterator<ChessPiece> it = iterator();
		while (it.hasNext()) {
			int index = it.index();
			ChessPiece p = it.next();
			if (p != null && p.isWhite() == isWhite) {
				p.determineMoves(index);
				moves.addAll(p.getMoves());
			}
		}
   }

   /**
    * Move
    *
    * Puts the piece on the designated end spot and sets
    * the start spot to null
    *
    * @param Move object denoting where to move the object
    */
   public void move(Move move) {
      ChessPiece p = board[move.getStart()];

      if(p.getClass().toString().equals("class pieces.Pawn")){
         ((Pawn)p).madeMove();
      }

      // Auto Promotion of Pawn to Queen
      if(move.getMoveType() == Move.PROMOTION){
         p = new Queen(this, p.isWhite());
      }


      board[move.getEnd()] = p;
      board[move.getStart()] = null;
   }

   /**
    * getValue
    * @return the value of the white player's pieces
    */
   public double getValue() {
      return getValue(true);
   }

   /**
    * getValue
    * @param : Which Player to Calculate for 
    * @return the value of all the pieces of a certain color 
    * TODO: Improve and Test
    */
    public double getValue(boolean isWhite) {
      double currentValue = 0;
		BoardIterator<ChessPiece> it = iterator();
		while(it.hasNext()){
         // Kingsjhave infinite value, do no consider in pointage
			ChessPiece p = it.next();
         if (p != null && !p.getClass().toString().equals("class pieces.King")) {
            if (p.isWhite() == isWhite) {
               currentValue += p.getValue();
            } else {
					currentValue -= p.getValue();
				}
         }
		}
		List<Move> moves = getMoves(isWhite);
		List<Move> opMoves = getMoves(!isWhite);
      return currentValue + moves.size();
    }

   /**
    * getMoves
    * @return all the possible moves for the current board
    */
    public List<Move> getMoves(boolean isWhite) {
       findMoves(isWhite);
       return moves;
    }

   /**
    * @return if the player with a specific color is in checkmate
    * TODO: Improve and test
    */
    public boolean isCheckmate(boolean isWhite) {
       // If Current Player King has moves: Not Checkmate
       for(Move m: moves) {
          ChessPiece p = board[m.getStart()];
          if(p.getClass().toString().equals("class pieces.King")) {
             if(p.isWhite() == isWhite) {
                return false;
             }
          }
       }
       // Therefore King has no moves

       // If Opponent end move is King: Checkmate
       for(Move m: moves) {
          ChessPiece p = board[m.getEnd()];
          if(p.getClass().toString().equals("class pieces.King")) {
             if(p.isWhite() != isWhite) {
                return true;
             }
          }
       }
       return false;
    }

    /**
     * getNumPieces
     *
     * @return the total number of pieces on the board
     */
    public int getNumPieces(){
       int size;

       BoardIterator<ChessPiece> it = iterator();
       while(it.hasNext()){
          if(it.next() != null){
             size ++;
          }
       }

       return size;
    }


   /**
    * @param int the desired direction of iteration
    * @return a board iterator that iterates through the direction specified
    */
   public BoardIterator<ChessPiece> boardIterator(int direction, int index) {
      return new DirectionalIterator(board, direction, index);
   }

   /**
    * iterator
    * @return a default iterator to go through each space
    */
   public BoardIterator<ChessPiece> knightIterator(int direction, int index) {
      return new KnightIterator(board, direction, index);
   }
   
   /**
    * iterator
    * @return a default iterator to go through each space
    */
   public BoardIterator<ChessPiece> iterator() {
      return new NormalIterator(board);
   }

   /**
    * getBoardArray
    *
    * @return the board array
    * Only to be used by the Board Constructor
    */
   private ChessPiece[] getBoardArray() {
      return board;
   }

   /**
    * toString
    * @return a String representation of the Board
    */
   public String toString() {
		String result = "";
		int min = 56;
		int index = 0;

		ChessPiece[] array = new ChessPiece[64];
		BoardIterator<ChessPiece> it = iterator();

		while (it.hasNext()) {
			array[index++] = it.next();	
		}

		while (min > -1) {
         for (int i = min; i < min + 8; i++) {
            if (array[i] == null) {
               result += " ☐";
            } else {
               result += " " +  array[i].toString();
            }
         }
         result += "\n";
         min -= 8;
      }
      return result;   
   }
}
