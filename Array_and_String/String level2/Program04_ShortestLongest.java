import java.util.Scanner;

class Program04_ShortestLongest {
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
        for (int i = start; i < end; i++) result.append(text.charAt(i));
        return result.toString();
    }

    public static String[] splitWords(String text) {
        int length = findLength(text);
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

    public static int[] findShortestLongest(String[][] words) {
        if (words.length == 0) return new int[] {-1, -1};

        int shortest = 0;
        int longest = 0;

        for (int i = 1; i < words.length; i++) {
            int currentLength = Integer.parseInt(words[i][1]);
            int shortestLength = Integer.parseInt(words[shortest][1]);
            int longestLength = Integer.parseInt(words[longest][1]);

            if (currentLength < shortestLength) shortest = i;
            if (currentLength > longestLength) longest = i;
        }

        return new int[] {shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] data = wordLengths(words);
        int[] indexes = findShortestLongest(data);

        if (indexes[0] == -1) {
            System.out.println("No words found");
        } else {
            System.out.println("Shortest: " + data[indexes[0]][0] + " (" + data[indexes[0]][1] + ")");
            System.out.println("Longest: " + data[indexes[1]][0] + " (" + data[indexes[1]][1] + ")");
        }
    }
}