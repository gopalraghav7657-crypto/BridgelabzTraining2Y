import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ChallengeIO {
    public static void compareBuilders() {
        int n = 1000000;

        StringBuilder sb = new StringBuilder();
        long startSb = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sb.append("hello");
        }
        long endSb = System.nanoTime();

        StringBuffer sbuf = new StringBuffer();
        long startSbuf = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sbuf.append("hello");
        }
        long endSbuf = System.nanoTime();

        System.out.println("StringBuilder time (ns): " + (endSb - startSb));
        System.out.println("StringBuffer time (ns): " + (endSbuf - startSbuf));
    }

    public static void countWordsFileReader(String path) {
        long start = System.nanoTime();
        long wordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    wordCount += line.trim().split("\\s+").length;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("FileReader word count: " + wordCount + " time (ns): " + (end - start));
    }

    public static void countWordsInputStreamReader(String path) {
        long start = System.nanoTime();
        long wordCount = 0;
        try (FileInputStream fis = new FileInputStream(path);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    wordCount += line.trim().split("\\s+").length;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("InputStreamReader word count: " + wordCount + " time (ns): " + (end - start));
    }

    public static void main(String[] args) {
        compareBuilders();
        countWordsFileReader("largefile.txt");
        countWordsInputStreamReader("largefile.txt");
    }
}
