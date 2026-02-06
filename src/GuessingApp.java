package src;

import java.util.Scanner;

public class GuessingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guessing App!");


        System.out.print("Enter Player Name: ");
        String player = scanner.nextLine();

        GameConfig config = new GameConfig();
        config.show();

        int attempts = 0;
        int hintsUsed = 0;
        boolean win = false;

        while (attempts < config.getMAX_ATTEMPTS()) {
            System.out.print("Enter your guess: ");
            try {
                int guess = validationService.validateInput(scanner.nextLine());
                attempts++;

                String result = GuessService.validateGuess(guess, config.getTargetNumber());
                System.out.println(result);

                if (!"CORRECT".equals(result) && hintsUsed < config.getMAX_HINTS()) {
                    hintsUsed++;
                    System.out.println(HintService.generateHint(config.getTargetNumber(), hintsUsed));
                }

                if ("CORRECT".equals(result)) {
                    win = true;
                    break;
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }

        StorageService.saveResult(player, attempts, win);


        StorageService.showResults();

        scanner.close();
    }
}
