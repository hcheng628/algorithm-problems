package us.supercheng.algorithm.problems.kdiffpairsinanarray;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class App {

    public static void main(String[] args) {
        int [] nums = {1, 3, 1, 5, 4};
        int target = 2;
        PrintHelper.echoLn(new App().findPairs(nums, target));
        PrintHelper.echoLn(new App().findPairs2(nums, target));
        PrintHelper.echoLn(new App().findPairs3(nums, target));
        PrintHelper.echoLn(new App().findPairs4(nums, target));

    }

    public int findPairs(int[] nums, int target) {
        if(target<0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int each : nums) {
            if(map.containsKey(each))
                map.put(each, 2);
            else
                map.put(each, 1);
        }
        if(target == 0) {
            int dup = 0;
            for(int key : map.keySet()) {
                if(map.get(key)>1)
                    dup++;
            }
            return dup;
        }
        int i=0;
        for(int each : map.keySet())
            nums[i++]=each;
        int count = 0;
        for(int j=0;j<i;j++) {
            for(int k=j+1;k<i;k++) {
                if(Math.abs(nums[j] - nums[k]) == target)
                    count++;
            }
        }
        return count;
    }

    public int findPairs2(int[] nums, int target) {
        if(nums.length < 2 || target < 0)
            return 0;
        HashSet<Integer> uniq = new HashSet<>();
        int ret = 0;

        Integer prev = null;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]!=nums[i+1])
                uniq.add(nums[i]);
            else if (prev != null && prev != nums[i])
                ret++;
            else if (prev == null && nums[i] == nums[i+1])
                ret++;
            prev = nums[i];
        }

        if(target == 0)
            return ret;
        else
            ret = 0;

        for(int i=0;i<nums.length;i++) {
            if(uniq.contains(nums[i] - target)) {
                ret++;
                uniq.remove(nums[i] - target);
            }
        }
        return ret;
    }

    public int findPairs3(int[] nums, int target) {
        if(target < 0)
            return 0;
        HashSet<Integer> ret = new HashSet<>(), uniq = new HashSet<>();
        for(int each : nums) {
            if(uniq.contains(each - target))
                ret.add(each);
            if(uniq.contains(each + target))
                ret.add(each + target);
            uniq.add(each);
        }
        return ret.size();
    }

    public int findPairs4(int [] nums, int target) {
        if(target < 0)
            return 0;
        Arrays.sort(nums);
        int ret = 0;
        for(int i=0;i<nums.length-1;i++) {
            if(Arrays.binarySearch(nums, i+1, nums.length, nums[i] + target) >= 0)
                ret++;
            while (nums[i]== nums[i+1] && i < nums.length -1)
                i++;
        }
        return ret;
    }
}