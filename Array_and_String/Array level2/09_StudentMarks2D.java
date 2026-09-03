import java.util.Scanner;

public class StudentMarks2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Invalid number of students.");
            input.close();
            return;
        }

        double[][] marks = new double[number][3];
        double[] percentage = new double[number];
        String[] grade = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1));

            System.out.print("Physics: ");
            marks[i][0] = input.nextDouble();
            System.out.print("Chemistry: ");
            marks[i][1] = input.nextDouble();
            System.out.print("Maths: ");
            marks[i][2] = input.nextDouble();

            if (marks[i][0] < 0 || marks[i][1] < 0 || marks[i][2] < 0 ||
                marks[i][0] > 100 || marks[i][1] > 100 || marks[i][2] > 100) {
                System.out.println("Invalid marks.");
                i--;
                continue;
            }

            double total = 0;
            for (int j = 0; j < marks[i].length; j++) {
                total += marks[i][j];
            }

            percentage[i] = total / 3.0;
            grade[i] = getGrade(percentage[i]);
        }

        for (int i = 0; i < number; i++) {
            System.out.printf("Student %d: Physics = %.2f, Chemistry = %.2f, Maths = %.2f, Percentage = %.2f, Grade = %s%n",
                    i + 1, marks[i][0], marks[i][1], marks[i][2], percentage[i], grade[i]);
        }

        input.close();
    }

    static String getGrade(double percentage) {
        if (percentage >= 90) return "A";
        if (percentage >= 80) return "B";
        if (percentage >= 70) return "C";
        if (percentage >= 60) return "D";
        if (percentage >= 50) return "E";
        return "F";
    }
}
