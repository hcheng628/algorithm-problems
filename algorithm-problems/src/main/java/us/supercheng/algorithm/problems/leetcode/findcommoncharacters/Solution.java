package us.supercheng.algorithm.problems.leetcode.findcommoncharacters;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] A) {
        List<int []> list = new ArrayList<>();
        List<String> retList = new ArrayList<>();

        for (int i=0;i<A.length;i++) {
            int[] tempCount = new int [26];
            for (int j=0;j<A[i].length();j++)
                tempCount[A[i].charAt(j) - 'a']++;
            list.add(tempCount);
        }

        for (int i=0;i<26;i++) {
            int count = 101;
            for (int j=0;j<list.size();j++)
                count = Math.min(count, list.get(j)[i]);
            for (int j=0;j<count;j++)
                retList.add(Character.toString((char)(i+'a')));
        }
        return retList;
    }
}