package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class BallsTest {
    @Test
    void shouldHave3Ball() {
        assertThatCode(() -> new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(1), new BallPosition(1)),
                        new Ball(new BallNumber(2), new BallPosition(2)),
                        new Ball(new BallNumber(3), new BallPosition(3))
                )
        )).doesNotThrowAnyException();
    }

    @Test
    void ifLessThan3BallThenThrowException() {
        assertThatCode(() -> new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(1), new BallPosition(1)),
                        new Ball(new BallNumber(2), new BallPosition(2))
                )
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 볼이 필요합니다.");
    }

    @Test
    void shouldNotDuplicatedBall() {
        assertThatCode(() -> new Balls(Arrays.asList(
                new Ball(new BallNumber(1), new BallPosition(1)),
                new Ball(new BallNumber(1), new BallPosition(1)),
                new Ball(new BallNumber(1), new BallPosition(1))
        ))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void nothing() {
        Balls computer = new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(1), new BallPosition(1)),
                        new Ball(new BallNumber(2), new BallPosition(2)),
                        new Ball(new BallNumber(3), new BallPosition(3))
                )
        );
        Ball user = new Ball(new BallNumber(4), new BallPosition(1));

        assertThat(computer.play(user)).isEqualTo(BallStatus.NOTHING);

    }

    @Test
    void ball() {
        Balls computer = new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(1), new BallPosition(1)),
                        new Ball(new BallNumber(2), new BallPosition(2)),
                        new Ball(new BallNumber(3), new BallPosition(3))
                )
        );
        Ball user = new Ball(new BallNumber(2), new BallPosition(1));

        assertThat(computer.play(user)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        Balls computer = new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(1), new BallPosition(1)),
                        new Ball(new BallNumber(2), new BallPosition(2)),
                        new Ball(new BallNumber(3), new BallPosition(3))
                )
        );
        Ball user = new Ball(new BallNumber(3), new BallPosition(3));

        assertThat(computer.play(user)).isEqualTo(BallStatus.STRIKE);
    }
}
