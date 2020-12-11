package us.supercheng.algorithm.problems.leetcode.intersectionoftwoarrays;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.*;

public class App {

    public static void main(String[] args) {
        int [] arr1 = {2,3,4,5};
        int [] arr2 = {2,2};
        App app = new App();

        for(Integer each : app.intersection(arr1, arr2))
            PrintHelper.echo(each + " ");

        PrintHelper.echoLn("");

        for(Integer each : app.intersection2(arr1, arr2))
            PrintHelper.echo(each + " ");
    }


    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for(int i=0;i<nums1.length;i++) {
            setA.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++) {
            setB.add(nums2[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(Integer each : setB) {
            if(setA.contains(each)) {
                list.add(each);
            }
        }
        int [] ret = new int [list.size()];
        for(int i=0;i<ret.length;i++)
            ret[i] = list.get(i);
        return ret;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        if((nums1 == null || nums1.length == 0) || (nums2 == null || nums2.length == 0))
            return new int[0];
        Set<Integer> setA = new HashSet<>();
        for(int i=0;i<nums1.length;i++) {
            setA.add(nums1[i]);
        }
        List<Integer> list = new ArrayList<>();
        Integer prev = null;
        Arrays.sort(nums2);
        for(int i=0;i<nums2.length;i++) {
            if(setA.contains(nums2[i]) && (prev == null || nums2[i] != prev)) {
                list.add(nums2[i]);
                prev = nums2[i];
            }
        }
        int [] ret = new int [list.size()];
        for(int i=0;i<ret.length;i++)
            ret[i] = list.get(i);
        return ret;
    }
}
