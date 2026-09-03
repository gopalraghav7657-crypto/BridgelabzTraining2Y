import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FR2_CountWordOccurrence {
    public static int countWord(String path, String targetWord) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.equals(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        int count = countWord("input.txt", "the");
        System.out.println(count);
    }
}
