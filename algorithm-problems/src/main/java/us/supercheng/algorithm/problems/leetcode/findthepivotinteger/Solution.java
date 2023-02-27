package us.supercheng.algorithm.problems.leetcode.findthepivotinteger;

class Solution {

    public int pivotInteger(int n) {
        int left = 1;
        int leftSum = 1;
        int right = n;
        int rightSum = n;

        while (left < right)
            if (leftSum == rightSum) {
                leftSum += ++left;
                rightSum += --right;
            } else if (leftSum < rightSum)
                leftSum += ++left;
            else
                rightSum += --right;

        return leftSum == rightSum && left == right ? left : -1;
    }

}
