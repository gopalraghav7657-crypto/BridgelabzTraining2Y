import java.util.Scanner;

public class TableFrom6To9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] multiplicationResult = new int[4];

        // Store results for multipliers 6 to 9.
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }

        // Display results.
        for (int i = 0; i < multiplicationResult.length; i++) {
            int multiplier = i + 6;
            System.out.println(number + " * " + multiplier + " = " + multiplicationResult[i]);
        }

        input.close();
    }
}
