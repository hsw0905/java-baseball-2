package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class BallTest {
    @Test
    void shouldHave3Numbers() {
        List<BallNumber> numberList = Arrays.asList(new BallNumber(1), new BallNumber(2), new BallNumber(3));
        assertThatCode(()-> new Ball(numberList))
                .doesNotThrowAnyException();
    }

    @Test
    void ifNot3NumbersThenThrowException() {
        List<BallNumber> twoNumbers = Arrays.asList(new BallNumber(1), new BallNumber(2));
        assertThatCode(()-> new Ball(twoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자가 필요합니다.");
    }

    @Test
    void ifNumbersDuplicateThenThrowException() {
        List<BallNumber> duplicatedNumbers = Arrays.asList(new BallNumber(1), new BallNumber(2), new BallNumber(2));
        assertThatCode(()-> new Ball(duplicatedNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 중복될 수 없습니다.");
    }
}
