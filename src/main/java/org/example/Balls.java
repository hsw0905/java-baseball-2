package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private static final String WRONG_INPUT_MESSAGE = "3개의 볼이 필요합니다.";
    private static final int SIZE = 3;
    private final List<Ball> list;

    public Balls(List<Ball> balls) {
        validateSize(balls);
        validateDuplicated(balls);
        this.list = balls;
    }

    private void validateDuplicated(List<Ball> balls) {
        Set<Ball> nonDuplicateBalls = new HashSet<>(balls);
        if (nonDuplicateBalls.size() != SIZE) {
            throw new IllegalArgumentException("볼은 중복될 수 없습니다.");
        }
    }

    private void validateSize(List<Ball> balls) {
        if (balls.size() != SIZE) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }

    public BallStatus play(Ball ball) {
        return this.list.stream()
                .map(eachBall -> eachBall.play(ball))
                .filter(result -> result != BallStatus.NOTHING)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(Balls other) {
        PlayResult result = new PlayResult(0, 0);

        for (int i = 0; i < SIZE; i++) {
            if (this.play(other.getBallAt(i)) == BallStatus.STRIKE) {
                result.plusStrike();
            } else if (this.play(other.getBallAt(i)) == BallStatus.BALL) {
                result.plusBall();
            }
        }
        return result;
    }

    private Ball getBallAt(int index) {
        return list.get(index);
    }

}
