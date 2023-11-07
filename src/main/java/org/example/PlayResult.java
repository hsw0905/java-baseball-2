package org.example;

public class PlayResult {
    private int strike;
    private int ball;

    public PlayResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String report() {
        if (strike != 0 && ball == 0) {
            return strike + BallStatus.STRIKE.getName();
        } else if (strike == 0 && ball != 0) {
            return ball + BallStatus.BALL.getName();
        } else if (strike != 0 && ball != 0) {
            return ball + BallStatus.BALL.getName() + " " + strike + BallStatus.STRIKE.getName();
        }
        return BallStatus.NOTHING.getName();
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void plusStrike() {
        strike++;
    }

    public void plusBall() {
        ball++;
    }

    public void reset() {
        strike = 0;
        ball = 0;
    }
}
