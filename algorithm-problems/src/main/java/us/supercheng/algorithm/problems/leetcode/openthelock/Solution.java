package us.supercheng.algorithm.problems.leetcode.openthelock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public int openLock(String[] deadends, String target) {
        if (target.equals("0000"))
            return 0;

        Set<String> set = new HashSet<>();
        for (String deadend : deadends)
            set.add(deadend);

        if (set.contains("0000"))
            return -1;

        Queue<char[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int min = 0;
        queue.add(new char[]{'0','0','0','0'});

        while(!queue.isEmpty()) {
            min++;
            for (int i=0, size = queue.size();i<size;i++) {
                char[] curr = queue.poll();
                for (int idx=0;idx<4;idx++) {
                    char backup = curr[idx];
                    for (int j=0;j<2;j++) {
                        if (j%2 == 0)
                            curr[idx] = curr[idx] == '9' ? '0' : ++curr[idx];
                        else
                            curr[idx] = curr[idx] == '0' ? '9' : --curr[idx];

                        String s = new String(curr);
                        if (set.contains(s) || visited.contains(s)) {
                            curr[idx] = backup;
                            continue;
                        }

                        if (s.equals(target))
                            return min;

                        queue.add(s.toCharArray());
                        visited.add(s);
                        curr[idx] = backup;
                    }
                }
            }
        }

        return -1;
    }
}