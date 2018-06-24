package us.supercheng.algorithm.problems.findmodeinbinarysearchtree;

import us.supercheng.algorithm.common.entity.TreeNode;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        PrintHelper.echoLn(new App().findMode(null));
    }

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = this.helper(root, map, 0);
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer key : map.keySet())
            if(map.get(key) == count)
                list.add(key);
        int[] ret = new int [list.size()];
        for(int i=0;i<ret.length;i++)
            ret[i] = list.get(i);
        return ret;
    }

    private int helper(TreeNode node, HashMap<Integer, Integer> map, int maxCount) {
        if(node == null)
            return maxCount;
        if(map.containsKey(node.val)) {
            int count = map.get(node.val) + 1;
            map.put(node.val, count);
            maxCount = Math.max(maxCount, count);
        } else {
            map.put(node.val, 1);
            maxCount = Math.max(maxCount, 1);
        }
        return Math.max(this.helper(node.left, map, maxCount), this.helper(node.right, map, maxCount));
    }
}