package us.supercheng.algorithm.algorithm.graph.shortestpath;

import us.supercheng.algorithm.algorithm.graph.common.Edge;
import us.supercheng.algorithm.algorithm.graph.common.WeightedGraph;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Stack;
import java.util.Vector;

public class BellmanFord<Weight extends Number & Comparable> {

    private int source;
    private boolean hasNegativeCycle;
    private WeightedGraph<Weight> g;
    private Number[] distanceTo;
    private Edge<Weight>[] from;

    public BellmanFord(WeightedGraph<Weight> g, int source) {
        this.g = g;
        this.source = source;
        this.distanceTo = new Number[this.g.getVertex()];
        this.from = new Edge[this.g.getVertex()];

        this.distanceTo[0] = 0;
        for (int i=1;i<this.g.getVertex();i++)
            for (int j=0; j<this.g.getVertex();j++)
                for (Edge<Weight> edge : this.g.adj(j)) {
                    if (this.distanceTo[edge.other(j)] == null) {
                        this.distanceTo[edge.other(j)] = edge.getWeight();
                        this.from[edge.other(j)] = edge;
                    } else {
                        double a = this.distanceTo[edge.other(j)].doubleValue(),
                                b = this.distanceTo[j].doubleValue() + edge.getWeight().doubleValue();
                        if (a > b) {
                            this.distanceTo[edge.other(j)] = b;
                            this.from[edge.other(j)] = edge;
                        }
                    }
                }
        this.detectNegativeCycle();
    }

    private void detectNegativeCycle() {
        for (int i=1;i<this.g.getVertex();i++)
            for (int j=0;j<this.g.getVertex();j++)
                for (Edge<Weight> edge : this.g.adj(j))
                    if (this.distanceTo[edge.other(j)] != null &&
                            this.distanceTo[edge.other(j)].doubleValue() > this.distanceTo[j].doubleValue() + edge.getWeight().doubleValue()) {
                                this.hasNegativeCycle = true;
                                return;
                        }
        this.hasNegativeCycle = false;
    }

    public Vector<Edge<Weight>> shortestPath(int to) {
        if (!this.hasPathTo(to))
            return null;
        Stack<Edge<Weight>> stack = new Stack<>();

        while (to != this.source) {
            stack.push(this.from[to]);
            to = this.from[to].other(to);
        }

        Vector<Edge<Weight>> ret = new Vector<>();
        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }

    public void showPath(int to) {
        if (!this.hasPathTo(to))
            return;

        Stack<Edge<Weight>> stack = new Stack<>();
        while (to != this.source) {
            stack.push(this.from[to]);
            to = this.from[to].other(to);
        }

        PrintHelper.echoLn("******");
        while (!stack.isEmpty())
            PrintHelper.echo(stack.pop() + "\t");
        PrintHelper.echoLn("\r\n******");
    }

    public boolean hasPathTo(int to) {
        return this.distanceTo[to] != null;
    }

    public Number shortestPathTo(int to) {
        if (this.hasPathTo(to))
            return this.distanceTo[to];
        return -1;
    }

    public boolean isHasNegativeCycle() {
        return this.hasNegativeCycle;
    }
}