import java.util.Scanner;

class Program08_StudentVoting {
    public static int[] getAges(int count, Scanner sc) {
        int[] ages = new int[count];
        for (int i = 0; i < count; i++) {
            ages[i] = sc.nextInt();
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            result[i][1] = String.valueOf(ages[i] >= 18);
        }

        return result;
    }

    public static void display(String[][] result) {
        System.out.printf("%-10s %-15s%n", "Age", "Can Vote");
        for (String[] row : result) {
            System.out.printf("%-10s %-15s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = getAges(10, sc);
        String[][] result = checkVotingEligibility(ages);
        display(result);
    }
}