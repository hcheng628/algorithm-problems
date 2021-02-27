package us.supercheng.algorithm.problems.leetcode.mergestringsalternately;

public class Program {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int endIdx = Math.min(len1, len2);

        for (int i=0; i<endIdx; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        for (int i=endIdx; i<len1; i++)
            sb.append(word1.charAt(i));

        for (int i=endIdx; i<len2; i++)
            sb.append(word2.charAt(i));

        return sb.toString();
    }

}
