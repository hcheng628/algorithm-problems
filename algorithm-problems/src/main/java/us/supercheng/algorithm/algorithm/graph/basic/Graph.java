package us.supercheng.algorithm.algorithm.graph.basic;

public interface Graph {
    int getVertex();
    int getEdge();
    void addEdge(int from, int to);
    boolean hasEdge(int from, int to);
    Iterable<Integer> adj(int vertex);
    void show();
}