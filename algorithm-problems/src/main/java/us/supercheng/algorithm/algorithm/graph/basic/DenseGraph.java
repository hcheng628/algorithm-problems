package us.supercheng.algorithm.algorithm.graph.basic;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.ArrayList;
import java.util.List;

public class DenseGraph implements Graph{

    private int vertex;
    private int edge;
    private boolean [][] mat;
    private boolean isDir;

    public DenseGraph(int vertex, boolean isDir) {
        this.vertex = vertex;
        this.isDir = isDir;
        this.mat = new boolean[vertex][vertex];
    }

    public int getVertex() {
        return this.vertex;
    }

    public int getEdge() {
        return this.edge;
    }

    public void addEdge(int from, int to) {
        if (!this.hasEdge(from, to)) {
            this.mat[from][to] = true;
            if (!this.isDir) {
                this.mat[to][from] = true;
            }
            this.edge++;
        }
    }

    public boolean hasEdge(int from, int to) {
        if (this.isDir) {
            return this.mat[from][to];
        } else {
            return this.mat[from][to] && this.mat[to][from];
        }
    }

    public Iterable<Integer> adj(int v) {
        List<Integer> ret = new ArrayList<>();
        for(int i=0;i<this.edge;i++)
            if (this.mat[v][i])
                ret.add(i);
        return ret;
    }

    @Override
    public void show() {
        for (boolean[] row : this.mat) {
            for (int i=0;i<row.length;i++)
                PrintHelper.echo(i == row.length-1 ? row[i] : row[i] + "\t");
            PrintHelper.echoLn("");
        }
    }
}