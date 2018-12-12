package us.supercheng.algorithm.problems.clonegraph;

import us.supercheng.algorithm.common.entity.UndirectedGraphNode;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        UndirectedGraphNode a = new UndirectedGraphNode(0);
        UndirectedGraphNode b = new UndirectedGraphNode(0);
        UndirectedGraphNode c = new UndirectedGraphNode(0);

        a.neighbors.add(b);
        a.neighbors.add(c);

        Solution app = new Solution();
        app.cloneGraph(a);
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;

        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node, new UndirectedGraphNode(node.label));

        while(!queue.isEmpty()) {
            UndirectedGraphNode each = queue.remove();
            for(UndirectedGraphNode neighbor : each.neighbors) {
                if(!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                visited.get(each).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}