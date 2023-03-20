package us.supercheng.algorithm.problems.leetcode.distributemoneytomaximumchildren;

import java.util.Arrays;

class Solution {

    public int distMoney(int money, int children) {
        if (money < children)
            return -1;

        int ret = 0;
        int[] cash = new int[children];
        Arrays.fill(cash, 1);
        money -= children;

        for (int i = 0; i < children && money > 0; i++)
            if (money >= 7) {
                cash[i] += 7;
                money -= 7;
            } else
                if (money == 3) {
                    cash[i] += 2;
                    money -= 2;
                } else {
                    cash[i] += money;
                    money -= money;
                }

        for (int c : cash)
            if (c == 8)
                ret++;

        return money == 0 ? ret : ret - 1;
    }

}
