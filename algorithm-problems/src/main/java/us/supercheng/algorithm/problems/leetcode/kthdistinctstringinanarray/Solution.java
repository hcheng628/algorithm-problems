package us.supercheng.algorithm.problems.leetcode.kthdistinctstringinanarray;

import java.util.*;

public class Solution {

    public String kthDistinct(String[] arr, int k) {
        if (k < 1 || arr ==  null || arr.length < 1)
            return "";

        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for (String a : arr) {
            Integer val = map.get(a);
            if (val == null) {
                map.put(a, 1);
                queue.add(a);
            } else
                map.put(a, val + 1);
        }

        for (int count = 0; !queue.isEmpty(); ) {
            String s = queue.poll();
            if (map.get(s) == 1) {
                count++;
                if (count == k)
                    return s;
            }
        }

        return "";
    }

    public String kthDistinctOPT(String[] arr, int k) {
        if (k < 1 || arr ==  null || arr.length < 1)
            return "";

        int count = 0;
        Set<String> uniqueSet = new HashSet<>();
        Set<String> duplicateSet = new HashSet<>();
        for (String a : arr)
            if (uniqueSet.contains(a)) {
                duplicateSet.add(a);
                uniqueSet.remove(a);
            } else if (!duplicateSet.contains(a))
                uniqueSet.add(a);

        for (String a : arr)
            if (uniqueSet.contains(a)) {
                count++;
                if (count == k)
                    return a;
            }

        return "";
    }

}
