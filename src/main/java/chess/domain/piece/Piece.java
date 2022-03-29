package chess.domain.piece;

import java.util.function.Consumer;

import chess.domain.Color;
import chess.domain.board.Position;

public abstract class Piece {
	protected static final String INVALID_TARGET_POSITION_EXCEPTION = "이동할 수 없는 위치입니다.";

	private final Color color;

	protected Piece(Color color) {
		this.color = color;
	}

	public final boolean isBlack() {
		return this.color == Color.BLACK;
	}

	public abstract void move(Position beforePosition,
		Position afterPosition,
		Consumer<Piece> moveFunction);

	public abstract void capture(Position beforePosition,
		Position afterPosition,
		Consumer<Piece> moveFunction);

	public boolean isSameCampWith(Piece targetPiece) {
		return this.color == targetPiece.color;
	}

	protected abstract boolean canMove(Position beforePosition, Position afterPosition);

	public abstract double getScore();

	public abstract String getSymbol();

	public boolean isBishop() {
		return false;
	}

	public boolean isKing() {
		return false;
	}

	public boolean isKnight() {
		return false;
	}

	public boolean isPawn() {
		return false;
	}

	public boolean isQueen() {
		return false;
	}

	public boolean isRook() {
		return false;
	}
}
