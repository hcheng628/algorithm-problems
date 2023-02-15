package us.supercheng.algorithm.problems.leetcode.checkifnumberhasequaldigitcountanddigitvalue;

class Solution {

    public boolean digitCount(String num) {
        int[] count = new int[10];

        for (char n : num.toCharArray())
            count[n - '0']++;

        for (int i = 0, len = num.length(); i < len; i++)
            if (count[i] != num.charAt(i) - '0')
                return false;

        return true;
    }

}
