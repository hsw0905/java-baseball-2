package org.example;

public record BallPosition(int value) {
    private static final int MIN_POSITION = 1;
    private static final int MAX_POSITION = 3;
    private static final String WRONG_INPUT_MESSAGE = "잘못된 입력값입니다. 1~3 사이 숫자를 입력해주세요.";

    public BallPosition {
        validate(value);
    }

    private void validate(int value) {
        if (value < MIN_POSITION || value > MAX_POSITION) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }
}
