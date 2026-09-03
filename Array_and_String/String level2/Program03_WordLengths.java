import java.util.Scanner;

class Program03_WordLengths {
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

    public static String createSubstring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    public static String[] splitWords(String text) {
        int length = findLength(text);
        if (length == 0) return new String[0];

        int count = 0;
        boolean insideWord = false;
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch != ' ' && !insideWord) {
                count++;
                insideWord = true;
            } else if (ch == ' ') {
                insideWord = false;
            }
        }

        String[] words = new String[count];
        int index = 0;
        int start = -1;

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch != ' ' && start == -1) start = i;
            if ((ch == ' ' || i == length - 1) && start != -1) {
                int end = ch == ' ' ? i : i + 1;
                words[index++] = createSubstring(text, start, end);
                start = -1;
            }
        }
        return words;
    }

    public static String[][] wordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static void display(String[][] result) {
        System.out.printf("%-20s %-10s%n", "Word", "Length");
        for (String[] row : result) {
            System.out.printf("%-20s %-10d%n", row[0], Integer.parseInt(row[1]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = splitWords(text);
        String[][] result = wordLengths(words);
        display(result);
    }
}