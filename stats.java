import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//zohair
public class stats {

    public static void main(String[] args) {
        //read file and display in popup message
        List<String> userNames = readUserNamesFromFile("logininfo.txt");
        displayUserNamesInMessageBox(userNames);
    }

    // Method to read user names from a file
    private static List<String> readUserNamesFromFile(String fileName) {
        // Create a list to store the user names
        List<String> userNames = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                // Add the trimmed line (user name) to the list
                userNames.add(line.trim());
            }
        } catch (IOException e) {
            // Print the stack trace for any IOException
            e.printStackTrace();
        }
        // Return the list of user names
        return userNames;
    }

    // Method to display user names in a message box
    private static void displayUserNamesInMessageBox(List<String> userNames) {
        // Create a StringBuilder to build the message
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < userNames.size(); i++) {
            // Append each user name to the message
            sb.append((i + 1) + ". ").append(userNames.get(i)).append("\n");
        }
        // Show the message box with the user names
        JOptionPane.showMessageDialog(null, sb.toString(), "Stats", JOptionPane.INFORMATION_MESSAGE);
    }
}
