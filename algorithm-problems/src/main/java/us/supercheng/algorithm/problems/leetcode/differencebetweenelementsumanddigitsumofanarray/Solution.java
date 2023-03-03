package us.supercheng.algorithm.problems.leetcode.differencebetweenelementsumanddigitsumofanarray;

class Solution {

    public int differenceOfSum(int[] nums) {
        int ret = 0;

        for (int n : nums) {
            ret += n;
            for (; n != 0; n /= 10)
                ret -= n % 10;
        }

        return ret;
    }

}
