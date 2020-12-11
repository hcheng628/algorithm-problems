package us.supercheng.algorithm.problems.leetcode.repeateddnasequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap();
        List<String> ret = new ArrayList();

        for(int i=0;i<s.length()-9;i++) {
            String each = s.substring(i, i+10);
            map.put(each, map.getOrDefault(each, 0) + 1);
        }

        for(String key : map.keySet())
            if(map.get(key)>1)
                ret.add(key);
        return ret;
    }
}