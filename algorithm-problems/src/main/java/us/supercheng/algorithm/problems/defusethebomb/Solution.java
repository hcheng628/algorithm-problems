package us.supercheng.algorithm.problems.defusethebomb;

public class Solution {
    public int[] decrypt(int[] code, int k) {
        int len = code.length,
            count = Math.abs(k);
        int[] ret = new int[len];

        if (k == 0)
            return ret;

        for (int i=0; i<len; i++) {
            int sum = 0;

            for (int j=0, ii=i; k!=0 && j<count; j++) {
                if (k > 0)
                    ii = ii + 1 < len ? ii + 1 : 0;
                else
                    ii = ii - 1 > -1 ? ii - 1 : len - 1;
                sum += code[ii];
            }

            ret[i] = sum;
        }

        return ret;
    }
}