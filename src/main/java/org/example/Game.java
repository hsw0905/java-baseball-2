package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    public static final int MAX_STRIKE_COUNT = 3;
    private PlayResult result;

    public Game(PlayResult result) {
        this.result = result;
    }

    public void run() {
        Balls computer = new Balls(
                Arrays.asList(
                        new Ball(BallNumber.getRandomNumber(), new BallPosition(1)),
                        new Ball(BallNumber.getRandomNumber(), new BallPosition(2)),
                        new Ball(BallNumber.getRandomNumber(), new BallPosition(3))
                )
        );

        while(result.getStrike() != MAX_STRIKE_COUNT) {
            System.out.println("숫자를 입력해주세요 : ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputNumber;

            try {
                inputNumber = br.readLine();
                validateLength(inputNumber);
                int toInt = Integer.parseInt(inputNumber);

                Balls user = createUserBalls(toInt);

                result = computer.play(user);
                System.out.println(result.report());

                if (result.getStrike() == MAX_STRIKE_COUNT) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                }
            } catch (IOException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                break;
            }

        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String quitOrContinue = br.readLine();
            if (quitOrContinue.equals("1")) {
                result.reset();
                run();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private Balls createUserBalls(int toInt) {
        List<Ball> balls = new ArrayList<>();
        int div = 10;
        for (int i = 3; i > 0; i--) {
            Ball ball = new Ball(new BallNumber(toInt % div), new BallPosition(i));
            balls.add(ball);
            toInt /= 10;
        }
        return new Balls(balls);
    }

    private void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자를 입력해주세요.");
        }
    }


}
