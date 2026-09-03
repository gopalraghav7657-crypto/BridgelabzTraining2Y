import java.util.Scanner;

class Program03_ToCharArray {
    public static char[] getCharacters(String text) {
        char[] characters = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            characters[i] = text.charAt(i);
        }
        return characters;
    }

    public static boolean compareArrays(char[] first, char[] second) {
        if (first.length != second.length) return false;
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        char[] userDefinedCharacters = getCharacters(text);
        char[] builtInCharacters = text.toCharArray();

        System.out.println("User-defined characters: " + new String(userDefinedCharacters));
        System.out.println("Built-in characters: " + new String(builtInCharacters));
        System.out.println("Results are same: " + compareArrays(userDefinedCharacters, builtInCharacters));
    }
}