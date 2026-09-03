import java.util.Scanner;

class Program05_UniqueCharacterFrequency {
    public static char[] findUniqueCharacters(String text) {
        char[] unique = new char[text.length()];
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[count++] = text.charAt(i);
            }
        }

        char[] result = new char[count];
        for (int i = 0; i < count; i++) {
            result[i] = unique[i];
        }

        return result;
    }

    public static String[][] findFrequency(String text) {
        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        char[] unique = findUniqueCharacters(text);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(frequency[unique[i]]);
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