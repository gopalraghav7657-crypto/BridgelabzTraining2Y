import java.util.HashSet;
import java.util.Set;

public class SB2_RemoveDuplicates {
    public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        System.out.println(removeDuplicates(input));
    }
}
