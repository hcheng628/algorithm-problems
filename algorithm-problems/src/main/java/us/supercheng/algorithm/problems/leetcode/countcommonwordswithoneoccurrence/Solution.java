package us.supercheng.algorithm.problems.leetcode.countcommonwordswithoneoccurrence;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int countWords(String[] words1, String[] words2) {
        if (words1 == null || words2 == null)
            return 0;

        int ret = 0;
        Map<String, Integer> m1 = this.initMap(words1);
        Map<String, Integer> m2 = this.initMap(words2);

        for (String w : words1)
            if (m1.get(w) == 1) {
                Integer count = m2.get(w);
                if (count != null && count == 1)
                    ret++;
            }

        return ret;
    }

    public Map<String, Integer> initMap(String[] words) {
        Map<String, Integer> ret = new HashMap<>();

        for (String w : words)
            ret.put(w, ret.getOrDefault(w, 0) + 1);

        return ret;
    }

}
