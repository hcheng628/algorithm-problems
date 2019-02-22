package us.supercheng.algorithm.algorithm.graph.minspantrees;

import us.supercheng.algorithm.algorithm.graph.common.Edge;
import us.supercheng.algorithm.algorithm.graph.common.MinHeap;
import us.supercheng.algorithm.algorithm.graph.common.WeightedGraph;
import us.supercheng.algorithm.algorithm.unionfind.UnionFindV2;
import java.util.Vector;

public class KruskalMST<Weight extends Number & Comparable> {

    private WeightedGraph<Weight> g;
    private Vector<Edge<Weight>> edges;
    private UnionFindV2 unionFind;
    private MinHeap<Edge<Weight>> minHeap;
    private Number mstAmount;

    public KruskalMST(WeightedGraph<Weight> g) {
        this.g = g;
        this.edges = new Vector<>();

        this.unionFind = new UnionFindV2(this.g.getVertex());
        this.minHeap = new MinHeap<>(this.g.getEdge());


        for (int vertex=0;vertex<this.g.getVertex();vertex++)
            for (Edge<Weight> eachEdge : this.g.adj(vertex))
                this.minHeap.insert(eachEdge);


        double temp = 0.0;
        while (!this.minHeap.isEmpty() && this.edges.size() < this.g.getVertex() - 1) {
            Edge<Weight> each = this.minHeap.popMin();
            if (this.unionFind.isConnected(each.getA(), each.getB()))
                continue;
            this.edges.add(each);
            this.unionFind.unionElements(each.getA(), each.getB());
            temp += each.getWeight().doubleValue();
        }
        this.mstAmount = temp;
    }


    public Vector<Edge<Weight>> getEdges() {
        return this.edges;
    }

    public Number result() {
        return this.mstAmount;
    }
}