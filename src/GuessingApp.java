package src;

import java.util.Random;

/**
 * Use Case 1: Game Initialization
 *
 * This class is responsible for:
 * - Setting game boundaries
 * - Generating a random target number
 * - Displaying game rules
 *
 * Demonstrates:
 * - Encapsulation
 * - Constructor initialization
 * - Random number generation
 */
class GameConfig {

    // Game constants
    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 7;
    private final int MAX_HINTS = 3;

    // Randomly generated target number
    private int targetNumber;

    /**
     * Constructor is automatically called when a GameConfig object is created.
     * It initializes the random target number for the game.
     */
    public GameConfig() {
        Random random = new Random();
        this.targetNumber = random.nextInt(MAX - MIN + 1) + MIN;
    }

    // Getter for target number
    public int getTargetNumber() {
        return targetNumber;
    }

    // Getter for maximum attempts
    public int getMaxAttempts() {
        return MAX_ATTEMPTS;
    }

    // Getter for maximum hints
    public int getMaxHints() {
        return MAX_HINTS;
    }

    /**
     * Displays the game rules to the player
     */
    public void showRules() {
        System.out.println("🎯 Guess a number between " + MIN + " and " + MAX);
        System.out.println("You have " + MAX_ATTEMPTS + " attempts.");
        System.out.println("Hints will be provided after wrong guesses.\n");
    }
}
/**
 * GuessingApp – Use Case 1: Game Initialization
 *
 * This class serves as the application entry point.
 * It initializes the game configuration and displays game rules.
 *
 * No user input or gameplay logic is implemented at this stage.
 */
public class GuessingApp {

    public static void main(String[] args) {

        // Welcome message
        System.out.println("Welcome to the Guessing App");

        // Initialize game configuration
        GameConfig gameConfig = new GameConfig();

        // Display game rules
        gameConfig.showRules();

        // (For testing only – normally hidden)
        // System.out.println("DEBUG Target Number: " + gameConfig.getTargetNumber());
    }
}