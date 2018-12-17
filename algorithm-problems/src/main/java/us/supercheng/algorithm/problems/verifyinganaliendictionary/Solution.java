package us.supercheng.algorithm.problems.verifyinganaliendictionary;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<order.length();i++)
            map.put(order.charAt(i), i);

        for(int i=0;i<words.length-1;i++) {
            char[] curr = words[i].toCharArray(),
                    next = words[i+1].toCharArray();
            int size = curr.length > next.length ? next.length : curr.length;

            boolean matchPrefix = false;
            for(int j=0;j<size;j++) {
                if(map.get(curr[j]) > map.get(next[j]))
                    return false;
                else if(map.get(curr[j]).equals(map.get(next[j])))
                    matchPrefix = true;
                else
                    break;
            }
            if(matchPrefix && next.length < curr.length)
                return false;
        }
        return true;
    }
}