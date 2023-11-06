package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    public static final String WRONG_INPUT_MESSAGE = "3개의 볼이 필요합니다.";
    public static final int SIZE = 3;
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
}
