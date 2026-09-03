import java.util.Scanner;

class Program08_Anagram {
    public static boolean checkAnagram(String first, String second) {
        if (first.length() != second.length()) return false;

        int[] firstFrequency = new int[256];
        int[] secondFrequency = new int[256];

        for (int i = 0; i < first.length(); i++) {
            firstFrequency[first.charAt(i)]++;
            secondFrequency[second.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (firstFrequency[i] != secondFrequency[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();

        System.out.println("Anagram: " + checkAnagram(first, second));
    }
}