import java.util.Scanner;

class Program02_SplitWords {
    public static int findLength(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                return count;
            }
        }
    }

    public static String[] splitWords(String text) {
        int length = findLength(text);
        if (length == 0) return new String[0];

        int wordCount = 0;
        boolean insideWord = false;

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch != ' ' && !insideWord) {
                wordCount++;
                insideWord = true;
            } else if (ch == ' ') {
                insideWord = false;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        int start = -1;

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch != ' ' && start == -1) {
                start = i;
            }
            if ((ch == ' ' || i == length - 1) && start != -1) {
                int end = ch == ' ' ? i : i + 1;
                words[wordIndex++] = createSubstring(text, start, end);
                start = -1;
            }
        }
        return words;
    }

    public static String createSubstring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    public static boolean compareArrays(String[] first, String[] second) {
        if (first.length != second.length) return false;
        for (int i = 0; i < first.length; i++) {
            if (!first[i].equals(second[i])) return false;
        }
        return true;
    }

    public static void display(String[] words) {
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] userDefinedWords = splitWords(text);
        String[] builtInWords = text.trim().isEmpty() ? new String[0] : text.trim().split("\\s+");

        display(userDefinedWords);
        System.out.println("Results are same: " + compareArrays(userDefinedWords, builtInWords));
    }
}