public class SBuf1_ConcatenateStrings {
    public static String concatenate(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"Hello", ", ", "World", "!"};
        System.out.println(concatenate(strings));
    }
}
