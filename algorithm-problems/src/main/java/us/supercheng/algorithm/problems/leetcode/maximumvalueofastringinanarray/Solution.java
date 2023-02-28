package us.supercheng.algorithm.problems.leetcode.maximumvalueofastringinanarray;

class Solution {

    public int maximumValue(String[] strs) {
        int ret = 0;

        for (String s : strs)
            ret = Math.max(this.toInt(s), ret);

        return ret;
    }

    private int toInt(String s) {
        int ret = 0;

        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c))
                return len;
            ret = ret * 10 + (c - '0');
        }

        return ret;
    }

}
