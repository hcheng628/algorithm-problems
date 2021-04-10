package us.supercheng.algorithm.problems.leetcode.truncatesentence;

public class Solution {

    public String truncateSentence(String s, int k) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<k; i++)
            sb.append(i != k - 1 ? arr[i] + " " : arr[i]);

        return sb.toString();
    }
}