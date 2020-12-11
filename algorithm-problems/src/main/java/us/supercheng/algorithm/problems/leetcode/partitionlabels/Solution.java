package us.supercheng.algorithm.problems.leetcode.partitionlabels;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<>();
        int[] idxes = new int[26];

        for (int i=0,len=S.length();i<len;i++)
            idxes[S.charAt(i)-'a'] = i;

        int start = 0,
            end = 0;

        for (int i=0,len=S.length();i<len;i++) {
            end = Math.max(end, idxes[S.charAt(i)-'a']);
            if (end == i) {
                ret.add(end-start+1);
                start = end = i + 1;
            }
        }

        return ret;
    }
}