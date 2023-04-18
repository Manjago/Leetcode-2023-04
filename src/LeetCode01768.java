public class LeetCode01768 {
    public String mergeAlternately(String word1, String word2) {
        final StringBuilder answer = new StringBuilder();
        final int n1 = word1.length();
        final int n2 = word2.length();
        int i1= 0;
        int i2 = 0;
        do {
            if (i1 < n1) {
                answer.append(word1.charAt(i1++));
            }
            if (i2 < n2) {
                answer.append(word2.charAt(i2++));
            }

        }while(i1 < n1 || i2 < n2);

        return answer.toString();
    }
}
