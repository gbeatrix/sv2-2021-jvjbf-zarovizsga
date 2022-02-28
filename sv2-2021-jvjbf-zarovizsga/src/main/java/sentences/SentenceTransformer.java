package sentences;

public class SentenceTransformer {
    public String shortenSentence(String sentence) {
        validate(sentence);
        String[] words = sentence.split(" ");
        if (words.length >= 5) {
            return words[0] + " ... " + words[words.length - 1];
        } else {
            return sentence;
        }
    }

    private void validate(String sentence) {
        if (!Character.isUpperCase(sentence.charAt(0))) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
        if (!".!?".contains("" + sentence.charAt(sentence.length() - 1))) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
    }
}
