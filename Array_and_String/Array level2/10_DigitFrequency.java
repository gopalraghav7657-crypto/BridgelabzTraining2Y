import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = input.nextLong();

        if (number < 0) {
            System.out.println("Invalid number.");
            input.close();
            return;
        }

        long temp = number;
        int count = number == 0 ? 1 : 0;

        while (temp > 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        temp = number;

        for (int i = 0; i < count; i++) {
            digits[i] = (int)(temp % 10);
            temp /= 10;
        }

        int[] frequency = new int[10];

        for (int digit : digits) {
            frequency[digit]++;
        }

        for (int i = 0; i < frequency.length; i++) {
            System.out.println("Frequency of " + i + " = " + frequency[i]);
        }

        input.close();
    }
}
