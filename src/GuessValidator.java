package src;


public class GuessValidator {
    public static String Validator(int guess, int target){
        if(guess == target){
            return "CORRECT";
        }else if(guess < target){
            return "LOW";
        }else{
            return "HIGH";
        }
    }
}
