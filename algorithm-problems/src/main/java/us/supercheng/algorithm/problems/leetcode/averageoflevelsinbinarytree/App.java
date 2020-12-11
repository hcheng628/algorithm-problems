package us.supercheng.algorithm.problems.leetcode.averageoflevelsinbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {

    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<Integer> eachList = new LinkedList<>();
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        LinkedList<Double> ret = new LinkedList<>();
        this.helper(root, 1, map);
        for(int i=1; i<=map.size();i++) {
            LinkedList<Integer> each = map.get(i);
            double sum = 0;
            for(int j=0;j<each.size();j++)
                sum+=each.get(j);
            ret.add(sum / each.size());
        }
        return ret;
    }

    private void helper(TreeNode root, int level, HashMap<Integer, LinkedList<Integer>> map) {
        if(root == null)
            return;
        if(map.containsKey(level))
            map.get(level).add(root.val);
        else {
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(root.val);
            map.put(level, temp);
        }
        this.helper(root.left, level + 1, map);
        this.helper(root.right, level + 1, map);
    }

    public List<Double> averageOfLevels2(TreeNode root) {
        LinkedList<Integer> count = new LinkedList<>();
        LinkedList<Double> ret = new LinkedList<>();
        this.helper2(root, 1, ret, count);
        for(int i=0;i<ret.size();i++)
            ret.set(i, ret.get(i)/count.get(i));
        return ret;
    }

    private void helper2(TreeNode root, int level, List<Double> list, List<Integer> count) {
        if(root == null)
            return;
        if(list.size() < level || list.get(level-1) == null) {
            list.add((double) root.val);
            count.add(1);
        }else {
            list.set(level-1, list.get(level-1) + root.val);
            count.set(level-1, count.get(level-1) + 1);
        }
        this.helper2(root.left, level + 1, list, count);
        this.helper2(root.right, level + 1, list, count);
    }

    public List<Double> averageOfLevels3(TreeNode root) {
        LinkedList<Double> ret = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            double eachSum = 0;
            for(int i=0;i<size;i++) {
                TreeNode node = queue.remove();
                eachSum += node.val;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            ret.add(eachSum / size);
        }
        return ret;
    }
}