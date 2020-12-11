package us.supercheng.algorithm.problems.leetcode.squaresofasortedarray;

class Solution {
    public int[] sortedSquares(int[] A) {
        int [] ret = new int [A.length];

        for (int left = 0, right = A.length -1, index = right;index > -1;index--) {
            int leftRes = A[left] * A[left],
                    rightRes = A[right] * A[right];
            if (leftRes > rightRes) {
                ret[index] = leftRes;
                left++;
            } else {
                ret[index] = rightRes;
                right--;
            }
        }
        return ret;
    }
}