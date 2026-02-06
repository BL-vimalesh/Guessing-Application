package src;
import java.util.Random;
public class GameConfig {
    private final int MIN = 1;
    private final int MAX = 100;
    private final int MAX_ATTEMPTS = 7;
    private final int MAX_HINTS = 3;

    int target_number;

    public GameConfig(){
        Random random = new Random();
        this.target_number = random.nextInt(MAX-MIN+1) + MIN;
    }

    public int getTarget_number(){
        return target_number;
    }
    public int getMAX_ATTEMPTS(){
        return MAX_ATTEMPTS;
    }
    public int getMAX_HINTS(){
        return MAX_HINTS;
    }

    public void show(){
        System.out.println("Guess the Number between "+ MIN +" and "+ MAX);
        System.out.println("you have "+ MAX_ATTEMPTS +" Attempts");
        System.out.println("Hints will be provided After wrong Guess");
    }
}
