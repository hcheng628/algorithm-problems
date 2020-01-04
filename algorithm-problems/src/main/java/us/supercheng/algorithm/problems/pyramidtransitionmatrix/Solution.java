package us.supercheng.algorithm.problems.pyramidtransitionmatrix;

import java.util.*;

class Solution {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        char[] COLORS = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Map<Integer, Map<Integer, Set<Character>>> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        int level = bottom.length();

        for (String s : allowed)
            set.add(s);

        HashMap<Integer, Set<Character>> baseMap = new HashMap<>();
        for (int i=0;i<bottom.length();i++) {
            Set<Character> tempSet = new HashSet<>();
            tempSet.add(bottom.charAt(i));
            baseMap.put(i, tempSet);
        }
        map.put(level-1, baseMap);

        for (int i=level-1;i>=0;i--) {
            Map<Integer, Set<Character>> levelMap = map.get(i);

            if (i == 0)
                return !(levelMap == null || !levelMap.containsKey(0));

            for (int j=0;j<i;j++) {
                if (levelMap == null || !levelMap.containsKey(j) || !levelMap.containsKey(j+1))
                    return false;

                for (char first : levelMap.get(j))
                    for (char second : levelMap.get(j+1))
                        for (char third : COLORS)
                            if (set.contains(new StringBuilder().append(first).append(second).append(third).toString())) {
                                Map<Integer, Set<Character>> prevMap = null;
                                if (map.containsKey(i-1)) {
                                    prevMap = map.get(i-1);
                                    if (prevMap.containsKey(j)) {
                                        prevMap.get(j).add(third);
                                    } else {
                                        Set<Character> temp = new HashSet<>();
                                        temp.add(third);
                                        prevMap.put(j, temp);
                                    }
                                } else {
                                    prevMap = new HashMap<>();
                                    Set<Character> temp = new HashSet<>();
                                    temp.add(third);
                                    prevMap.put(j, temp);
                                }
                                map.put(i-1, prevMap);
                            }
            }
        }
        return false;
    }
}