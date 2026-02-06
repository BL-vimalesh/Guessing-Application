package src;

import java.util.Random;
import java.util.Scanner;

/**
 * GameConfig
 *
 * Handles game initialization settings such as:
 * - Minimum and maximum number range
 * - Maximum attempts allowed
 * - Maximum hints allowed
 * - Random target number generation
 */
class GameConfig {

    // Minimum value of guessing range
    private final int MIN = 1;

    // Maximum value of guessing range
    private final int MAX = 100;

    // Maximum number of attempts allowed
    private final int MAX_ATTEMPTS = 7;

    // Maximum number of hints allowed
    private final int MAX_HINTS = 3;

    // Stores randomly generated target number
    private int targetNumber;

    /**
     * Constructor
     * Automatically generates the random target number
     * when GameConfig object is created.
     */
    public GameConfig() {
        Random random = new Random();
        targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
    }

    /**
     * Returns the randomly generated target number
     */
    public int getTargetNumber() {
        return targetNumber;
    }

    /**
     * Returns maximum number of attempts allowed
     */
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    /**
     * Returns maximum number of hints allowed
     */
    public int getMaxHints() {
        return MAX_HINTS;
    }

    /**
     * Displays game rules to the player
     */
    public void showRules() {
        System.out.println("🎯 Guess a number between " + MIN + " and " + MAX);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts.");
        System.out.println("Hints will be provided after wrong guesses.\n");
    }
}

/**
 * GuessValidator
 *
 * Responsible for comparing user's guess
 * with the target number.
 * Does not handle input/output.
 */
class GuessValidator {

    /**
     * Compares guess and target value
     *
     * @param guess  number entered by user
     * @param target randomly generated number
     * @return comparison result ("CORRECT", "LOW", "HIGH")
     */
    public static String validateGuess(int guess, int target) {

        if (guess == target)
            return "CORRECT";
        else if (guess < target)
            return "LOW";
        else
            return "HIGH";
    }
}

/**
 * HintService
 *
 * Generates hints based on the number
 * of hints already used.
 */
class HintService {

    /**
     * Generates hint using target number and hint count
     *
     * @param target    actual target number
     * @param hintCount number of hints already used
     * @return generated hint message
     */
    public static String generateHint(int target, int hintCount) {

        // First hint: EVEN or ODD
        if (hintCount == 1) {
            return (target % 2 == 0)
                    ? "Hint: Number is EVEN"
                    : "Hint: Number is ODD";
        }

        // Second hint: greater than 50 or not
        else if (hintCount == 2) {
            return (target > 50)
                    ? "Hint: Number is greater than 50"
                    : "Hint: Number is 50 or less";
        }

        // No more hints available
        return "No more hints available";
    }
}


/**
 * GuessingApp
 *
 * Main controller class that:
 * - Initializes the game
 * - Accepts user guesses
 * - Validates guesses
 * - Generates hints
 * - Controls game flow
 */
public class GuessingApp {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("Welcome to the Guessing App");

        // Create configuration object
        GameConfig config = new GameConfig();

        // Display game rules
        config.showRules();

        // Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Tracks number of attempts used
        int attempts = 0;

        // Tracks number of hints already used
        int hintsUsed = 0;

        /**
         * Game loop runs until
         * maximum attempts are exhausted
         */
        while (attempts < config.getMaxAttempts()) {

            System.out.print("Enter your guess: ");

            // Read user guess
            int guess = scanner.nextInt();

            // Increment attempt counter
            attempts++;

            // Validate guess using GuessValidator
            String result = GuessValidator.validateGuess(
                    guess,
                    config.getTargetNumber()
            );

            // If guess is wrong and hints still available
            if (!"CORRECT".equals(result) &&
                    hintsUsed < config.getMaxHints()) {

                hintsUsed++;

                // Generate and display hint
                System.out.println(
                        HintService.generateHint(
                                config.getTargetNumber(),
                                hintsUsed
                        )
                );
            }

            // Display validation result
            System.out.println(result);

            // Stop loop if correct
            if ("CORRECT".equals(result)) {
                System.out.println("🎉 You guessed correctly!");
                break;
            }
        }

        // If attempts finished and not guessed
        if (attempts == config.getMaxAttempts()) {
            System.out.println("Game Over! Target was: "
                    + config.getTargetNumber());
        }
    }
}