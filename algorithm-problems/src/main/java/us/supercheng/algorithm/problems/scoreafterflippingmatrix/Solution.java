package us.supercheng.algorithm.problems.scoreafterflippingmatrix;

import java.util.Arrays;

public class Solution {

    public int matrixScore(int[][] A) {
        for (int i=0, len = A.length, lenRow = A[len-1].length; i<lenRow; i++) {
            int zero = 0,
                    one = 0;
            for (int j=0; j<len; j++)
                if (A[j][i] == 0)
                    zero++;
                else
                    one++;

            if (zero > one)
                for (int j=0; j<len; j++)
                    if (A[j][i] == 0)
                        A[j][i] = 1;
                    else
                        A[j][i] = 0;

            for (int j=0; j<len; j++)
                if (A[j][0] == 0)
                    for (int k=0; k<lenRow ;k++)
                        if (A[j][k] == 0)
                            A[j][k] = 1;
                        else
                            A[j][k] = 0;
        }

        int ret = 0;
        for (int[] r : A) {
            StringBuilder sb = new StringBuilder();
            for (int n : r)
                sb.append(n);
            ret += Integer.parseInt(sb.toString(), 2);
        }

        return ret;
    }

    private void p(int[][] A) {
        System.out.println("**********");
        for (int[] r : A)
            System.out.println(Arrays.toString(r));
        System.out.println("**********");
    }
}