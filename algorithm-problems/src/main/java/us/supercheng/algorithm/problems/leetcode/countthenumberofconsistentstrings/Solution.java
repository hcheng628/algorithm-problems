package us.supercheng.algorithm.problems.leetcode.countthenumberofconsistentstrings;

public class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] map = new boolean[26];
        int ret = 0;

        for (int i=0, len=allowed.length(); i<len; i++)
            map[allowed.charAt(i) - 'a'] = true;

        for (String w : words) {
            boolean pass = true;
            for (int i=0, len=w.length(); pass && i<len; i++)
                if (!map[w.charAt(i) - 'a'])
                    pass = false;
            if (pass)
                ret++;
        }

        return ret;
    }

}