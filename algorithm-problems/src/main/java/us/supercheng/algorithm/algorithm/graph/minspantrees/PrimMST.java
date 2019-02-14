package us.supercheng.algorithm.algorithm.graph.minspantrees;

import us.supercheng.algorithm.algorithm.graph.common.Edge;
import us.supercheng.algorithm.algorithm.graph.common.IndexMinHeap;
import us.supercheng.algorithm.algorithm.graph.common.WeightedGraph;

import java.util.Vector;

public class PrimMST<Weight extends Number & Comparable> {

    private WeightedGraph<Weight> g;
    private Number mstAmount;
    private boolean [] visited;
    private Edge<Weight>[] edgeTo;
    private Vector<Edge<Weight>> edges;
    private IndexMinHeap<Edge<Weight>> indexMinHeap;


    public PrimMST(WeightedGraph<Weight> g) {
        this.g = g;

        this.visited = new boolean[g.getVertex()];
        this.edgeTo = new Edge[g.getEdge()];
        this.edges = new Vector<>();
        this.indexMinHeap = new IndexMinHeap<>(g.getVertex());

        this.visit(0);

        while (!this.indexMinHeap.isEmpty()) {
            int v = this.indexMinHeap.popMinIndex();
            if (this.edgeTo[v] != null)
                this.edges.add(this.edgeTo[v]);
            this.visit(v);
        }

        double temp = 0.0;
        for (Edge<Weight> each : this.edges)
            temp += each.getWeight().doubleValue();
        this.mstAmount = temp;
    }

    private void visit(int index) {
        if (this.visited[index])
            return;

        this.visited[index] = true;

        for (Edge<Weight> e : this.g.adj(index)) {
            if (!this.visited[e.other(index)]) {
                if (this.edgeTo[e.other(index)] == null) {
                    this.edgeTo[e.other(index)] = e;
                    this.indexMinHeap.insert(e.other(index), e);
                } else if (this.edgeTo[e.other(index)].getWeight().compareTo(e.getWeight()) > 0) {
                    this.edgeTo[e.other(index)] = e;
                    this.indexMinHeap.change(e.other(index), e);
                }
            }
        }
    }

    public Vector<Edge<Weight>> getEdges() {
        return this.edges;
    }

    public Number result() {
        return this.mstAmount;
    }
}