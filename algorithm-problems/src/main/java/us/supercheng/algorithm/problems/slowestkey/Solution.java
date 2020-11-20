package us.supercheng.algorithm.problems.slowestkey;

public class Solution {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] map = new int[26];
        int max = releaseTimes[0];
        char ret = keysPressed.charAt(0);

        for (int i=1, len=releaseTimes.length; i<len; i++) {
            char c = keysPressed.charAt(i);
            int key = c - 97;
            map[key] = Math.max(map[key], releaseTimes[i] - releaseTimes[i-1]);

            if (map[key] > max) {
                max = map[key];
                ret = c;
            } else if (map[key] == max && c > ret)
                ret = c;
        }

        return ret;
    }
}