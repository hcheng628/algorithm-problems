package us.supercheng.algorithm.problems.narytreelevelordertraversal;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ret = new ArrayList<>();

        if (root != null)
            q.add(root);

        while (!q.isEmpty()) {
            List<Integer> row = new ArrayList<>();

            for (int i=q.size(); i>0; i--) {
                Node n = q.poll();
                row.add(n.val);

                if (n.children != null)
                    for (Node c : n.children)
                        q.offer(c);
            }

            ret.add(row);
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
