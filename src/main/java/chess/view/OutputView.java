package chess.view;

import java.util.Map;

import chess.domain.Winner;
import chess.domain.board.Position;
import chess.domain.piece.Piece;

public class OutputView {
    private static final String GAME_START_MESSAGE = "> 체스 게임을 시작합니다.";
    private static final String GAME_COMMAND_FORMAT = "> %s : %s%n";
    private static final String GAME_START_COMMAND_NAME = "게임 시작";
    private static final String GAME_MOVE_COMMAND_NAME = "게임 이동";
    private static final String GAME_END_COMMAND_NAME = "게임 종료";
    private static final String START_COMMAND = "start";
    private static final String END_COMMAND = "end";
    private static final String GAME_MOVE_COMMAND = "move source위치 target위치 - 예. move b2 b3";

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.printf(GAME_COMMAND_FORMAT, GAME_START_COMMAND_NAME, START_COMMAND);
        System.out.printf(GAME_COMMAND_FORMAT, GAME_END_COMMAND_NAME, END_COMMAND);
        System.out.printf(GAME_COMMAND_FORMAT, GAME_MOVE_COMMAND_NAME, GAME_MOVE_COMMAND);
    }

    public void printBoard(Map<Position, Piece> board) {
        int count = 0;
        for (Position position : board.keySet()) {
            String content = makeBoardContentString(board.get(position));
            System.out.print(content);
            count++;
            printNewLineEachRow(count);
        }
    }

    private void printNewLineEachRow(int count) {
        if (count % 8 == 0) {
            System.out.println();
        }
    }

    private String makeBoardContentString(Piece piece) {
        if (piece == null) {
            return ".";
        }
        return decideCaseByColor(piece);
    }

    private String decideCaseByColor(Piece piece) {
        final String pieceString = piece.getSymbol();
        if (piece.isBlack()) {
            return pieceString.toUpperCase();
        }
        return pieceString;
    }

    public void printResult(final double statusOfWhite, final double statusOfBlack, final Winner winner) {
        printFinishMessage();
        printStatus(statusOfWhite, statusOfBlack);
        printWinner(winner);
    }

    private void printFinishMessage() {
        System.out.println("해당 게임이 종료되었습니다.");
    }

    public void printStatus(final double statusOfWhite, final double statusOfBlack) {
        System.out.printf("백 진영 점수 : %.1f%n흑 진영 점수 : %.1f%n", statusOfWhite, statusOfBlack);
    }

    private void printWinner(final Winner winner) {
        if (winner == Winner.BLACK) {
            System.out.println("흑색 진영의 승리입니다.");
            return;
        }
        if (winner == Winner.WHITE) {
            System.out.println("백색 진영의 승리입니다.");
            return;
        }
        System.out.println("무승부입니다.");
    }

    public void printException(final String message) {
        System.out.println(message);
    }
}
