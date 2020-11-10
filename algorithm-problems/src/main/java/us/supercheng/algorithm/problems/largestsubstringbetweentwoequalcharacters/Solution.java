package us.supercheng.algorithm.problems.largestsubstringbetweentwoequalcharacters;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int maxLengthBetweenEqualCharacters(String s) {
        int ret = -1;
        List<Integer>[] arr = new ArrayList[26];

        for (int i=0, len = s.length(); i<len; i++) {
            int idx = s.charAt(i) - 'a';
            if (arr[idx] == null) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                arr[idx] = l;
            } else
                arr[idx].add(i);
        }

        for (List<Integer> l : arr)
            if (l != null) {
                int size = l.size();
                if (size > 1 && l.get(size-1) - l.get(0) - 1 > ret)
                    ret = l.get(size-1) - l.get(0) - 1;
            }

        return ret;
    }
}
