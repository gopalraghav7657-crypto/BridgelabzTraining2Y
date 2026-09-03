import java.util.Scanner;

public class BMIUsing2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Invalid number of persons.");
            input.close();
            return;
        }

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.print("Enter height in meters: ");
            double height = input.nextDouble();
            System.out.print("Enter weight in kg: ");
            double weight = input.nextDouble();

            if (height <= 0 || weight <= 0) {
                System.out.println("Invalid input.");
                i--;
                continue;
            }

            personData[i][0] = height;
            personData[i][1] = weight;
            personData[i][2] = weight / (height * height);

            if (personData[i][2] < 18.5) weightStatus[i] = "Underweight";
            else if (personData[i][2] < 25) weightStatus[i] = "Normal";
            else if (personData[i][2] < 30) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d: Height = %.2f m, Weight = %.2f kg, BMI = %.2f, Status = %s%n",
                    i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        input.close();
    }
}
