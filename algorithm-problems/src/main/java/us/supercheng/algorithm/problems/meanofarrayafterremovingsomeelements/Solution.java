package us.supercheng.algorithm.problems.meanofarrayafterremovingsomeelements;

import java.util.Arrays;

public class Solution {
    public double trimMean(int[] arr) {
        double ret = 0.0;
        int len = arr.length,
            idx = (int) (len * .05);

        Arrays.sort(arr);

        for (int i=idx, end=len-idx; i<end;i++)
            ret += arr[i];

        return ret / (len - ( 2 * idx));
    }
}
