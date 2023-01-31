package us.supercheng.algorithm.problems.leetcode.twofurthesthouseswithdifferentcolors;

public class Solution {

    public int maxDistance(int[] colors) {
        if (colors == null || colors.length < 2)
            return -1;

        int ret = 0;
        int len = colors.length;

        for (int right = len - 1, leftColor = colors[0]; right > 0 && ret == 0; right--)
            if (leftColor != colors[right])
                ret = right;

        for (int left = 0, rightColor = colors[len - 1]; left < len - 1; left++)
            if (colors[left] != rightColor) {
                ret = Math.max(len - 1 - left, ret);
                break;
            }

        return ret;
    }

}
