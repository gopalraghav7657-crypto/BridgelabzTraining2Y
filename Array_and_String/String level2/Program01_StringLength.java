import java.util.Scanner;

class Program01_StringLength {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int userDefinedLength = findLength(text);
        int builtInLength = text.length();

        System.out.println("Using charAt(): " + userDefinedLength);
        System.out.println("Using length(): " + builtInLength);
        System.out.println("Results are same: " + (userDefinedLength == builtInLength));
    }
}