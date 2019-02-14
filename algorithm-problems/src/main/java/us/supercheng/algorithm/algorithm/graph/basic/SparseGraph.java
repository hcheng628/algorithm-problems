package us.supercheng.algorithm.algorithm.graph.basic;

import us.supercheng.algorithm.algorithm.graph.common.Graph;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.List;

public class SparseGraph implements Graph {

    private int vertex;
    private int edge;
    private List<List<Integer>> list;
    private boolean isDir;

    public SparseGraph(int vertex, boolean isDir) {
        this.vertex = vertex;
        this.isDir = isDir;

        this.list = new ArrayList<>();
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

    public boolean hasEdge(int from, int to) {
        for (int each : this.list.get(from))
            if (each == to)
                return true;
        return false;
    }

    public Iterable<Integer> adj(int v) {
        return this.list.get(v);
    }

    @Override
    public void show() {
        for(int i=0;i<this.list.size();i++) {
            PrintHelper.echo("V: " + i + "\t");
            for (int j=0;j<this.list.get(i).size();j++)
                PrintHelper.echo(j == this.list.get(i).size()-1 ? this.list.get(i).get(j) : this.list.get(i).get(j) + ", ");
            PrintHelper.echoLn("");
        }
    }
}