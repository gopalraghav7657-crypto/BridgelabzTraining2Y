import java.util.Scanner;

class Program04_CharacterFrequency {
    public static String[][] findFrequency(String text) {
        int[] frequency = new int[256];
        boolean[] added = new boolean[256];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!added[ch]) {
                count++;
                added[ch] = true;
            }
        }

        String[][] result = new String[count][2];
        boolean[] stored = new boolean[256];
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!stored[ch]) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);
                stored[ch] = true;
                index++;
            }
        }

        return result;
    }

    public static void display(String[][] result) {
        System.out.printf("%-15s %-10s%n", "Character", "Frequency");

        for (String[] row : result) {
            System.out.printf("%-15s %-10s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        display(findFrequency(text));
    }
}