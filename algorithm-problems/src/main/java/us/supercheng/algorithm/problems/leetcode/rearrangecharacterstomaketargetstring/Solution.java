package us.supercheng.algorithm.problems.leetcode.rearrangecharacterstomaketargetstring;

class Solution {

    public int rearrangeCharacters(String s, String target) {
        int ret = Integer.MAX_VALUE;
        int[] tarMap = new int[26];
        int[] sMap = new int[26];

        for (char c : target.toCharArray())
            tarMap[c - 'a']++;
        for (char c : s.toCharArray())
            sMap[c - 'a']++;

        for (char c : target.toCharArray())
            ret = Math.min(sMap[c - 'a'] / tarMap[c - 'a'], ret);

        return ret;
    }

}
