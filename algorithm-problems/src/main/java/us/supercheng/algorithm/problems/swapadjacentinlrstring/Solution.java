package us.supercheng.algorithm.problems.swapadjacentinlrstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    Set<String> set;

    public boolean canTransformTLE(String start, String end) {
        this.set = new HashSet<>();
        return this.dfs(start, end);
    }

    private boolean dfs(String s, String target) {
        if (s.equals(target))
            return true;
        if (this.set.contains(s))
            return false;

        this.set.add(s);
        for (int i=0;i<s.length()-1;i++) {
            char curr = s.charAt(i),
                    next = s.charAt(i+1);
            if (curr == 'R' && next == 'X') {
                char[] chars = s.toCharArray();
                chars[i] = 'X';
                chars[i+1] = 'R';
                boolean res = this.dfs(String.valueOf(chars), target);
                if (res)
                    return true;
            } else if (curr == 'X' && next == 'L') {
                char[] chars = s.toCharArray();
                chars[i] = 'L';
                chars[i+1] = 'X';
                boolean res = this.dfs(String.valueOf(chars), target);
                if (res)
                    return true;
            }
        }

        return false;
    }
}