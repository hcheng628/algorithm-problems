package us.supercheng.algorithm.problems.algo.tandembicycle;

import java.util.*;

public class Program {

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        int ret = 0;
        int len = redShirtSpeeds.length;
        int j = 0;
        int jIncrement = 1;

        if (fastest) {
            j = len - 1;
            jIncrement = -1;
        }

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        for (int i=0; i<len; i++, j+=jIncrement)
            ret += Math.max(redShirtSpeeds[i], blueShirtSpeeds[j]);

        return ret;
    }
}
