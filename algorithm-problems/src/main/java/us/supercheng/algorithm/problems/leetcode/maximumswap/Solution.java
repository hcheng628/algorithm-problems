package us.supercheng.algorithm.problems.leetcode.maximumswap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public int maximumSwap(int num) {
        List<String> list = new ArrayList<>();
        String s = Integer.toString(num);
        list.add(s);
        int len = s.length();

        for (int i=0;i<len;i++)
            for (int j=i+1;j<len;j++)
                this.swap(s.toCharArray(), i, j, list);

        Collections.sort(list);
        return Integer.parseInt(list.get(list.size()-1));

    }

    private void swap(char[] chars, int idxA, int idxB, List<String> list) {
        char temp = chars[idxA];
        chars[idxA] = chars[idxB];
        chars[idxB] = temp;
        list.add(String.valueOf(chars));
    }
}