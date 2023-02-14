package us.supercheng.algorithm.problems.leetcode.findresultantarrayafterremovinganagrams;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> removeAnagrams(String[] words) {
        List<String> ret = new ArrayList<>();

        for (int i = 0, len = words.length; i < len; i++)
            if (ret.isEmpty() || !this.isAnagram(ret.get(ret.size() - 1), words[i]))
                ret.add(words[i]);

        return ret;
    }


    boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count)
            if (val != 0)
                return false;

        return true;
    }

}