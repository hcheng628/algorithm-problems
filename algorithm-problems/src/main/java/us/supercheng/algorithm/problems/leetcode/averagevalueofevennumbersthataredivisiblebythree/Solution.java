package us.supercheng.algorithm.problems.leetcode.averagevalueofevennumbersthataredivisiblebythree;

class Solution {

    public int averageValue(int[] nums) {
        int[] info = new int[]{0, 0};

        for (int n : nums)
            if (n % 6 == 0) {
                info[0] += n;
                info[1]++;
            }

        return info[1] == 0 ? 0 : info[0] / info[1];
    }

}
