public class SC1LinearSearch {

    public static void main(String[] args) {

        int[] arr = {8, 61, 2, 3, 4, 0};

        int target = 8;

        int index = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }
}