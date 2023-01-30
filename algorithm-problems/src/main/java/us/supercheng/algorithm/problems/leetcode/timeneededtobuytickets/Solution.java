package us.supercheng.algorithm.problems.leetcode.timeneededtobuytickets;

public class Solution {

    public int timeRequiredToBuyBF(int[] tickets, int k) {
        if (tickets == null || tickets.length < 1 || k < 0 || k >= tickets.length)
            return -1;

        int ret = 0;

        complete:
        while (true)
            for (int i = 0, len = tickets.length; i < len; i++)
                if (tickets[i] > 0) {
                    tickets[i]--;
                    ret++;
                    if (tickets[i] == 0 && k == i)
                        break complete;
                }

        return ret;
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        if (tickets == null || tickets.length < 1 || k < 0 || k >= tickets.length)
            return -1;

        int ret = 0;

        for (int i = 0, len = tickets.length; i < len; i++)
            ret += i <= k ? Math.min(tickets[i], tickets[k]) : Math.min(tickets[i], tickets[k] - 1);

        return ret;
    }

}
