package chess.domain.gamestate;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.domain.board.Board;
import chess.domain.board.Column;
import chess.domain.board.Position;
import chess.domain.board.Row;

public class FinishedTest {

    @DisplayName("Finished 상태에서 start 호출시 Running 상태가 된다.")
    @Test
    void finished_start_running() {
        //given
        State state = new Finished(new Board());
        //then
        assertThat(state.start()).isInstanceOf(Running.class);
    }

    @DisplayName("Finished 상태에서 move 명령 호출시 예외 발생")
    @Test
    void finished_move_exception() {
        //given
        State state = new Finished(new Board());
        Position a2 = Position.of(Column.A, Row.TWO);
        Position a3 = Position.of(Column.A, Row.THREE);
        //then
        assertThatThrownBy(() -> state.move(a2, a3))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("게임이 진행중이 아닐때는 기물을 이동할 수 없습니다.");
    }

    @DisplayName("Finished 상태에서 status 명령 호출할 수 있다.")
    @Test
    void finished_status_no_exception() {
        //given
        State state = new Finished(new Board());
        //then
        assertThatNoException().isThrownBy(state::statusOfBlack);
    }
}
