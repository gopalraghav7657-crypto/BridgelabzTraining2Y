import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] salary = new double[10];
        double[] service = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        int i = 0;
        while (i < salary.length) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            double s = input.nextDouble();
            System.out.print("Enter years of service: ");
            double y = input.nextDouble();

            if (s <= 0 || y < 0) {
                System.out.println("Invalid input. Enter valid values.");
                continue;
            }

            salary[i] = s;
            service[i] = y;
            i++;
        }

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (i = 0; i < salary.length; i++) {
            bonus[i] = service[i] > 5 ? salary[i] * 0.05 : salary[i] * 0.02;
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("Total Bonus = " + totalBonus);
        System.out.println("Total Old Salary = " + totalOldSalary);
        System.out.println("Total New Salary = " + totalNewSalary);

        input.close();
    }
}
