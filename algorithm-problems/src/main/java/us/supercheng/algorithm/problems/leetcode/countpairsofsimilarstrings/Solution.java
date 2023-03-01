package us.supercheng.algorithm.problems.leetcode.countpairsofsimilarstrings;

class Solution {

    public int similarPairs(String[] words) {
        int ret = 0;
        int len = words.length;
        int[] database = new int[len];
        for (int i = 0; i < len; i++)
            database[i] = this.buildMap(words[i]);

        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++)
                if (database[i] == database[j])
                    ret++;

        return ret;
    }

    private int buildMap(String s) {
        int ret = 0;

        for (int i = 0, len = s.length(); i < len; i++)
            ret |= 1 << (s.charAt(i) - 'a');

        return ret;
    }

}
