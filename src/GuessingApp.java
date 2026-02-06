package src;

import java.util.Scanner;
public class GuessingApp {
    public static void main(String[] args) {

        System.out.println("Welcome to Guessing App");
        GameConfig config = new GameConfig();
        config.show();

        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        while (attempts < config.getMAX_ATTEMPTS()) {

            System.out.print("enter your guess");

            int guess = sc.nextInt();
            attempts++;

            String result = GuessValidator.Validator(guess, config.getTarget_number());
            System.out.println(result);

            if ("CORRECT".equals(result)) {
                break;
            }
            if(guess % 2 == 0){
                System.out.println("Hint Number is Even");
            }else if(guess % 2 != 0){
                System.out.println("Hint Number is Odd");
            }else{
                System.out.println("No more hints available");
            }
    }}}