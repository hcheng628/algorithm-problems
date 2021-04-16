package us.supercheng.algorithm.problems.algo.maximizeexpression;

import java.util.*;

public class Program {

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

}