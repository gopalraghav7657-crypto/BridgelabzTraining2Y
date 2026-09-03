import java.util.Scanner;

public class TwoDToOneDArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();

        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();

        if (rows <= 0 || columns <= 0) {
            System.out.println("Rows and columns must be positive.");
            input.close();
            return;
        }

        int[][] matrix = new int[rows][columns];

        // Take matrix input.
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        int[] array = new int[rows * columns];
        int index = 0;

        // Copy 2D array into 1D array.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                array[index++] = matrix[i][j];
            }
        }

        System.out.print("1D array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }

        input.close();
    }
}
