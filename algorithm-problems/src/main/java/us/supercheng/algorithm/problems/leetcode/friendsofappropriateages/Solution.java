package us.supercheng.algorithm.problems.leetcode.friendsofappropriateages;

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

    public int numFriendRequests_BucketVersion(int[] ages) {
        int[] bucket = new int[121];
        int ret = 0;

        for (int age : ages)
            bucket[age]++;


        for (int i=120; i>-1; i--) {
            int countA = bucket[i];
            for (int j=1; j<=i && countA > 0; j++) {
                int countB = bucket[j];
                if (countB == 0 || j <= i * 0.5 + 7)
                    continue;
                ret += countA * countB;
                if (i == j)
                    ret -= countA;
            }
        }

        return ret;
    }
}