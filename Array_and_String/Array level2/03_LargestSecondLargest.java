import java.util.Scanner;

public class LargestSecondLargest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Invalid number.");
            input.close();
            return;
        }

        if (number == 0) {
            System.out.println("Largest = 0");
            System.out.println("Second Largest = 0");
            input.close();
            return;
        }

        int[] digits = new int[10];
        int index = 0;
        int temp = number;

        while (temp != 0) {
            if (index == digits.length) break;
            digits[index++] = temp % 10;
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
