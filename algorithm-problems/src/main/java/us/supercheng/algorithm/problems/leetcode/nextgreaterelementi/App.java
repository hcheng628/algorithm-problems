package us.supercheng.algorithm.problems.leetcode.nextgreaterelementi;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class App {

    public static void main(String[] args) {
        int [] nums1 = {4,1,2};
        int [] nums2 = {1,3,4,2};
        PrintHelper.echoLn(Arrays.toString(new App().nextGreaterElement(nums1, nums2)));
        PrintHelper.echoLn(Arrays.toString(new App().nextGreaterElement2(nums1, nums2)));
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int eachNum : nums2) {
            if(stack.isEmpty() || stack.peek() > eachNum)
                stack.push(eachNum);
             else {
                while(!stack.isEmpty() && stack.peek() < eachNum)
                    map.put(stack.pop(), eachNum);
                stack.push(eachNum);
            }
        }
        while(!stack.isEmpty())
            map.put(stack.pop(), -1);
        int [] ret = new int [nums1.length];
        for(int i=0;i<ret.length;i++)
            ret[i] = map.get(nums1[i]);
        return ret;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] ret = new int [nums1.length];
        for(int i=0;i<nums1.length;i++)
            ret[i] = this.nextGreaterVal(nums1[i], nums2);
        return ret;
    }

    private int nextGreaterVal(int val, int[] nums2) {
        for(int i=0;i<nums2.length;i++) {
            if(val == nums2[i]) {
                for(;i<nums2.length;i++)
                    if(nums2[i] > val)
                        return nums2[i];
                break;
            }
        }
        return -1;
    }
}