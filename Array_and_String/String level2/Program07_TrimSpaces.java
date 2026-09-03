import java.util.Scanner;

class Program07_TrimSpaces {
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') start++;
        while (end >= start && text.charAt(end) == ' ') end--;

        return new int[] {start, end + 1};
    }

    public static String createSubstring(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    public static boolean compareStrings(String first, String second) {
        if (first.length() != second.length()) return false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int[] indexes = findTrimIndexes(text);
        String userDefinedTrim = createSubstring(text, indexes[0], indexes[1]);
        String builtInTrim = text.trim();

        System.out.println("Using charAt(): " + userDefinedTrim);
        System.out.println("Using trim(): " + builtInTrim);
        System.out.println("Results are same: " + compareStrings(userDefinedTrim, builtInTrim));
    }
}