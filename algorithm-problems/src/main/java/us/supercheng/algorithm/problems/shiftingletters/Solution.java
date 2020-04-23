package us.supercheng.algorithm.problems.shiftingletters;

public class Solution {

    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();
        int len = chars.length;

        for (int i=len-1, amt=0; i>-1; i--)
            amt = shifts[i] = (shifts[i] + amt) % 26;

        for (int i=0; i<len; i++) {
            char c = (char) ((shifts[i] + chars[i] - 'a') % 26 + 'a');
            if (c != chars[i])
                chars[i] = c;
        }

        return new String(chars);
    }
}