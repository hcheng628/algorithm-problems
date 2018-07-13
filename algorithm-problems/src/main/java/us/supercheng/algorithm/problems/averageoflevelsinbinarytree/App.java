package us.supercheng.algorithm.problems.averageoflevelsinbinarytree;

import us.supercheng.algorithm.common.entity.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
}