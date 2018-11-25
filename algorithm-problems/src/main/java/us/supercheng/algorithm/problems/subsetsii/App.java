package us.supercheng.algorithm.problems.subsetsii;

import java.util.*;

public class App {

    public static void main(String[] args) {
        int [] nums = {1,2,2};
        List<List<Integer>> res = new App().subsetsWithDup(nums);
        for(List<Integer> each : res) {
            for(int e : each) {
                System.out.print(e + ", ");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        this.helper(ret, new ArrayList(), nums, 0);
        return ret;
    }

    private void helper(List<List<Integer>> ret, List<Integer> list, int [] nums, int index) {
        ret.add(new ArrayList<>(list));
        for(int i=index;i<nums.length;i++) {
            if(i != index && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            this.helper(ret, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDupSlow(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(),
                uniqueList = new ArrayList<>();
        Set<String> set = new HashSet<>();

        if(nums.length > 0)
            list.add(new ArrayList());

        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
            this.helper(list, new ArrayList(), nums, i);

        StringBuilder sb = new StringBuilder();
        for(List<Integer> eachRow : list) {
            for(int each : eachRow)
                sb.append(each + ",");
            if(!set.contains(sb.toString())) {
                uniqueList.add(new ArrayList<>(eachRow));
                set.add(sb.toString());
            }
            sb.setLength(0);
        }
        return uniqueList;
    }

    private void helperSlow(List<List<Integer>> ret, List<Integer> list, int[] nums, int index) {
        for(int i=index;i<nums.length;i++) {
            list.add(nums[i]);
            ret.add(new ArrayList<>(list));
            if(i+1 < nums.length)
                this.helper(ret, list, nums, i+1);
            if(list.size() > 0)
                list.remove(list.size()-1);
        }
    }
}