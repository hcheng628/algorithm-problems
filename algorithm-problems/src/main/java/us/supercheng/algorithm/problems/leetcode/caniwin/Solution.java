package us.supercheng.algorithm.problems.leetcode.caniwin;

import java.util.Arrays;
import java.util.HashMap;

class Solution {

    HashMap<String,Boolean> map;
    int[] visited;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1+maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal)
            return false;

        this.visited = new int[maxChoosableInteger+1];
        this.map = new HashMap<>();
        return this.canWin(maxChoosableInteger, desiredTotal);
    }

    private boolean canWin(int maxChoosableInteger, int desiredTotal) {
        String key = Arrays.toString(this.visited);

        if (this.map.containsKey(key))
            return this.map.get(key);

        for (int i=maxChoosableInteger;i>0;i--)
            if (this.visited[i] == 0) {

                this.visited[i] = 1;

                int newTotal = desiredTotal - i;
                if (newTotal <= 0  || !this.canWin(maxChoosableInteger, newTotal)) {
                    this.map.put(key, true);
                    this.visited[i] = 0;
                    return true;
                }

                this.visited[i] = 0;
            }

        this.map.put(key, false);
        return false;
    }
}