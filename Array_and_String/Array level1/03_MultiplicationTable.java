import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int[] multiplicationTable = new int[10];

        // Store multiplication results from 1 to 10.
        for (int i = 1; i <= multiplicationTable.length; i++) {
            multiplicationTable[i - 1] = number * i;
        }

        // Display the table.
        for (int i = 0; i < multiplicationTable.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationTable[i]);
        }

        input.close();
    }
}
