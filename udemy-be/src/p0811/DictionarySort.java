package p0811;

public class DictionarySort {
    public static void main(String[] args) {
        String[] words = {"banana","apple","cherry"};

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].compareTo(words[j]) > 0) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        System.out.println("사전 순 정렬:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
