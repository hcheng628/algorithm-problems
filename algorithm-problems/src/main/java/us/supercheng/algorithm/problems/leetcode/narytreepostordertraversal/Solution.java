package us.supercheng.algorithm.problems.leetcode.narytreepostordertraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> postorderStack(Node root) {
        List<Integer> ret = new ArrayList();

        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty())
                for (int i=0, len = stack.size(); i<len; i++) {
                    Node n = stack.pop();
                    ret.add(0, n.val);

                    if (n.children != null)
                        for (Node c : n.children)
                            stack.push(c);
                }
        }

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