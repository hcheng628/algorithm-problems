package us.supercheng.algorithm.problems.leetcode.findkclosestelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = new ArrayList<>();
        int idx = Arrays.binarySearch(arr, x),
                len = arr.length;

        if (idx < 0) {
            idx = (-idx) - 1;
            int left = idx-1;
            if (left > -1 && x - arr[left] <= arr[idx] - x)
                idx = left;
        }

        ret.add(arr[idx]);
        for (int left=idx-1,right=idx+1;ret.size()<k;) {
            if (left > -1 && right < len)
                if (x - arr[left] <= arr[right] - x)
                    ret.add(0,arr[left--]);
                else
                    ret.add(arr[right++]);
            else if (left > -1)
                ret.add(0,arr[left--]);
            else
                ret.add(arr[right++]);
        }
        return ret;
    }
}