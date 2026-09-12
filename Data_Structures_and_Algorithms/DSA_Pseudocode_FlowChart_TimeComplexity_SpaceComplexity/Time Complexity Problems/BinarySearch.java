import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {0, 2, 3, 4, 8, 61};

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int low = 0;
        int high = arr.length - 1;

        int index = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            System.out.println(
                "Searching from index " + low +
                " to " + high +
                ", mid = " + mid
            );

            if (arr[mid] == target) {
                index = mid;
                break;
            }

            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}

