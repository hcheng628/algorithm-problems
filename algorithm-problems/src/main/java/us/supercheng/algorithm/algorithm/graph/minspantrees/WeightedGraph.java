package us.supercheng.algorithm.algorithm.graph.minspantrees;

public interface WeightedGraph<Weight extends Number & Comparable> {
    int getVertex();
    int getEdge();
    void addEdge(Edge<Weight> edge);
    boolean hasEdge(int from, int to);
    Iterable<Edge<Weight>> adj(int vertex);
    void show();
}