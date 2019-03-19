package us.supercheng.algorithm.problems.permutationsii;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.*;

public class App {

    public static void main(String[]  args) {
        int [] nums = {-1,2,-1,2,1,-1,2,1};
        List<List<Integer>> res = new App().permuteUnique(nums);
        for(List<Integer> row : res) {
            for(int each :  row) {
                PrintHelper.echo(each + ",");
            }
            PrintHelper.echoLn("");
        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        boolean [] used = new boolean[nums.length];
        this.helper(nums, new ArrayList(), ret, used);
        return ret;
    }

    private void helper(int [] nums, List<Integer> list, List<List<Integer>> ret, boolean [] used) {
        if(list.size() == nums.length) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(used[i] == true)
                continue;
            used[i] = true;
            list.add(nums[i]);
            this.helper(nums, list, ret, used);
            used[i] = false;
            list.remove(list.size()-1);
            for(;i<nums.length-1 && nums[i] == nums[i+1];i++);
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ret;

        Arrays.sort(nums);
        this.dfs(ret, nums, 0, new ArrayList<>(), new boolean [nums.length]);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, int [] nums, int idx, List<Integer> list, boolean [] visited) {
        if (list.size() == nums.length) {
            ret.add(new ArrayList(list));
            return;
        }

        for (int i=0;i<nums.length;i++)
            if (!visited[i]) {
                if (i > 0 && nums[i-1] == nums[i] && !visited[i-1])
                    continue;

                list.add(nums[i]);
                visited[i] = true;
                this.dfs(ret, nums, idx+1, list, visited);
                list.remove(list.size()-1);
                visited[i] = false;
            }
    }
}