import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class gameLost {
    int scorePoints = 500;

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


    public static void main(String[] args) {
        gameLost game = new gameLost();
        String filePath = "logininfo.txt";
        String lastLine = getLastLine(filePath);
        String finalScore = game.score();
        JOptionPane.showMessageDialog(null, "BANKRUPT!!!\n" +
                "You have lost the game. \n" +
                "Your final score is: " + finalScore + "!\n" +
                "Score saved under: " + lastLine);
    }
}
