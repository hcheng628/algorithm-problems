package us.supercheng.algorithm.problems.leetcode.minimumamountoftimetofillcups;

import java.util.Arrays;

class Solution {

    public int fillCupsBF(int[] amount) {
        if (amount[0] + amount[1] + amount[2] == 0)
            return 0;

        Arrays.sort(amount);

        if (amount[1] > 0)
            amount[1]--;
        amount[2]--;

        return 1 + this.fillCups(amount);
    }

    public int fillCups(int[] amount) {
        Arrays.sort(amount);

        if (amount[0] + amount[1] <= amount[2])
            return amount[2];
        return (int) (Math.ceil((amount[0] + amount[1] - amount[2]) / 2.0) + amount[2]);
    }

}
