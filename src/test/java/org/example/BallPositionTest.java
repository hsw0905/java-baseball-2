package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class BallPositionTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 4})
    void shouldHaveRangeIn1To3(int value) {
        assertThatCode(() -> new BallPosition(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력값입니다. 1~3 사이 숫자를 입력해주세요.");
    }
}
