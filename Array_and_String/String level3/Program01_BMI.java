import java.util.Scanner;

class Program01_BMI {
    public static String[] calculateBMI(double weight, double heightCm) {
        double heightMeter = heightCm / 100.0;
        double bmi = weight / (heightMeter * heightMeter);
        String status;

        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 25) status = "Normal";
        else if (bmi < 30) status = "Overweight";
        else status = "Obese";

        return new String[] {
            String.valueOf(heightCm),
            String.valueOf(weight),
            String.format("%.2f", bmi),
            status
        };
    }

    public static String[][] processBMI(double[][] people) {
        String[][] result = new String[people.length][4];

        for (int i = 0; i < people.length; i++) {
            String[] bmiData = calculateBMI(people[i][0], people[i][1]);
            result[i] = bmiData;
        }

        return result;
    }

    public static void display(String[][] result) {
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height", "Weight", "BMI", "Status");

        for (String[] row : result) {
            System.out.printf("%-10s %-10s %-10s %-15s%n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] people = new double[10][2];

        for (int i = 0; i < 10; i++) {
            people[i][0] = sc.nextDouble();
            people[i][1] = sc.nextDouble();
        }

        display(processBMI(people));
    }
}