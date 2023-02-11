package us.supercheng.algorithm.problems.leetcode.calculatedigitsumofastring;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public String digitSum(String s, int k) {
        while (s.length() > k)
            s = String.join("", this.replace(this.divide(s, k)));
        return s;
    }

    private List<String> divide(String s, int k) {
        List<String> ret = new ArrayList<>();

        for (int i = 0, len = s.length(); i < len; i += k)
            ret.add(s.substring(i, Math.min(i + k, len)));

        return ret;
    }

    private List<String> replace(List<String> list) {
        List<String> ret = new ArrayList<>();

        for (String s : list) {
            int sum = 0;
            for (int i = 0, len = s.length(); i < len; i++)
                sum += s.charAt(i) - '0';
            ret.add(String.valueOf(sum));
        }

        return ret;
    }

}
