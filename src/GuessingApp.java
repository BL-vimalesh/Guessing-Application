package src;

import java.util.Random;
import java.util.Scanner;

/**
 * Use Case 2: User Guess Submission
 *
 * This class is responsible for comparing
 * the user's guess with the target number.
 *
 * It does NOT handle input or output.
 */
class GuessValidator {

    /**
     * Compares guess with target and
     * returns the comparison result.
     *
     * @param guess  User entered number
     * @param target Target number
     * @return "CORRECT", "LOW", or "HIGH"
     */
    public static String validateGuess(int guess, int target) {

        if (guess == target) {
            return "CORRECT";
        } else if (guess < target) {
            return "LOW";
        }

        return "HIGH";
    }
}

/**
 * Game Initialization class
 * Responsible for:
 * - Setting game boundaries
 * - Generating target number
 * - Providing configuration values
 */
class GameConfig {

    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 7;

    private int targetNumber;

    // Constructor generates random number
    public GameConfig() {
        Random random = new Random();
        targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
    }

    // Getter for target number
    public int getTargetNumber() {
        return targetNumber;
    }

    // Getter for max attempts
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    // Display rules
    public void showRules() {
        System.out.println("Guess a number between " + MIN + " and " + MAX);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts.\n");
    }
}

/**
 * MAIN CLASS
 *
 * Coordinates the game flow:
 * 1. Initialize game
 * 2. Accept user guesses
 * 3. Validate guesses
 * 4. Stop when game ends
 *
 * @author Developer
 * @version 2.0
 */
public class GuessingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App");

        // Initialize configuration
        GameConfig config = new GameConfig();
        config.showRules();

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        /**
         * Game loop runs until the player
         * exhausts the maximum attempts.
         */
        while (attempts < config.getMaxAttempts()) {

            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            // Validate guess
            String result = GuessValidator.validateGuess(
                    guess,
                    config.getTargetNumber()
            );

            System.out.println(result);

            /**
             * Stop the loop immediately
             * if the correct number is guessed.
             */
            if ("CORRECT".equals(result)) {
                break;
            }
        }
    }
}