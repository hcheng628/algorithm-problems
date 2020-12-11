package us.supercheng.algorithm.problems.leetcode.bulbswitcher;

class Solution {
    public int bulbSwitch(int n) {
        if (n < 1)
            return 0;
        else if (n < 4)
            return 1;

        int ret = 0, capacity=3;
        while (n>0) {
            int currCapacity = capacity;
            while(capacity > 0) {
                capacity--;
                n--;
            }
            capacity=currCapacity+2;
            ret++;
        }
        return ret;
    }
}