package us.supercheng.algorithm.problems.algo.maximizeexpression;

import java.util.*;

public class Program {

    // Time: O(n^4) Space: O(1)
    public int maximizeExpression(int[] array) {
        Integer ret = null;

        for (int a=0, len=array.length; a<len; a++)
            for (int b=a+1; b<len; b++)
                for (int c=b+1; c<len; c++)
                    for (int d=c+1; d<len; d++) {
                        int res = array[a] - array[b] + array[c] - array[d];
                        if (ret == null || res > ret)
                            ret = res;
                    }

        return ret == null ? 0 : ret;
    }

    // Time: O(n) Space: O(n)
    public int maximizeExpression_Solution2(int[] array) {
        if (array == null || array.length < 4)
            return 0;

        int len = array.length;
        int ret = 0;
        int[] AAA = new int[len];
        int[] BBB = new int[len];

        AAA[0] = array[0];
        for (int i=1; i<len; i++)
            AAA[i] = Math.max(array[i], AAA[i - 1]);

        BBB[1] = AAA[0] - array[1];
        for (int i=2; i<len; i++)
            BBB[i] = Math.max(AAA[i - 1] - array[i], BBB[i - 1]);

        AAA[2] = BBB[1] + array[2];
        for (int i=3; i<len; i++)
            AAA[i] = Math.max(BBB[i - 1] + array[i], AAA[i - 1]);

        ret = BBB[3] = AAA[2] - array[3];
        for (int i=4; i<len; i++) {
            BBB[i] = Math.max(AAA[i - 1] - array[i], BBB[i - 1]);
            if (BBB[i] > ret)
                ret = BBB[i];
        }

        return ret;
    }

}