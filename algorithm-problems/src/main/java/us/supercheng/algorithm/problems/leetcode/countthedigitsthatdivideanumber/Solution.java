package us.supercheng.algorithm.problems.leetcode.countthedigitsthatdivideanumber;

class Solution {

    public int countDigits(int num) {
        int ret = 0;

        for (int backup = num; num != 0; num /= 10)
            if (backup % (num % 10) == 0)
                ret++;

        return ret;
    }

}
