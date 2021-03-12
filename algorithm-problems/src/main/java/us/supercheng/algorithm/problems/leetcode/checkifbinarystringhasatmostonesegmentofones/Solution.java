package us.supercheng.algorithm.problems.leetcode.checkifbinarystringhasatmostonesegmentofones;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean checkOnesSegment(String s) {
        List<Integer> ones = new ArrayList<>();

        for (int i=0, len=s.length(); i<len; i++)
            if (s.charAt(i) == '1') {
                if (!ones.isEmpty() && ones.get(ones.size() - 1) + 1 != i)
                    return false;
                ones.add(i);
            }

        return true;
    }

}
