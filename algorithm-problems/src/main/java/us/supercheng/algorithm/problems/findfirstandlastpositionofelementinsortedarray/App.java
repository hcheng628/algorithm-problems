package us.supercheng.algorithm.problems.findfirstandlastpositionofelementinsortedarray;

import java.util.Arrays;

public class App {

    public int[] searchRange(int[] nums, int target) {
        int [] ret = {-1, -1};
        int index = Arrays.binarySearch(nums, target);
        if(index < 0)
            return ret;

        int pre = index - 1, next = index + 1;
        for(;pre >=0 && nums[pre] == target;pre--) {}
        for(;next < nums.length && nums[next] == target;next++) {}

        if(pre+1 >= 0 && nums[pre+1] == target)
            ret[0] = pre+1;
        else
            ret[0] = index;

        if(next-1 <= nums.length -1 && nums[next-1] == target)
            ret[1] = next - 1;
        else
            ret[1] = index;
        return ret;
    }
}