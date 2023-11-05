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
}
