package us.supercheng.algorithm.problems.permutationsequence;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        int n = 4, k = 3;

        PrintHelper.echoLn(new App().getPermutation(n, k));
    }

    public String getPermutation(int n, int k) {
        int [] nums = new int [n];
        for(int i=0;i<nums.length;i++)
            nums[i] = i+1;
        List<List<Integer>> list = new ArrayList<>();
        this.helper(list, new ArrayList<Integer>(), new HashSet<Integer>(), nums);
        StringBuilder sb = new StringBuilder();

        for(List<Integer> row : list) {
            for(int each : row)
                PrintHelper.echo(each + ",");
            PrintHelper.echoLn("");
        }

        for(int each : list.get(k-1))
            sb.append(each);
        return sb.toString();
    }

    private void helper(List<List<Integer>> list, List<Integer> eachList, HashSet<Integer> set, int [] nums) {
        if(eachList.size() == nums.length) {
            list.add(new ArrayList<>(eachList));
        }

        for(int i=0;i<nums.length;i++) {
            if(set.contains(nums[i]))
                continue;
            set.add(nums[i]);
            eachList.add(nums[i]);
            this.helper(list, eachList, set, nums);
            int del = eachList.get(eachList.size()-1);
            set.remove(del);
            eachList.remove(eachList.size()-1);
        }
    }

    public String getPermutationFast(int n, int k) {
        k--;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++)
            list.add(i);
        int [] fact = new int[n];
        fact[0] = 1;
        for(int i=1;i<n;i++)
            fact[i] = fact[i-1] * i;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<fact.length;i++,n--) {
            int index = k / fact[n-1];
            k = k % fact[n-1] ;
            sb.append(list.get(index));
            list.remove(index);
        }
        return sb.toString();
    }
}