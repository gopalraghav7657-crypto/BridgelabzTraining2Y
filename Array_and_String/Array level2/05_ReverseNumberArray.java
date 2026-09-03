import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Invalid number.");
            input.close();
            return;
        }

        int count = number == 0 ? 1 : 0;
        int temp = number;

        while (temp > 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        temp = number;

        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        int[] reversed = new int[count];

        for (int i = 0; i < count; i++) {
            reversed[i] = digits[count - 1 - i];
        }

        System.out.print("Reversed array: ");
        for (int value : reversed) {
            System.out.print(value + " ");
        }

        System.out.print("\nReversed number: ");
        for (int i = 0; i < reversed.length; i++) {
            System.out.print(reversed[i]);
        }

        input.close();
    }
}
