package src;

import java.util.Scanner;

public class GuessingApp {
    public static void main(String[] args) throws InvalidInputException{
        Scanner sc = new Scanner(System.in);
        boolean restart;

        System.out.println("Welcome to the Guessing App");

        do{
            System.out.println("Enter player name: ");
            String player  = Scanner.nextLine();

            GameConfig config = new GameConfig();
            config.show();

            int attempts = 0;
            int hintused = 0;

            boolean win = false;
            while(attempts < config.getMAX_ATTEMPTS()){
                StorageService.saveResult(player, attempts, win);

                restart = GameController.restartGame(Scanner);
            }while(restart){

            }

        }
    }}
