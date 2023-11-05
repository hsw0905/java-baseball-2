package org.example;

public class BallPosition {
    public static final int MIN_POSITION = 1;
    public static final int MAX_POSITION = 3;
    private static final String WRONG_INPUT_MESSAGE = "잘못된 입력값입니다. 1~3 사이 숫자를 입력해주세요.";
    private final int value;

    public BallPosition(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_POSITION || value > MAX_POSITION) {
            throw new IllegalArgumentException(WRONG_INPUT_MESSAGE);
        }
    }
}
