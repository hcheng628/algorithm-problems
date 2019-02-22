package us.supercheng.algorithm.algorithm.graph.shortestpath;

import us.supercheng.algorithm.algorithm.graph.common.Edge;
import us.supercheng.algorithm.algorithm.graph.common.IndexMinHeap;
import us.supercheng.algorithm.algorithm.graph.common.WeightedGraph;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Stack;

public class Dijkstra<Weight extends Number & Comparable> {

    private int from;
    private WeightedGraph<Weight> g;
    private boolean [] visited;
    private IndexMinHeap<Edge<Weight>> indexMinHeap;
    private Number [] toEdges;
    private Edge<Weight> [] fromEdges;

    public Dijkstra(WeightedGraph<Weight> g, int from) {
        this.from = from;
        this.g = g;
        this.visited = new boolean [g.getVertex()];
        this.toEdges = new Number [g.getVertex()];
        this.fromEdges = new Edge [g.getEdge()];
        this.indexMinHeap = new IndexMinHeap<>(this.g.getEdge());

        this.travel(from);
        while (!this.indexMinHeap.isEmpty()) {
            int minIndex = this.indexMinHeap.popMinIndex();
            this.travel(minIndex);
        }
    }

    private void travel(int to) {
        if (this.visited[to])
            return;

        this.visited[to] = true;
        for (Edge<Weight> edge : this.g.adj(to))
            if (!this.visited[edge.other(to)]) {
                if (this.toEdges[edge.other(to)] == null) {
                    this.fromEdges[edge.other(to)] = edge;
                    this.toEdges[edge.other(to)] = edge.getWeight();
                } else {
                    double a = this.toEdges[edge.other(to)].doubleValue();
                    double b = this.toEdges[to].doubleValue() + edge.getWeight().doubleValue();
                    if (a > b) {
                        this.toEdges[edge.other(to)] = b;
                        this.fromEdges[edge.other(to)] = edge;
                    }
                }
                this.indexMinHeap.insert(edge.other(to), edge);
            }
    }

    public void showPath(int to) {
        if (!this.hasPathTo(to))
            return;

        Stack<Edge<Weight>> stack = new Stack<>();
        while (to != this.from) {
            stack.push(this.fromEdges[to]);
            to = this.fromEdges[to].other(to);
        }

        PrintHelper.echoLn("******");
        while (!stack.isEmpty())
            PrintHelper.echo(stack.pop() + "\t");
        PrintHelper.echoLn("\r\n******");
    }

    public boolean hasPathTo(int to) {
        return this.visited[to];
    }

    public Number shortestPathTo(int to) {
        if(this.hasPathTo(to))
            return this.toEdges[to].doubleValue();
        return -1;
    }
}