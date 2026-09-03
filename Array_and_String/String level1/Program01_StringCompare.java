import java.util.Scanner;

class Program01_StringCompare {
    public static boolean compareStrings(String first, String second) {
        if (first.length() != second.length()) return false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next();
        String second = sc.next();

        boolean userDefinedResult = compareStrings(first, second);
        boolean builtInResult = first.equals(second);

        System.out.println("Using charAt(): " + userDefinedResult);
        System.out.println("Using equals(): " + builtInResult);
        System.out.println("Results are same: " + (userDefinedResult == builtInResult));
    }
}