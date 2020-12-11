package us.supercheng.algorithm.problems.leetcode.generateastringwithcharactersthathaveoddcounts;

public class Solution {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();

        if (n % 2 == 0) {
            if (n == 2)
                return "ab";

            for (int i=1; i<n; i++)
                sb.append("a");

            sb.append("b");
        } else
            for (int i=0; i<n;i++)
                sb.append("a");

        return sb.toString();
    }
}