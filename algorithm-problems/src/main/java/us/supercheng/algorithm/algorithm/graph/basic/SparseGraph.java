package us.supercheng.algorithm.algorithm.graph.basic;

import java.util.ArrayList;
import java.util.List;

public class SparseGraph {

    private int vertex;
    private int edge;
    private List<List<Integer>> list;
    private boolean isDir;

    public SparseGraph(int vertex, boolean isDir) {
        this.vertex = vertex;
        this.isDir = isDir;
        for (int i=0;i<vertex;i++)
            this.list.add(new ArrayList());
    }

    public int getVertex() {
        return this.vertex;
    }

    public int getEdge() {
        return this.edge;
    }


    public void addEdge(int from, int to) {
        if (!this.hasEdge(from, to)) {
            this.list.get(from).add(to);
            if (!this.isDir)
                this.list.get(to).add(from);
            this.edge++;
        }
    }

    private boolean hasEdge(int from, int to) {
        for (int each : this.list.get(from))
            if (each == to)
                return true;
        return false;
    }

    public Iterable<Integer> adj(int v) {
        return this.list.get(v);
    }
}