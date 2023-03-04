package us.supercheng.algorithm.problems.leetcode.separatethedigitsinanarray;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int n : nums)
            for (int lastIdx = list.size(); n != 0; n/=10)
                list.add(lastIdx, n % 10);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
