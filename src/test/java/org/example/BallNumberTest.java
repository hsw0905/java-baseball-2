package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class BallNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 10})
    void createNumberFail(int value) {
        assertThatCode(() -> new BallNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력값입니다. 1~9 사이 숫자를 입력해주세요.");
    }
}
