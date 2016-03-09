package core;

public enum ChessPiece {
	
	WHITE_PAWN(ChessColor.WHITE, PieceType.PAWN, "\u2659"),
	WHITE_KNIGHT(ChessColor.WHITE, PieceType.KNIGHT, "\u2658"),
	WHITE_BISHOP(ChessColor.WHITE, PieceType.BISHOP, "\u2657"),
	WHITE_ROOK(ChessColor.WHITE, PieceType.ROOK, "\u2656"),
	WHITE_QUEEN(ChessColor.WHITE, PieceType.QUEEN, "\u2655"),
	WHITE_KING(ChessColor.WHITE, PieceType.KING, "\u2654"),
	BLACK_PAWN(ChessColor.BLACK, PieceType.PAWN, "\u265F"),
	BLACK_KNIGHT(ChessColor.BLACK, PieceType.KNIGHT, "\u265E"),
	BLACK_BISHOP(ChessColor.BLACK, PieceType.BISHOP, "\u265D"),
	BLACK_ROOK(ChessColor.BLACK, PieceType.ROOK, "\u265C"),
	BLACK_QUEEN(ChessColor.BLACK, PieceType.QUEEN, "\u265B"),
	BLACK_KING(ChessColor.BLACK, PieceType.KING, "\u265A");
	
	private final ChessColor color;
	private final PieceType type;
	private final String unicode;
	
	ChessPiece(ChessColor color, PieceType type, String uni) {
		this.color = color;
		this.type = type;
		this.unicode = uni;
	}

	public String getUnicode() {
		return unicode;
	}

	public ChessColor getColor() {
		return color;
	}

	public PieceType getType() {
		return type;
	}
	
	public int score() {
		return type.score();
	}

	@Override
	public String toString() {
		return "ChessPiece [color=" + color + ", type=" + type + ", unicode=" + unicode + "]";
	}
	
	
	public int value() {
		return this.ordinal();
	}
	
	public static boolean isValid(int piece) {
		return WHITE_PAWN.value() >= piece && piece <= BLACK_KING.value();
	}
	
	public static ChessPiece from(int piece) {
		assert isValid(piece);
		
		return ChessPiece.values()[piece];
	}
	
	public static ChessPiece from(int color, int type) {
		return ChessPiece.values()[(6 * color) + type];
	}
	
	public static ChessPiece from(ChessColor color, PieceType type) {
		return ChessPiece.from(color.value(), type.value());
	}
}