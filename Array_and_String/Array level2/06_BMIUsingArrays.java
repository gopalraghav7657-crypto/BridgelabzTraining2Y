import java.util.Scanner;

public class BMIUsingArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Invalid number of persons.");
            input.close();
            return;
        }

        double[] height = new double[number];
        double[] weight = new double[number];
        double[] bmi = new double[number];
        String[] status = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.print("Enter height in meters for person " + (i + 1) + ": ");
            height[i] = input.nextDouble();
            System.out.print("Enter weight in kg for person " + (i + 1) + ": ");
            weight[i] = input.nextDouble();

            if (height[i] <= 0 || weight[i] <= 0) {
                System.out.println("Invalid input.");
                i--;
                continue;
            }

            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5) status[i] = "Underweight";
            else if (bmi[i] < 25) status[i] = "Normal";
            else if (bmi[i] < 30) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d: Height = %.2f m, Weight = %.2f kg, BMI = %.2f, Status = %s%n",
                    i + 1, height[i], weight[i], bmi[i], status[i]);
        }

        input.close();
    }
}
