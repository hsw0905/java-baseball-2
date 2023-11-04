package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ball {
    public static final int SIZE = 3;
    private final List<BallNumber> numberList;

    public Ball(List<BallNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numberList = numbers;
    }

    private void validateDuplicate(List<BallNumber> numbers) {
        Set<BallNumber> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != SIZE) {
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
        }
    }

    private void validateSize(List<BallNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("3개의 숫자가 필요합니다.");
        }
    }

    public List<BallNumber> getNumberList() {
        return numberList;
    }
}
