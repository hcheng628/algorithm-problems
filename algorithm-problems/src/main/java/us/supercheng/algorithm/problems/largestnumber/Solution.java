package us.supercheng.algorithm.problems.largestnumber;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        String [] arr = new String[nums.length];
        for(int i=0;i<nums.length;i++)
            arr[i] = nums[i] + "";

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });

        boolean allZeros = true;
        for(String each : arr) {
            if(allZeros && !each.equals("0"))
                allZeros = false;
            sb.append(each);
        }

        return allZeros ? "0" : sb.toString();
    }
}