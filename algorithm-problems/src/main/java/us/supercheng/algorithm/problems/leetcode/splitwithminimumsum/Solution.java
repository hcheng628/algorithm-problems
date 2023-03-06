package us.supercheng.algorithm.problems.leetcode.splitwithminimumsum;

class Solution {

    public int splitNum(int num) {
        int a = 0, b = 0;
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);

        for (int i = 0, len = chars.length; i < len; i += 2) {
            a = a * 10 + (chars[i] - '0');
            if (i + 1 < len)
                b = b * 10 + (chars[i + 1] - '0');
        }

        return a + b;
    }

}
