package us.supercheng.algorithm.problems.leetcode.largestnumberafterdigitswapsbyparity;

class Solution {

    public int largestInteger(int num) {
        int ret = 0;
        int[] count = new int[10];

        for (int n = num; n != 0; n /= 10)
            count[n % 10]++;

        for (int n = num, base = 1; n != 0; n /= 10)
            for (int i = 0, curr = n % 10; i < 10; i++)
                if (count[i] > 0 && ((curr + i) & 1) == 0) {
                    count[i]--;
                    ret += base * i;
                    base *= 10;
                    break;
                }

        return ret;
    }

}
