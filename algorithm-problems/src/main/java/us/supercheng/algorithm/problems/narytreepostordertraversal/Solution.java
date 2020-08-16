package us.supercheng.algorithm.problems.narytreepostordertraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> postorder(Node root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> ret = new ArrayList<>();
        if (root.children != null)
            for (Node n : root.children)
                ret.addAll(this.postorder(n));

        ret.add(root.val);

        return ret;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}