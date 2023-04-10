package us.supercheng.algorithm.problems.leetcode.kitemswiththemaximumsum;

class Solution {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k)
            return k;
        return numOnes + numZeros >= k ? numOnes : numOnes - k + numOnes + numZeros;
    }

}