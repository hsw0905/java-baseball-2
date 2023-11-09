package org.example;

import java.util.Random;

public record BallNumber(int value) {
    private static final String WRONG_INPUT_MESSAGE = "잘못된 입력값입니다. 1~9 사이 숫자를 입력해주세요.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public BallNumber {
        validate(value);
    }

    public static BallNumber getRandomNumber() {
        Random random = new Random();

        return new BallNumber(random.nextInt(MAX_NUMBER - MIN_NUMBER) + MIN_NUMBER);
    }

    private void validate(int value) {
        if (value < MIN_NUMBER || value > MAX_NUMBER) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }
}
