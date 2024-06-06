import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class stats {
    public static void main(String[] args) {
        List<String> userNames = readUserNamesFromFile("logininfo.txt");
        displayUserNamesInMessageBox(userNames);
    }

    private static List<String> readUserNamesFromFile(String fileName) {
        List<String> userNames = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userNames.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userNames;
    }

    private static void displayUserNamesInMessageBox(List<String> userNames) {
        StringBuilder sb = new StringBuilder();
        sb.append("User Names:\n");
        for (String userName : userNames) {
            sb.append("- ").append(userName).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "User Names", JOptionPane.INFORMATION_MESSAGE);
    }
}