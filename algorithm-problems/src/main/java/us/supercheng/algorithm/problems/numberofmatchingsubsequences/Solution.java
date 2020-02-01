package us.supercheng.algorithm.problems.numberofmatchingsubsequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int numMatchingSubseq(String S, String[] words) {
        int ret = 0;
        List<List<Integer>> map = new ArrayList<>();

        for (int i=0;i<26;i++)
            map.add(new ArrayList<>());

        for (int i=0,len=S.length();i<len;i++)
            map.get(S.charAt(i)-'a').add(i);

        for (String w : words)
            if (this.isMatching(map, w))
                ret++;

        return ret;
    }

    private boolean isMatching(List<List<Integer>> map, String s) {
        for (int i=0,len=s.length(),idx=-1;i<len;i++) {
            List<Integer> l = map.get(s.charAt(i)-'a');
            int curr = Collections.binarySearch(l, idx+1);
            if (curr < 0)
                curr = -curr - 1;
            if (curr >= l.size())
                return false;
            idx = l.get(curr);
        }
        return true;
    }
}