package us.supercheng.algorithm.problems.globalandlocalinversions;

public class Solution {

    public boolean isIdealPermutation(int[] A) {
        int glo = 0;

        for (int i=0;i<A.length;i++)
            glo += this.invGlo(i, A);

        return glo == this.invLoc(A.length, A);
    }

    private int invGlo(int idx, int[] A) {
        int count = 0;
        for (int i=0;i<idx;i++)
            if (A[i] > A[idx])
                count++;
        return count;
    }

    private int invLoc(int idx, int[] A) {
        int count = 0;
        for (int i=0;i<A.length-1;i++)
            if (A[i] > A[i+1])
                count++;
        return count;
    }
}