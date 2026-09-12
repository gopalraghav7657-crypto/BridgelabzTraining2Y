import java.util.Scanner;

public class PrimeFlowchart {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        boolean prime = true;

        if (n <= 1) {
            prime = false;
        } else {

            int i = 2;

            while (i * i <= n) {

                if (n % i == 0) {
                    prime = false;
                    break;
                }

                i++;
            }
        }

        if (prime) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }

        sc.close();
    }
}