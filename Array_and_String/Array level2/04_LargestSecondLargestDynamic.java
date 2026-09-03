import java.util.Scanner;

public class LargestSecondLargestDynamic {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = input.nextLong();

        if (number < 0) {
            System.out.println("Invalid number.");
            input.close();
            return;
        }

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        long temp = number;

        if (temp == 0) {
            digits[index++] = 0;
        }

        while (temp != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] newDigits = new int[maxDigit];
                for (int i = 0; i < digits.length; i++) {
                    newDigits[i] = digits[i];
                }
                digits = newDigits;
            }

            digits[index++] = (int)(temp % 10);
            temp /= 10;
        }

        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest = " + largest);
        System.out.println("Second Largest = " + secondLargest);

        input.close();
    }
}
