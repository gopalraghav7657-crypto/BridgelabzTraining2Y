public class LS2_SearchWordInSentences {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            String[] words = sentence.split("\\s+");
            for (String w : words) {
                if (w.equals(word)) {
                    return sentence;
                }
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox",
            "jumps over the lazy dog",
            "Java is a great language"
        };
        System.out.println(findSentenceWithWord(sentences, "great"));
    }
}
