package us.supercheng.algorithm.problems.leetcode.latesttimebyreplacinghiddendigits;

public class Solution {

    public String maximumTime(String time) {
        char[] chars = time.toCharArray();

        if (chars[0] == '?')
            chars[0] = chars[1] == '?' || chars[1] < '4' ? '2' : '1';

        if (chars[1] == '?')
            chars[1] = chars[0] != '2' ? '9' : '3';

        if (chars[3] == '?')
            chars[3] = '5';

        if (chars[4] == '?')
            chars[4] = '9';

        return String.valueOf(chars);
    }

}
