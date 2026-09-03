import java.util.Scanner;

class Program10_Lowercase {
    public static String convertToLowercase(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
            }
            result.append(ch);
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

        String userDefinedResult = convertToLowercase(text);
        String builtInResult = text.toLowerCase();

        System.out.println("Using charAt(): " + userDefinedResult);
        System.out.println("Using toLowerCase(): " + builtInResult);
        System.out.println("Results are same: " + compareStrings(userDefinedResult, builtInResult));
    }
}