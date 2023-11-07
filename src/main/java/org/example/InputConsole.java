package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputConsole {
    public static String readString() {
        String input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            input = br.readLine();
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return input;
    }
}
