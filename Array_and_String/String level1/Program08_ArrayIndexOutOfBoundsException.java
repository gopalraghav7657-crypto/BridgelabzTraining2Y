import java.util.Scanner;

class Program08_ArrayIndexOutOfBoundsException {
    public static void generateException(String[] names) {
        System.out.println(names[names.length]);
    }

    public static void handleException(String[] names) {
        try {
            System.out.println(names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] names = new String[count];

        for (int i = 0; i < count; i++) {
            names[i] = sc.next();
        }

        handleException(names);
    }
}