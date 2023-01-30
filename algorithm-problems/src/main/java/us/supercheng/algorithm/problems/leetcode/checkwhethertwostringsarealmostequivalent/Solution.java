package us.supercheng.algorithm.problems.leetcode.checkwhethertwostringsarealmostequivalent;

public class Solution {

    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] count = new int[26];

        for (char c : word1.toCharArray())
            count[c - 'a']++;

        for (char c : word2.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < -3)
                return false;
        }

        for (int c : count)
            if (c > 3)
                return false;

        return true;
    }

}
