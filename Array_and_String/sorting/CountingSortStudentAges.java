import java.util.Arrays;

public class CountingSortStudentAges {
    public static int[] countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int age : ages) {
            count[age - minAge]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] ages = {15, 12, 18, 10, 14, 17, 12, 16};
        int[] sortedAges = countingSort(ages, 10, 18);
        System.out.println(Arrays.toString(sortedAges));
    }
}
