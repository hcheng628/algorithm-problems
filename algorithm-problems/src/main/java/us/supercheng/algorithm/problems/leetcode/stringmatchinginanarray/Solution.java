package us.supercheng.algorithm.problems.leetcode.stringmatchinginanarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public List<String> stringMatching(String[] words) {
        List<String> ret = new ArrayList<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        for (int i=0, len=words.length; i<len; i++)
            for (int j=i+1; j<len; j++)
                if (words[j].indexOf(words[i]) > -1) {
                    ret.add(words[i]);
                    break;
                }

        return ret;
    }
}
