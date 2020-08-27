package us.supercheng.algorithm.problems.maketwoarraysequalbyreversingsubarrays;

public class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        int[] bucketT = new int[1001],
                bucketA = new int[1001];

        for (int i=0, len=arr.length; i<len; i++) {
            bucketT[target[i]]++;
            bucketA[arr[i]]++;
        }


        for (int i=1; i<1001; i++)
            if (bucketT[i] != bucketA[i])
                return false;

        return true;
    }
}
// make-two-arrays-equal-by-reversing-sub-arrays