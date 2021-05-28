package us.supercheng.algorithm.problems.leetcode.sortingthesentence;

public class Solution {

    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] words = new String[arr.length];

        for (String a : arr)
            words[a.charAt(a.length() - 1) - '1'] = a.substring(0, a.length() - 1);

        return String.join(" ", words);
    }

}
