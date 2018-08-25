package us.supercheng.algorithm.problems.peakindexinamountainarray;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int[] A = {0,2,1,0};
        PrintHelper.echoLn(new App().peakIndexInMountainArray(A));
    }

    public int peakIndexInMountainArray(int[] A) {
        for (int i=1;i<A.length-1;i++)
            if(A[i] >= A[i-1] && A[i] >= A[i+1])
                return i;
        return -1;
    }
}