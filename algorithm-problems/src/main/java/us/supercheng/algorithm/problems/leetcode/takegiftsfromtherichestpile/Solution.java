package us.supercheng.algorithm.problems.leetcode.takegiftsfromtherichestpile;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {

    public long pickGifts(int[] gifts, int k) {
        long ret = 0l;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int g : gifts) {
            ret += g;
            queue.offer(g);
        }

        for (int i = 0; i < k; i++) {
            int val = queue.poll();
            int sqrt = (int) Math.sqrt(val);
            if (val == sqrt)
                break;

            ret -= (val - sqrt);
            queue.offer(sqrt);
        }

        return ret;
    }

}
