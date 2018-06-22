package us.supercheng.algorithm.problems.nextgreaterelementi;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [] nums1 = {4,1,2};
        int [] nums2 = {1,3,4,2};
        PrintHelper.echoLn(new App().nextGreaterElement(nums1, nums2));
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