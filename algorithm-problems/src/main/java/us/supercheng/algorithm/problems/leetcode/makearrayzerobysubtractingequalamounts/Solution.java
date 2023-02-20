package us.supercheng.algorithm.problems.leetcode.makearrayzerobysubtractingequalamounts;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return set.contains(0) ? set.size() - 1 : set.size();
    }

}
