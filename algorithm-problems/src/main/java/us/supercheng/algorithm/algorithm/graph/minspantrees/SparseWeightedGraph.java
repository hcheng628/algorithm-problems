package us.supercheng.algorithm.algorithm.graph.minspantrees;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Vector;

public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {

    private int vertex;
    private int edge;
    private boolean isDir;
    private Vector<Vector<Edge<Weight>>> g;


    public SparseWeightedGraph(int n, boolean isDir) {
        this.vertex = n;
        this.isDir = isDir;

        this.g = new Vector<>();
        for (int i=0;i<n;i++)
            g.add(new Vector<>());
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
            this.g.get(e.getA()).add(new Edge(e.getA(), e.getB(), e.getWeight()));
            if (!this.isDir && e.getA() != e.getB())
                this.g.get(e.getB()).add(new Edge(e.getB(), e.getA(), e.getWeight()));
            this.edge++;
        }
    }

    @Override
    public boolean hasEdge(int from, int to) {
        for (Edge each : this.g.get(from)) {
            if (each.getB() == to)
                return true;
        }
        return false;
    }

    @Override
    public Iterable<Edge> adj(int vertex) {
        Vector<Edge> ret = new Vector<>();
        for (Edge each : this.g.get(vertex)) {
            ret.add(each);
        }
        return ret;
    }

    @Override
    public void show() {
        for (int i=0;i<this.g.size();i++) {
            PrintHelper.echo("vertex " + i + ":\t");
            for (Edge<Weight> each : this.g.get(i))
                PrintHelper.echo("(to: " + each.other(i) + ", weight: " + each.getWeight() + ")\t");
            PrintHelper.echoLn("");
        }
    }
}
