package us.supercheng.algorithm.problems.leetcode.duplicatezeros;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void duplicateZeros(int[] arr) {
        if (arr == null)
            return;

        List<Integer> list = new ArrayList();

        for (int i=0;i<arr.length;i++) {
            list.add(arr[i]);
            if (arr[i] == 0)
                list.add(0);
        }

        for (int i=0;i<arr.length;i++)
            arr[i] = list.get(i);
    }

    public void duplicateZerosFast(int[] arr) {
        if (arr == null)
            return;

        int len = arr.length,
                i = 0,
                j = 0;

        for (;i<len;i++,j++)
            if(arr[i] == 0)
                j++;

        if (i == j)
            return;

        i--;
        j--;

        for (;i>-1;i--,j--) {
            if (i!=j && j<len)
                arr[j] = arr[i];
            if (arr[i] == 0) {
                j--;
                if (i!=j && j<len)
                    arr[j] = arr[i];
            }
        }
    }
}