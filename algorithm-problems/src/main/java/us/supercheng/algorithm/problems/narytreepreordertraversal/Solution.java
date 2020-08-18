package us.supercheng.algorithm.problems.narytreepreordertraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> preorder(Node root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> ret = new ArrayList<>();
        ret.add(root.val);

        for (Node n : root.children)
            ret.addAll(this.preorder(n));

        return ret;
    }

    public List<Integer> preorderList(Node root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> ret = new ArrayList<>();
        List<Node> list = new ArrayList<>();
        list.add(root);

        while (!list.isEmpty()) {
            Node n = list.remove(list.size()-1);
            ret.add(n.val);
            int idx = list.size();

            if (n.children != null)
                for (Node c : n.children)
                    list.add(idx, c);
        }

        return ret;
    }

    public List<Integer> preorderStack(Node root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<Integer> ret = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node n = stack.pop();
            ret.add(n.val);

            if (n.children != null)
                for (int idx = n.children.size()-1; idx>-1; idx--)
                    stack.push(n.children.get(idx));
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