package us.supercheng.algorithm.problems.leetcode.rangebitwiseand;

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        for(;m != n;shift++) {
            m >>=1;
            n >>=1;
        }
        return m << shift;
    }
}