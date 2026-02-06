package src;

import java.util.Scanner;
public class GamePlay {
    private GameConfig config;
    private int attempts;
    private int hintsUsed;

    public GamePlay(GameConfig config) {
        this.config = config;
        this.attempts = 0;
        this.hintsUsed = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        config.show();

        while (attempts < config.getMAX_ATTEMPTS()) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == config.getTarget_number()) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return;
            } else {
                System.out.println("Wrong guess!");
                if (hintsUsed < config.getMAX_HINTS()) {
                    giveHint(guess);
                    hintsUsed++;
                }
                System.out.println("Attempts left: " + (config.getMAX_ATTEMPTS() - attempts));
            }
        }

        System.out.println("Game Over! The correct number was: " + config.getTarget_number());
    }

    public void giveHint(int guess) {
        if (guess < config.getTarget_number()) {
            System.out.println("Hint: Try a higher number!");
        } else {
            System.out.println("Hint: Try a lower number!");
        }
    }
}

