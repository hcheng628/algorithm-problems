package us.supercheng.algorithm.problems.uniquebinarysearchtreesii;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String [] args) {
        int n = 3;
        int [] nums = new int [n];

        for(int i=0;i<n;i++) {
            nums[i] = i+1;
        }

        List<List<Integer>> superList = new ArrayList<>();
        new App().helper(new ArrayList<Integer>(), superList, nums);

        for(List<Integer> row : superList) {
            for(int each : row) {
                PrintHelper.echo(each);
            }
            PrintHelper.echoLn("");
        }

    }

    private void helper(List<Integer> list, List<List<Integer>> superList, int[] nums) {
        if(list.size() > nums.length)
            return;

        if(list.size() == nums.length) {
            superList.add(new ArrayList(list));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
                this.helper(list, superList, nums);
                list.remove(list.size()-1);
            }
        }
    }

}
