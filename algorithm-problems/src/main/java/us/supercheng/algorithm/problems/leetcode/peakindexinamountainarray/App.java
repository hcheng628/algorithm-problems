package us.supercheng.algorithm.problems.leetcode.peakindexinamountainarray;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int[] A = {0,2,1,0};
        PrintHelper.echoLn(new App().peakIndexInMountainArray(A));
        PrintHelper.echoLn(new App().peakIndexInMountainArray1(A));
    }

    public int peakIndexInMountainArray1(int[] A) {
        for (int i=1;i<A.length-1;i++)
            if(A[i] >= A[i-1] && A[i] >= A[i+1])
                return i;
        return -1;
    }

    public int peakIndexInMountainArray(int[] A) {
        int left=1, right=A.length-2;
        while(left<=right) {
            int mid = left + (right - left)/2;
            if(A[mid] > A[mid+1] && A[mid] > A[mid-1])
                return mid;
            if(A[mid] < A[mid+1])
                left = mid+1;
            else
                right = mid-1;
        }
        return -1;
    }
}