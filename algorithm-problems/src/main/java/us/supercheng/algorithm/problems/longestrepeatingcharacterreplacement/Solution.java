package us.supercheng.algorithm.problems.longestrepeatingcharacterreplacement;

class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() < 1)
            return 0;
        else if (k >= s.length())
            return s.length();

        char[] chars = s.toCharArray();
        int [] map = new int [26];
        int ret=1, left=0, right=0, curr =0;

        for (;right<chars.length;right++) {
            curr = Math.max(curr, ++map[chars[right] - 'A']);
            if (curr + k < right-left+1)
                map[chars[left++] - 'A']--;
            ret = Math.max(ret, right - left + 1);
        }
        return ret;
    }
}