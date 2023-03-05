package us.supercheng.algorithm.problems.leetcode.mergetwo2darraysbysummingvalues;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0, j = 0, len1 = nums1.length, len2 = nums2.length; i < len1 || j < len2; ) {
            if (i < len1 && j < len2) {
                if (nums1[i][0] == nums2[j][0])
                    list.add(new int[]{nums1[i][0], nums1[i++][1] + nums2[j++][1]});
                else if (nums1[i][0] < nums2[j][0])
                    list.add(new int[]{nums1[i][0], nums1[i++][1]});
                else
                    list.add(new int[]{nums2[j][0], nums2[j++][1]});
            } else if (i < len1)
                list.add(new int[]{nums1[i][0], nums1[i++][1]});
            else
                list.add(new int[]{nums2[j][0], nums2[j++][1]});
        }

        int[][] ret = new int[list.size()][2];
        for (int i = 0, len = list.size(); i < len; i++)
            ret[i] = list.get(i);

        return ret;
    }

}
