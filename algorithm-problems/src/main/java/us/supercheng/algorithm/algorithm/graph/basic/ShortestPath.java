package us.supercheng.algorithm.algorithm.graph.basic;

import us.supercheng.algorithm.algorithm.graph.common.Graph;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class ShortestPath {

    private Graph g;
    private int source;
    private boolean[] visited;
    private int[] from;
    private int[] distance;


    public ShortestPath(Graph g, int source) {
        this.g = g;
        this.source = source;
        this.visited = new boolean[this.g.getVertex()];
        this.from = new int[this.g.getVertex()];
        this.distance = new int[this.g.getVertex()];

        for (int i=0;i<this.from.length;i++)
            this.from[i] = -1;

        this.bfs(this.source);
    }

    private void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(vertex);
        this.visited[vertex] = true;
        this.distance[vertex] = 0;

        while (!queue.isEmpty()) {
            int each = queue.poll();
            for (int eachAdj :  this.g.adj(each)) {
                if (!this.visited[eachAdj]) {
                    this.visited[eachAdj] = true;
                    this.from[eachAdj] = each;
                    this.distance[eachAdj] = this.distance[each] + 1;
                    queue.add(eachAdj);
                }
            }
        }
    }

    public boolean hasPath(int destin) {
        return this.visited[destin];
    }

    public Vector<Integer> findPath(int destin) {
        Vector<Integer> ret = null;

        if (this.hasPath(destin)) {
            ret = new Vector<>();
            Stack<Integer> stack = new Stack();

            for (;destin != -1;destin = this.from[destin])
                stack.add(destin);

            while (!stack.isEmpty())
                ret.add(stack.pop());
        }

        return ret;
    }

    public void echoPath(int destin) {
        Vector<Integer> list = this.findPath(destin);
        if (list != null) {
            for (int i=0;i<list.size();i++)
                PrintHelper.echo(i == list.size()-1 ? list.get(i) + "\r\n" : list.get(i) + "->");
        }
    }

    public int getDistance(int destin) {
        return this.distance[destin];
    }
}