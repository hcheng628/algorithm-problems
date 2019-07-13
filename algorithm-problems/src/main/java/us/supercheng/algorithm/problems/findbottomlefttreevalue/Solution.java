package us.supercheng.algorithm.problems.findbottomlefttreevalue;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.HashMap;
import java.util.Map;

class Solution {

    int maxLevel;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return 0;

        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(0, root);
        this.findLeftNode(map, root, 0);

        return map.get(maxLevel).val;
    }

    private void findLeftNode(Map<Integer, TreeNode> map, TreeNode root, int level) {
        if (root == null)
            return;

        int nextLevel = level + 1;

        if (root.left != null) {
            if (!map.containsKey(nextLevel)) {
                map.put(nextLevel, root.left);
                this.maxLevel = Math.max(this.maxLevel, nextLevel);
            }
            this.findLeftNode(map, root.left, nextLevel);
        }

        if (root.right != null) {
            if (!map.containsKey(nextLevel)) {
                map.put(nextLevel, root.right);
                this.maxLevel = Math.max(this.maxLevel, nextLevel);
            }
            this.findLeftNode(map, root.right, nextLevel);
        }
    }

}