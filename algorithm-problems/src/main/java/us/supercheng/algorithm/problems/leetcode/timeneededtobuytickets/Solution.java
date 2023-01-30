package us.supercheng.algorithm.problems.leetcode.timeneededtobuytickets;

public class Solution {

    public int timeRequiredToBuyBF(int[] tickets, int k) {
        if (tickets == null || tickets.length < 1 || k < 0 || k >= tickets.length)
            return -1;

        int ret = 0;
        boolean complete = false;

        while (!complete) {
            for (int i = 0, len = tickets.length; i < len; i++) {
                if (tickets[i] == 0)
                    continue;

                tickets[i]--;
                ret++;
                if (tickets[i] == 0 && k == i) {
                    complete = true;
                    break;
                }
            }
        }

        return ret;
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        if (tickets == null || tickets.length < 1 || k < 0 || k >= tickets.length)
            return -1;

        int ret = 0;

        for (int i = 0; i < k; i++)
            ret += Math.min(tickets[i], tickets[k]);

        for (int i = k + 1, len = tickets.length; i < len; i++)
            ret += Math.min(tickets[i], tickets[k] - 1) ;

        return ret + tickets[k];
    }

}
