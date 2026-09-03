import java.util.Scanner;

class Program10_PCMScorecard {
    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];

        for (int i = 0; i < students; i++) {
            scores[i][0] = (int) (Math.random() * 91) + 10;
            scores[i][1] = (int) (Math.random() * 91) + 10;
            scores[i][2] = (int) (Math.random() * 91) + 10;
        }

        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] result = new double[scores.length][4];

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = total / 300.0 * 100.0;

            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return result;
    }

    public static String[][] calculateGrades(double[][] results) {
        String[][] grades = new String[results.length][1];

        for (int i = 0; i < results.length; i++) {
            double percentage = results[i][2];
            String grade;

            if (percentage >= 90) grade = "A+";
            else if (percentage >= 80) grade = "A";
            else if (percentage >= 70) grade = "B";
            else if (percentage >= 60) grade = "C";
            else if (percentage >= 50) grade = "D";
            else if (percentage >= 40) grade = "E";
            else grade = "F";

            grades[i][0] = grade;
        }

        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] results, String[][] grades) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-12s %-8s%n",
                "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10d %-10d %-10d %-10d %-10.0f %-10.2f %-12.2f %-8s%n",
                    i + 1,
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    results[i][0],
                    results[i][1],
                    results[i][2],
                    grades[i][0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int students = sc.nextInt();

        int[][] scores = generateScores(students);
        double[][] results = calculateResults(scores);
        String[][] grades = calculateGrades(results);

        displayScorecard(scores, results, grades);
    }
}