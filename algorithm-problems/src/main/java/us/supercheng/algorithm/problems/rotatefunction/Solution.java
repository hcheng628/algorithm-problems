package us.supercheng.algorithm.problems.rotatefunction;

public class Solution {
    public int maxRotateFunction(int[] A) {
        int len = A.length,
                rep = len - 1,
                sum = 0,
                res = 0,
                ret = 0;

        for (int i=0;i<len;i++) {
            res += i*A[i];
            sum += A[i];
        }

        ret = res;

        for (int i=0;i<rep;i++) {
            res = res + sum - len * A[rep - i];
            ret = Math.max(res, ret);
        }

        return ret;
    }

    public int maxRotateFunctionSlow(int[] A) {
        int rep = A.length - 1,
                ret = this.doCal(A);
        for (int i=0;i<rep;i++) {
            this.rotate(A, rep);
            ret = Math.max(this.doCal(A), ret);
        }
        return ret;
    }

    private void rotate(int[] A, int lastIdx) {
        int first = A[lastIdx];
        for (int i=lastIdx-1;i>-1;i--)
            A[i+1] = A[i];
        A[0] = first;
    }

    private int doCal(int[] A) {
        int ret = 0;
        for (int i=0;i<A.length;i++)
            ret += i * A[i];
        return ret;
    }
}
