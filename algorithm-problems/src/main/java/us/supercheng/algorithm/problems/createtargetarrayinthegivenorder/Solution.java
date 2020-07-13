package us.supercheng.algorithm.problems.createtargetarrayinthegivenorder;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        int[] ret = new int[len];
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<len; i++)
            list.add(index[i], nums[i]);

        for (int i=0; i<len; i++)
            ret[i] = list.get(i);

        return ret;
    }

}