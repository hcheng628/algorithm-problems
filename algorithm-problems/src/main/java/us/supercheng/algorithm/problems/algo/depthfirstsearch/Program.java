package us.supercheng.algorithm.problems.algo.depthfirstsearch;

import java.util.*;

public class Program {
    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch_Solution1(List<String> array) {
            return this.depthFirstSearch_Solution1(array, this);
        }

        public List<String> depthFirstSearch_Solution1(List<String> array, Node n) {
            if (n == null)
                return array;

            array.add(n.name);
            if (n.children != null)
                for (Node c : n.children)
                    this.depthFirstSearch_Solution1(array, c);

            return array;
        }

        public List<String> depthFirstSearch_Solution2(List<String> array) {
            Stack<Node> stack = new Stack<>();
            stack.push(this);

            while (!stack.isEmpty()) {
                Node n = stack.pop();
                array.add(n.name);

                if (n.children != null)
                    for (int idx=n.children.size()-1; idx>-1; idx--)
                        stack.push(n.children.get(idx));
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
