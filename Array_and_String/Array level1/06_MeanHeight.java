import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] heights = new double[11];
        double sum = 0.0;

        // Take height input for 11 players.
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = input.nextDouble();

            if (heights[i] <= 0) {
                System.out.println("Invalid height.");
                input.close();
                return;
            }

            sum += heights[i];
        }

        double mean = sum / heights.length;
        System.out.println("Mean height of the football team = " + mean);

        input.close();
    }
}
