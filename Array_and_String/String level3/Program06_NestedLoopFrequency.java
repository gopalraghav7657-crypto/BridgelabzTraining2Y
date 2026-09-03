import java.util.Scanner;

class Program06_NestedLoopFrequency {
    public static String[] findFrequency(String text) {
        char[] characters = text.toCharArray();
        int[] frequency = new int[characters.length];
        String[] result = new String[characters.length];

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '0') continue;

            frequency[i] = 1;

            for (int j = i + 1; j < characters.length; j++) {
                if (characters[i] == characters[j]) {
                    frequency[i]++;
                    characters[j] = '0';
                }
            }

            result[i] = characters[i] + " : " + frequency[i];
        }

        int count = 0;
        for (String value : result) {
            if (value != null) count++;
        }

        String[] finalResult = new String[count];
        int index = 0;

        for (String value : result) {
            if (value != null) {
                finalResult[index++] = value;
            }
        }

        return finalResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] result = findFrequency(text);

        for (String value : result) {
            System.out.println(value);
        }
    }
}