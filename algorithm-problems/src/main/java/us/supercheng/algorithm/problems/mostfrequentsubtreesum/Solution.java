package us.supercheng.algorithm.problems.mostfrequentsubtreesum;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    int maxFre = -1;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        this.calSubTreeSum(root, map);

        for (int key : map.keySet())
            if (map.get(key) == this.maxFre)
                list.add(key);

        int[] retArr = new int[list.size()];
        for (int i=0;i<list.size();i++)
            retArr[i] = list.get(i);

        return retArr;
    }

    private int calSubTreeSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null)
            return 0;

        int total = this.calSubTreeSum(root.left, map) + root.val + this.calSubTreeSum(root.right, map);
        map.put(total, map.getOrDefault(total, 0) + 1);
        this.maxFre = Math.max(this.maxFre, map.get(total));

        return total;
    }

}