package us.supercheng.algorithm.problems.topkfrequentwords;

import java.util.*;

class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length < 1)
            return new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        List<String> ret = new ArrayList<>();

        for (String s : words)
            map.put(s, map.getOrDefault(s, 0) + 1);

        for (String key : map.keySet())
            set.add(map.get(key));

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int count = k,
            lastIdx=list.size()-1;
        for (int i=0;i<k&&count>0;i++) {
            int curr = list.get(lastIdx-i);
            List<String> temp = new ArrayList<>();
            for (String key : map.keySet())
                if (map.get(key) == curr)
                    temp.add(key);

            Collections.sort(temp);
            for (int j=0;count>0&&j<temp.size();j++,count--)
                ret.add(temp.get(j));
        }

        return ret;
    }
}