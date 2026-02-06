package src;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StorageService {

    private static final String FILE_NAME = "game_results.txt";
    public static void saveResult(String player, int attempts, boolean win) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write("Player: " + player +
                    ", Attempts: " + attempts +
                    ", Result: " + (win ? "WIN" : "LOSE"));
            writer.newLine();
            System.out.println("Game result saved successfully!");
        } catch (IOException e) {
            System.out.println("Unable to save game result.");
        }
    }

    public static List<String> getResults() {
        List<String> results = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                results.add(line);
            }
        } catch (IOException e) {
            System.out.println("No previous results found.");
        }
        return results;
    }

    public static void showResults() {
        List<String> results = getResults();
        System.out.println("\n=== Previous Game Records ===");
        for (String record : results) {
            System.out.println(record);
        }
    }
}

