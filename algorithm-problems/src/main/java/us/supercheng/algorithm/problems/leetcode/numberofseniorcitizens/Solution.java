package us.supercheng.algorithm.problems.leetcode.numberofseniorcitizens;

class Solution {

    public int countSeniors(String[] details) {
        if (details == null || details.length < 1)
            return 0;

        int ret = 0;

        for (String d : details) {
            char[] chars = d.toCharArray();
            if (chars[11] > '6' || (chars[11] == '6' && chars[12] > '0'))
                ret++;
        }

        return ret;
    }

}
