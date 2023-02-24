package us.supercheng.algorithm.problems.leetcode.removelettertoequalizefrequency;

class Solution {

    public boolean equalFrequency(String word) {
        char[] chars = word.toCharArray();

        for (int i = 0, len = chars.length; i < len; i++)
            if (this.checkM(chars, i, len))
                return true;

        return false;
    }

    private boolean checkM(char[] chars, int idx, int len) {
        int[] count = new int[26];

        for (int i = 0; i < len; i++)
            if (i != idx)
                count[chars[i] - 'a']++;

        for (int i = 0, freq = 0; i < 26; i++)
            if (count[i] != 0)
                if (freq == 0)
                    freq = count[i];
                else if (freq != count[i])
                    return false;

        return true;
    }

}
