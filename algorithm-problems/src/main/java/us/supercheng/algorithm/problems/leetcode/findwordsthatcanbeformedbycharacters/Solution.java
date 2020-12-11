package us.supercheng.algorithm.problems.leetcode.findwordsthatcanbeformedbycharacters;

public class Solution {

    public int countCharacters(String[] words, String chars) {
        int ret = 0;
        int[] map = new int[26],
              tMap = new int [26];

        for (char c : chars.toCharArray())
            map[c - 'a']++;

        for (String w : words) {
            for (int i=0; i<26; i++)
                if (tMap[i] != map[i])
                    tMap[i] = map[i];

            int len = w.length();
            boolean yes = true;

            for (int i=0; yes && i<len; i++) {
                int idx = w.charAt(i) - 'a';
                tMap[idx]--;
                if (tMap[idx] < 0)
                    yes = false;
            }

            if (yes)
                ret += len;
        }

        return ret;
    }
}
