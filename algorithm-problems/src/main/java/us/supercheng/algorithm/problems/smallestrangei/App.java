package us.supercheng.algorithm.problems.smallestrangei;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int [] A = {2,4,1,3,21,4,2,4,5};
        int k = 12;
        PrintHelper.echoLn(new App().smallestRangeI(A, k));
    }

    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        int min = 0, max = A.length -1;
        if(min == max || Math.abs(A[min] - A[max]) < K*2)
            return 0;
        return Math.abs((A[min] + K) - (A[max] - K));
    }
}
