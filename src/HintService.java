package src;

import java.util.Random;

public class HintService {
    public static String generateHint(int target, int hintCount){
        Random random = new Random();
        int hintcount = random.nextInt();
        if(hintcount == 1){
        return (target % 2 == 0)
                ? "Hint: Number is EVEN"
                : "Hint: Number is ODD";
    }else if(hintCount == 2){
        return (target > 50)
                ? "Hint: Number is greater than 50"
                : "Hint: Number is 50 or less";
    }
    return "no more hints avilable";

}}
