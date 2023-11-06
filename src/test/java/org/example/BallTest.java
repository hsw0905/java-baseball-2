package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class BallTest {
    @Test
    void shouldHaveBallNumberAndPosition() {
        assertThatCode(()->new Ball(new BallNumber(1), new BallPosition(1)))
                .doesNotThrowAnyException();
    }

    @Test
    void nothing() {
        Ball computer = new Ball(new BallNumber(1), new BallPosition(1));
        Ball user = new Ball(new BallNumber(2), new BallPosition(1));

        assertThat(computer.play(user)).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void ball() {
        Ball computer = new Ball(new BallNumber(1), new BallPosition(1));
        Ball user = new Ball(new BallNumber(1), new BallPosition(2));

        assertThat(computer.play(user)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void strike() {
        Ball computer = new Ball(new BallNumber(1), new BallPosition(1));
        Ball user = new Ball(new BallNumber(1), new BallPosition(1));

        assertThat(computer.play(user)).isEqualTo(BallStatus.STRIKE);
    }
}
