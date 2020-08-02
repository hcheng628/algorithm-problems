package us.supercheng.algorithm.problems.minimumvaluetogetpositivestepbystepsum;

public class Solution {
    public int minStartValue(int[] nums) {
        int start = 1;
        boolean found = false;

        for (int len=nums.length;!found;) {
            int curr = start;
            boolean lessThanOne = false;

            for (int i=0;!lessThanOne && i<len; i++) {
                curr += nums[i];
                if (curr < 1)
                    lessThanOne = true;
            }

            if (lessThanOne)
                start++;
            else
                found = true;
        }

        return start;
    }
}
