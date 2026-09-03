import java.util.Scanner;

class Program02_UniqueCharacters {
    public static int findLength(String text) {
        int count = 0;

        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                return count;
            }
        }
    }

    public static char[] findUniqueCharacters(String text) {
        int length = findLength(text);
        char[] unique = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[uniqueCount++] = text.charAt(i);
            }
        }

        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = unique[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        char[] result = findUniqueCharacters(text);

        for (char ch : result) {
            System.out.print(ch + " ");
        }
    }
}