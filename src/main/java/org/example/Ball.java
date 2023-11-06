package org.example;

import java.util.Objects;

public class Ball {


    private final int number;
    private final int position;

    public Ball(BallNumber ballNumber, BallPosition ballPosition) {
        this.number = ballNumber.value();
        this.position = ballPosition.value();
    }

    public BallStatus play(Ball other) {
        if (this.number == other.number && this.position == other.position) {
            return BallStatus.STRIKE;
        } else if (this.number == other.number){
            return BallStatus.BALL;
        } else {
            return BallStatus.NOTHING;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
