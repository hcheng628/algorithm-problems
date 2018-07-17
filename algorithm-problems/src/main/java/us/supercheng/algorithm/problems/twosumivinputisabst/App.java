package us.supercheng.algorithm.problems.twosumivinputisabst;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.HashMap;

public class App {

    boolean foundFlag = false;

    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        this.helper(root, map, k);
        return foundFlag;
    }

    private void helper(TreeNode root, HashMap<Integer, Integer> map, int k) {
        if(root == null)
            return;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if((map.containsKey(k-root.val)) && ((k-root.val == root.val && map.get(root.val) >= 2) || (k - root.val != root.val))) {
            this.foundFlag = true;
            return;
        }
        this.helper(root.left, map, k);
        this.helper(root.right, map, k);
    }
}