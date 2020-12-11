package us.supercheng.algorithm.problems.leetcode.decryptstringfromalphabettointegermapping;

public class Solution {

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();

        for (int idx = 0, len = s.length(); idx < len; idx++)
            if (idx + 2 < len && s.charAt(idx + 2) == '#') {
                sb.append((char) (Integer.parseInt(s.substring(idx, idx+2)) + 'a' - 1));
                idx += 2;
            } else
                sb.append((char) (s.charAt(idx) - '0' + 'a' - 1));

        return sb.toString();
    }
}