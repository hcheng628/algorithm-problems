package us.supercheng.algorithm.problems.leetcode.findallnumbersdisappearedinanarray;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int[] arr = {4,3,2,7,8,2,3,1};
        PrintHelper.echoLn(app.findDisappearedNumbers(arr));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        boolean [] arr = new boolean[nums.length + 1];
        for(int each : nums)
            arr[each] = true;
        for(int i=1;i<arr.length;i++)
            if(!arr[i])
                ret.add(i);
        return ret;
    }
}