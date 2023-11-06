package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayResultTest {
    private Balls computer;
    @BeforeEach
    void setUp() {
        computer = new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(1), new BallPosition(1)),
                        new Ball(new BallNumber(2), new BallPosition(2)),
                        new Ball(new BallNumber(3), new BallPosition(3))
                )
        );
    }

    @Test
    void play1Strike() {
        Balls user = new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(1), new BallPosition(1)),
                        new Ball(new BallNumber(4), new BallPosition(2)),
                        new Ball(new BallNumber(5), new BallPosition(3))
                )
        );
        PlayResult result = computer.play(user);

        assertThat(result.report()).isEqualTo("1스트라이크");
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play2Strike() {
        Balls user = new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(1), new BallPosition(1)),
                        new Ball(new BallNumber(2), new BallPosition(2)),
                        new Ball(new BallNumber(5), new BallPosition(3))
                )
        );
        PlayResult result = computer.play(user);

        assertThat(result.report()).isEqualTo("2스트라이크");
        assertThat(result.getStrike()).isEqualTo(2);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play3Strike() {
        Balls user = new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(1), new BallPosition(1)),
                        new Ball(new BallNumber(2), new BallPosition(2)),
                        new Ball(new BallNumber(3), new BallPosition(3))
                )
        );
        PlayResult result = computer.play(user);

        assertThat(result.report()).isEqualTo("3스트라이크");
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play1Ball() {
        Balls user = new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(2), new BallPosition(1)),
                        new Ball(new BallNumber(7), new BallPosition(2)),
                        new Ball(new BallNumber(8), new BallPosition(3))
                )
        );
        PlayResult result = computer.play(user);

        assertThat(result.report()).isEqualTo("1볼");
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play2Ball() {
        Balls user = new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(2), new BallPosition(1)),
                        new Ball(new BallNumber(3), new BallPosition(2)),
                        new Ball(new BallNumber(8), new BallPosition(3))
                )
        );
        PlayResult result = computer.play(user);

        assertThat(result.report()).isEqualTo("2볼");
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(2);
    }

    @Test
    void play3Ball() {
        Balls user = new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(2), new BallPosition(1)),
                        new Ball(new BallNumber(3), new BallPosition(2)),
                        new Ball(new BallNumber(1), new BallPosition(3))
                )
        );
        PlayResult result = computer.play(user);

        assertThat(result.report()).isEqualTo("3볼");
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(3);
    }

    @Test
    void play1Ball1Strike() {
        Balls user = new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(2), new BallPosition(1)),
                        new Ball(new BallNumber(7), new BallPosition(2)),
                        new Ball(new BallNumber(3), new BallPosition(3))
                )
        );
        PlayResult result = computer.play(user);

        assertThat(result.report()).isEqualTo("1볼 1스트라이크");
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play2Ball1Strike() {
        Balls user = new Balls(
                Arrays.asList(
                        new Ball(new BallNumber(2), new BallPosition(1)),
                        new Ball(new BallNumber(1), new BallPosition(2)),
                        new Ball(new BallNumber(3), new BallPosition(3))
                )
        );
        PlayResult result = computer.play(user);

        assertThat(result.report()).isEqualTo("2볼 1스트라이크");
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }
}
