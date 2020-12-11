package us.supercheng.algorithm.problems.leetcode.maximum69number;

class Solution {
    public int maximum69Number (int num) {
        int ret = num;
        char[] chars = Integer.toString(num).toCharArray();

        for (int i=0, len=chars.length; i<len; i++)
            if (chars[i] == '6') {
                chars[i] = '9';
                ret = Math.max(ret, Integer.parseInt(new String(chars)));
                chars[i] = '6';
            }

        return ret;
    }
}