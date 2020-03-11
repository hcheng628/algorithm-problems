package us.supercheng.algorithm.problems.friendsofappropriateages;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int numFriendRequests(int[] ages) {
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0, len=ages.length; i<len;i++) {
            int curr = ages[i];
            if (map.containsKey(curr))
                ret += map.get(curr);
            else {
                int count = 0;
                for (int j=0; j<len;j++)
                    if (i != j && !(ages[j] > curr || (ages[j] > 100 && curr < 100) ||
                            (curr * 0.5 + 7) >= ages[j]))
                        count++;
                map.put(curr, count);
                ret += count;
            }
        }

        return ret;
    }
}