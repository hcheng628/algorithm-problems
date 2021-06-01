package us.supercheng.algorithm.problems.leetcode.longercontiguoussegmentsofonesthanzeros;

public class Solution {

    public boolean checkZeroOnes(String s) {
        int maxZero = 0;
        int maxOne = 0;

        for (int i=0, len=s.length(); i<len;) {
            int temp = 0;

            if (s.charAt(i) == '0') {
                for (; i<len && s.charAt(i) == '0'; i++)
                    temp++;

                maxZero = Math.max(temp, maxZero);

            } else {
                for (; i<len && s.charAt(i) == '1'; i++)
                    temp++;

                maxOne = Math.max(temp, maxOne);
            }
        }

        return maxOne > maxZero;
    }
}
