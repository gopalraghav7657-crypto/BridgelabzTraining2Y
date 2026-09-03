import java.util.Scanner;

class Program06_VowelsConsonantsType {
    public static String checkCharacter(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32);

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            }
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] findCharacterTypes(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkCharacter(text.charAt(i));
        }
        return result;
    }

    public static void display(String[][] result) {
        System.out.printf("%-10s %-15s%n", "Character", "Type");
        for (String[] row : result) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        display(findCharacterTypes(text));
    }
}