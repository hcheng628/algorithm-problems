package us.supercheng.algorithm.problems.partitionarrayintothreepartswithequalsum;

class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum =0;
        for (int each : A)
            sum += each;

        if (sum % 3 != 0)
            return false;

        sum /=3;
        int part = 0,
                tempSum = 0,
                idx = 0;
        for (;idx<A.length;idx++) {
            tempSum += A[idx];
            if (tempSum == sum) {
                part++;
                tempSum = 0;
            }
        }

        return part == 3 && idx == A.length;
    }
}