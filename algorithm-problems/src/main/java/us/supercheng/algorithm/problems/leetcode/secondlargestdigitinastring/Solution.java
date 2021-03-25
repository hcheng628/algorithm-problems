package us.supercheng.algorithm.problems.leetcode.secondlargestdigitinastring;

public class Solution {

    public int secondHighest(String s) {
        int max = -1;
        int ret = -1;

        for (char c : s.toCharArray())
            if (Character.isDigit(c)) {
                int val = c - '0';

                if (max == -1)
                    max = val;
                else {
                    if (val == max)
                        continue;
                    if (val > max) {
                        ret = max;
                        max = val;
                    } else if (ret == -1 || val > ret)
                        ret = val;
                }
            }

        return ret;
    }

}