package org.example;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new PlayResult(0, 0));

        game.run();
    }
}