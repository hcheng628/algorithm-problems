package us.supercheng.algorithm.problems.algo.smallestsubstringcontaining;

import java.util.*;

public class Program {

    public static String smallestSubstringContaining(String bigString, String smallString) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();
        String ret = null;

        for (char c : smallString.toCharArray())
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

        int happyCount = sMap.size();
        int currCount = 0;

        for (int left=0, right=0, len=bigString.length(); right<len; right++) {
            char c = bigString.charAt(right);
            if (!sMap.containsKey(c))
                continue;

            bMap.put(c, bMap.getOrDefault(c, 0) + 1);
            if (bMap.get(c) == sMap.get(c))
                currCount++;

            while (currCount == happyCount) {
                if (ret == null || right + 1 - left < ret.length())
                    ret = bigString.substring(left, right + 1);

                char l = bigString.charAt(left++);
                if (!sMap.containsKey(l))
                    continue;

                bMap.put(l, bMap.get(l) - 1);
                if (bMap.get(l) < sMap.get(l))
                    currCount--;
            }
        }

        return ret == null ? "" : ret;
    }

}