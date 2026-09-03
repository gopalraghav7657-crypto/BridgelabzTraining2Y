import java.util.Scanner;

public class StoreNumbersAndSum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        // Accept up to 10 positive numbers.
        while (true) {
            if (index == numbers.length) {
                break;
            }

            System.out.print("Enter a positive number (0 or negative to stop): ");
            double number = input.nextDouble();

            if (number <= 0) {
                break;
            }

            numbers[index] = number;
            index++;
        }

        // Display stored numbers and calculate total.
        System.out.println("Numbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.println("Sum = " + total);
        input.close();
    }
}
