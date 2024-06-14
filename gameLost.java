import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;

public class gameLost {
    int scorePoints = 200;

    public static String getLastLine(String filePath) {
        String lastLine = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lastLine = currentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastLine;
    }

    public String score() {
        return Integer.toString(scorePoints);
    }

    public static void updateLeaderboard(String filePath, String username, int score) {
        List<String> leaderboard = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                leaderboard.add(line);
            }
        } catch (IOException e) {
            // If the file doesn't exist, it will be created later
        }

        // Add the new score
        leaderboard.add(username + " " + score);

        // Sort the leaderboard by score (from highest to lowest)
        Collections.sort(leaderboard, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int score1 = Integer.parseInt(o1.split(" ")[1]);
                int score2 = Integer.parseInt(o2.split(" ")[1]);
                return Integer.compare(score2, score1); // Sort in descending order
            }
        });

        // Write the updated leaderboard back to the file
        try (FileWriter writer = new FileWriter(filePath)) {
            for (String entry : leaderboard) {
                writer.write(entry + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(int score) {
        String filePath = "logininfo.txt";
        String lastLine = getLastLine(filePath);

        // Assuming the last line is the username
        String username = lastLine;

        // Update the leaderboard
        String leaderboardPath = "leaderboard.txt";
        updateLeaderboard(leaderboardPath, username, score);

        JOptionPane.showMessageDialog(null, "BANKRUPT!!!\n" +
                "You have lost the game. \n" +
                "Your final score is: " + score + "!\n" +
                "Score saved under: " + lastLine);
    }
}
