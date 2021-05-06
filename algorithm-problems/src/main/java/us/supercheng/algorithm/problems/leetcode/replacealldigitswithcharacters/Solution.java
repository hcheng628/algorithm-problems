package us.supercheng.algorithm.problems.leetcode.replacealldigitswithcharacters;

public class Solution {

    public String replaceDigits(String s) {
        char[] chars = s.toCharArray();

        for (int i=1, len=chars.length; i<len; i+=2)
            chars[i] = (char) (chars[i - 1] + (chars[i] - '0'));

        return new String(chars);
    }

}
