package us.supercheng.algorithm.problems.leetcode.largest3samedigitnumberinstring;

class Solution {

    public String largestGoodInteger(String num) {
        Integer ret = null;

        for (int i = 0, right = 0, len = num.length(); i < len; i = right) {
            right = i + 1;
            char c = num.charAt(i);

            while (right < num.length() && c == num.charAt(right))
                right++;

            if (num.charAt(right - 1) == c && right - i > 2) {
                int curr = (c - '0') * 100 + (c - '0') * 10 + (c - '0');
                if (ret == null || ret < curr)
                    ret = curr;
            }
        }

        return ret == null ? "" : ret == 0 ? "000" : String.valueOf(ret);
    }

}