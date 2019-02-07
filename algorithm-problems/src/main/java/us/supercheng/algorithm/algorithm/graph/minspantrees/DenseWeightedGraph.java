package us.supercheng.algorithm.algorithm.graph.mimspantrees;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Vector;

public class DenseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int vertex;
    private int edge;
    private boolean isDir;
    private Edge<Weight> [][] g;

    public DenseWeightedGraph(int n, boolean isDir) {
        this.vertex = n;

        this.isDir = isDir;
        this.g = new Edge[n][n];

    }

    @Override
    public int getVertex() {
        return this.vertex;
    }

    @Override
    public int getEdge() {
        return this.edge;
    }

    @Override
    public void addEdge(Edge e) {
        if (!this.hasEdge(e.getA(), e.getB())) {
            this.g[e.getA()][e.getB()] = new Edge(e.getA(), e.getB(), e.getWeight());
            if (!this.isDir && e.getA() != e.getB())
                this.g[e.getB()][e.getA()] = new Edge(e.getB(), e.getA(), e.getWeight());
            this.edge++;
        }
    }

    @Override
    public boolean hasEdge(int from, int to) {
        return this.g[from][to] != null;
    }

    @Override
    public Iterable<Edge> adj(int vertex) {
        Vector<Edge> ret = new Vector<>();
        for (int i=0;i<this.g[vertex].length;i++) {
            if (this.g[vertex][i] != null) {
                ret.add(this.g[vertex][i]);
            }
        }
        return ret;
    }


    @Override
    public void show() {
        for (int i=0;i<this.g.length;i++) {
            for (int j=0;j<this.g[i].length;j++) {
                PrintHelper.echo(this.g[i][j] == null ? "NULL\t" : this.g[i][j].getWeight() + "\t");
            }
            PrintHelper.echoLn("");
        }
    }
}