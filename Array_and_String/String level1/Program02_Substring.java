import java.util.Scanner;

class Program02_Substring {
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
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        String userDefinedSubstring = createSubstring(text, start, end);
        String builtInSubstring = text.substring(start, end);

        System.out.println("Using charAt(): " + userDefinedSubstring);
        System.out.println("Using substring(): " + builtInSubstring);
        System.out.println("Results are same: " + compareStrings(userDefinedSubstring, builtInSubstring));
    }
}