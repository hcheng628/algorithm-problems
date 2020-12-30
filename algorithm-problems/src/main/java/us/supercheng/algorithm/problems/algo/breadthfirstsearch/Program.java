package us.supercheng.algorithm.problems.algo.breadthfirstsearch;

import java.util.*;

public class Program {
    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> q = new LinkedList<>();

            q.offer(this);

            while (!q.isEmpty()) {
                Node n = q.poll();
                array.add(n.name);
                if (n.children != null && !n.children.isEmpty())
                    q.addAll(n.children);
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

