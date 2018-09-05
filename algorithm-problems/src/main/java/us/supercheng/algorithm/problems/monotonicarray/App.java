package us.supercheng.algorithm.problems.monotonicarray;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        int [] A = {6,5,4,4};
        PrintHelper.echoLn(new App().isMonotonic(A));
    }

    public boolean isMonotonic(int[] A) {
        if(A.length == 1)
            return true;
        boolean monotoneUp = true, monotoneDown = true;
        for(int i=0;i<A.length;i++) {
            if((i-1 >=0 && A[i-1] > A[i]) || (i+1 <= A.length -1 && A[i+1] < A[i]))
                monotoneUp = false;
            if((i-1 >=0 && A[i-1] < A[i]) || (i+1 <= A.length -1 && A[i+1] > A[i]))
                monotoneDown = false;
            if(monotoneUp == false && monotoneDown == false)
                return false;
        }
        return true;
    }
}