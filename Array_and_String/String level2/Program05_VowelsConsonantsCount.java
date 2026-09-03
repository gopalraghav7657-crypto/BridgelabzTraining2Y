import java.util.Scanner;

class Program05_VowelsConsonantsCount {
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

    public static int[] countVowelsConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            String type = checkCharacter(text.charAt(i));
            if (type.equals("Vowel")) vowels++;
            else if (type.equals("Consonant")) consonants++;
        }

        return new int[] {vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int[] counts = countVowelsConsonants(text);
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
    }
}