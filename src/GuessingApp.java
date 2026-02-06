package src;

import java.util.Scanner;

public class GuessingApp {
    public static void main(String[] args) {
        GameConfig config = new GameConfig();
        config.show();

        Scanner sc = new Scanner(System.in);
        int attempts = 0;
        int hintUsed = 0;

        while (attempts < config.getMAX_ATTEMPTS()) {
            System.out.print("Enter your guess: ");
            try {
                int guess = validationService.validateInput(sc.nextLine());
                attempts++;

                String result = GuessService.validateGuess(guess, config.getTargetNumber());

                if (!"CORRECT".equals(result) && hintUsed < config.getMAX_HINTS()) {
                    hintUsed++;
                    System.out.println(HintService.generateHint(config.getTargetNumber(), hintUsed));
                }

                System.out.println(result);

                if ("CORRECT".equals(result)) {
                    break;
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
