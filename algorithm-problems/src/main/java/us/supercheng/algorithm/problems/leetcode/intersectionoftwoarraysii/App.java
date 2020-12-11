package us.supercheng.algorithm.problems.leetcode.intersectionoftwoarraysii;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.*;

public class App {

    public static void main(String[] args) {
        int [] arr1 = {2,3,4,5};
        int [] arr2 = {2,2};
        App app = new App();

        for(Integer each : app.intersect(arr1, arr2))
            PrintHelper.echo(each + " ");
        PrintHelper.echoLn("");

        for(Integer each : app.intersect2(arr1, arr2))
            PrintHelper.echo(each + " ");
        PrintHelper.echoLn("");
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0;i<nums1.length;i++) {
            if(map1.get(nums1[i]) == null) {
                map1.put(nums1[i], 1);
            } else {
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            }
        }
        for(int i=0;i<nums2.length;i++) {
            if(map2.get(nums2[i]) ==null) {
                map2.put(nums2[i],1);
            } else {
                map2.put(nums2[i], map2.get(nums2[i]) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Integer key : map1.keySet()) {
            if(map2.get(key) != null) {
                int size = map2.get(key) > map1.get(key) ? map1.get(key) : map2.get(key);
                for(int i=0;i<size;i++){
                    list.add(key);
                }
            }
        }
        int [] arr = new int [list.size()];
        for(int i=0;i<list.size();i++)
            arr[i] = list.get(i);
        return arr;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while(index1 < nums1.length && index2 < nums2.length){
            if(nums1[index1] == nums2[index2]) {
                list.add(nums1[index1++]);
                index2++;
            } else if (nums1[index1] > nums2[index2])
                index2++;
            else
                index1++;
        }
        int [] arr = new int [list.size()];
        for(int i=0;i<list.size();i++)
            arr[i] = list.get(i);
        return arr;
    }
}