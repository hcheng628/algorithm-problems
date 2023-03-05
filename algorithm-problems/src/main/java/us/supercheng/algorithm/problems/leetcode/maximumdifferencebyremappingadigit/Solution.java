package us.supercheng.algorithm.problems.leetcode.maximumdifferencebyremappingadigit;

class Solution {

    public int minMaxDifference(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        return this.swapValues(chars, '9') -  this.swapValues(chars, '0');
    }

    private int swapValues(char[] chars, char c) {
        int ret = 0;
        int len = chars.length;
        int[] arr = new int[len];
        char tmp = '-';

        for (int i = 0; i < len; i++)
            if (tmp == '-' && chars[i] != c) {
                tmp = chars[i];
                arr[i] = c - '0';
            } else if (chars[i] == tmp && tmp != '-')
                arr[i] = c - '0';
            else
                arr[i] = chars[i] - '0';

        for (int i = 0; i < len; i++)
            ret = (ret * 10) + arr[i];

        return ret;
    }

}
