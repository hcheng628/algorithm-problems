package us.supercheng.algorithm.problems.leetcode.elementappearingmorethan25insortedarray;

public class Solution {

    public int findSpecialInteger(int[] arr) {
        if (arr.length == 1)
            return arr[0];

        int count = (int) Math.ceil(arr.length / 4.0);

        for (int slow=0,fast=0,len = -1,length=arr.length;fast < length;) {
            if (arr[slow] == arr[fast])
                len = ++fast - slow;
            else {
                len = fast - slow;
                slow = fast;
            }
            if (len > count)
                return arr[slow];
        }

        return -1;
    }
}