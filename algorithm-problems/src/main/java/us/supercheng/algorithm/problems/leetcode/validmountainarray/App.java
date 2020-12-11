package us.supercheng.algorithm.problems.leetcode.validmountainarray;

public class App {

    public boolean validMountainArray(int[] A) {
        if(A == null || A.length < 3)
            return false;

        int left = 0, right = 0;

        for(int i=0;i<A.length-1;i++) {
            if(A[i] < A[i+1])
                left++;
            else if(A[i] == A[i+1])
                return false;
            else
                break;
        }

        for(int i=A.length-1;i>0;i--) {
            if(A[i] < A[i-1])
                right++;
            else if(A[i] == A[i-1])
                return false;
            else
                break;
        }

        return left != 0 && right != 0 && left + right + 1 == A.length;
    }
}