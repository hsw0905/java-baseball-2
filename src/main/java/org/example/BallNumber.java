package org.example;

public record BallNumber(int value) {
    public static final String WRONG_INPUT_MESSAGE = "잘못된 입력값입니다. 1~9 사이 숫자를 입력해주세요.";
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public BallNumber {
        validate(value);
    }

    private void validate(int value) {
        if (value < MIN_NUMBER || value > MAX_NUMBER) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }
}
