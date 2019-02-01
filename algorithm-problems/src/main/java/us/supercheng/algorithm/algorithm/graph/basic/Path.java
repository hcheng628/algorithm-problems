package us.supercheng.algorithm.algorithm.graph.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Path {

    private Graph g;
    private int source;
    private int[] from;
    private boolean [] visited;


    public Path(Graph g, int source) {
        this.g = g;
        this.source = source;

        this.visited = new boolean[g.getVertex()];
        this.from = new int[g.getVertex()];

        for(int i=0;i<this.from.length;i++)
            this.from[i] = -1;

        this.dfs(this.source);
    }

    private void dfs(int vertex) {
        if(this.visited[vertex])
            return;

        this.visited[vertex] = true;

        for (int eachV : this.g.adj(vertex)) {
            this.from[eachV] = vertex;
            this.dfs(eachV);
        }
    }

    public boolean hasPath(int destin) {
        return this.visited[destin];
    }

    public List<Integer> findPath(int destin) {
        if (!this.hasPath(destin))
            return null;

        List<Integer> ret = new ArrayList<>();
        Stack<Integer> stack = new Stack();

        while (destin!=-1) {
            stack.push(destin);
            destin = this.from[destin];
        }

        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }

    public void echoPath(int destin) {

    }
}