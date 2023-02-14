package us.supercheng.algorithm.problems.leetcode.findthekbeautyofanumber;

class Solution {

    public int divisorSubstrings(int num, int k) {
        int ret = 0;
        char[] chars = String.valueOf(num).toCharArray();

        for (int i = 0, len = chars.length; i < len; i++) {
            int sum = 0;
            int j = i;
            for (int count = 0; count < k && j < len; j++, count++)
                sum = sum * 10 + chars[j] - '0';

            if (sum != 0 && i + k == j && num % sum == 0)
                ret++;
        }

        return ret;
    }

}
