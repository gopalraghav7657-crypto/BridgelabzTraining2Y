import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FR1_ReadFileLineByLine {
    public static void readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFile("input.txt");
    }
}
