package us.supercheng.algorithm.problems.decompressrunlengthencodedlist;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i=0, len=nums.length; i< len;i+=2)
            for (int j=0;j<nums[i];j++)
                list.add(nums[i+1]);

        int[] ret = new int[list.size()];
        for (int i=0, len=ret.length; i<len; i++)
            ret[i] = list.get(i);

        return ret;
    }
}