package us.supercheng.algorithm.problems.replaceelementswithgreatestelementonrightside;

public class Solution {

    public int[] replaceElements(int[] arr) {
        int len = arr.length;

        if (len == 1)
            return new int[]{-1};

        int currMax = arr[len-1],
                idx = len - 2;

        for (int i=len-2;i>0;i--) {
            if (arr[i] > currMax)
                currMax = arr[i];
            arr[idx--] = currMax;
        }


        for (int i=0;i<len-1;i++)
            arr[i] = arr[i+1];
        arr[len-1] = -1;

        return arr;
    }
}