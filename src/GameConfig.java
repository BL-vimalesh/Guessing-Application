package src;

import java.util.Scanner;
import java.util.Random;

public class GameConfig {
    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 7;
    private final int MAX_HINTS = 3;

    private int target_number;

    public GameConfig() {
        Random random = new Random();
        this.target_number = random.nextInt(MAX - MIN + 1) + MIN;
    }

    public int getTarget_number() {
        return target_number;
    }

    public int getMAX_ATTEMPTS() {
        return MAX_ATTEMPTS;
    }

    public int getMAX_HINTS() {
        return MAX_HINTS;
    }

    public int getMIN() {
        return MIN;
    }

    public int getMAX() {
        return MAX;
    }

    public void show() {
        System.out.println("Guess the Number between " + MIN + " and " + MAX);
        System.out.println("You have " + MAX_ATTEMPTS + " Attempts");
        System.out.println("Hints will be provided after wrong guesses");
    }
}

