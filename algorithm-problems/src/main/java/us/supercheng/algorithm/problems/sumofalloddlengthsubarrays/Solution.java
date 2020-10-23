package us.supercheng.algorithm.problems.sumofalloddlengthsubarrays;

public class Solution {

    public int sumOddLengthSubarrays(int[] arr) {
        int ret = 0;

        for (int L=arr.length, size=1; size<=L; size+=2)
            ret += this.sum(arr, L, size);

        return ret;
    }

    public int sum(int[] arr, int L, int size) {
        int ret = 0,
            prev = 0;

        for (int idx=0; idx+size <= L; idx++) {
            int curr = 0;
            if (idx == 0)
                for (int i=0; i<size; i++)
                    curr += arr[i+idx];
            else
                curr = prev + arr[idx+size-1] - arr[idx-1];

            ret += curr;
            prev = curr;
        }

        return ret;
    }
}