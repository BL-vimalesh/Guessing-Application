package src;

import java.util.Scanner;

public class GameController {
    public static boolean restartGame(Scanner sc){
        System.out.print("do you want to play again? (Yes/no)");
        return Scanner.nextLine().equalsIgnoreCase("yes");
    }
}

