import java.util.Scanner;

class Program06_IllegalArgumentException {
    public static void generateException(String text) {
        if (text.length() >= 2) {
            System.out.println(text.substring(2, 1));
        } else {
            System.out.println(text.substring(1, 0));
        }
    }

    public static void handleException(String text) {
        try {
            if (text.length() >= 2) {
                System.out.println(text.substring(2, 1));
            } else {
                System.out.println(text.substring(1, 0));
            }
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        handleException(text);
    }
}