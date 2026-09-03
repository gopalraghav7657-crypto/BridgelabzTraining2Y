import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ISR2_ReadUserInputWriteFile {
    public static void main(String[] args) {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter("output.txt")) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                fw.write(line);
                fw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
