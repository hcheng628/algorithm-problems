package us.supercheng.algorithm.algorithm.graph.minspantrees;

import us.supercheng.algorithm.algorithm.graph.common.Edge;
import us.supercheng.algorithm.algorithm.graph.common.MinHeap;
import us.supercheng.algorithm.algorithm.graph.common.WeightedGraph;

import java.util.Vector;

public class LazyPrimMST<Weight extends Number & Comparable> {

    private WeightedGraph<Weight> g;
    private Number mstWeight;
    private Vector<Edge<Weight>> edges;
    private boolean [] visited;
    private MinHeap<Edge<Weight>> minHeap;

    public LazyPrimMST(WeightedGraph<Weight> g) {
        this.g = g;
        this.visited = new boolean[this.g.getVertex()];
        this.edges = new Vector<>();
        this.minHeap = new MinHeap<>(this.g.getEdge());

        this.visit(0);

        while (!this.minHeap.isEmpty()) {
            Edge<Weight> eachMinEdge = this.minHeap.popMin();
            if (this.visited[eachMinEdge.getA()] && this.visited[eachMinEdge.getB()])
                continue;

            this.edges.add(eachMinEdge);

            if(!this.visited[eachMinEdge.getA()])
                this.visit(eachMinEdge.getA());
            else
                this.visit(eachMinEdge.getB());

            double temp = 0.0;
            for(Edge<Weight> each : this.edges)
                temp += each.getWeight().doubleValue();
            this.mstWeight = temp;
        }

    }

    private void visit(int index) {
        if (this.visited[index])
            return;
        this.visited[index] = true;
        for (Edge<Weight> eachE : this.g.adj(index))
            if (!this.visited[eachE.other(index)])
                this.minHeap.insert(eachE);
    }

    public Vector<Edge<Weight>> getEdges() {
        return this.edges;
    }

    public Number result() {
        return this.mstWeight;
    }
}