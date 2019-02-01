package us.supercheng.algorithm.algorithm.graph.basic;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class Components {

    private Graph g;
    private int cCount;
    private boolean [] visited;
    private int [] cIds;

    public Components(Graph g) {
        this.g = g;
        this.visited = new boolean[g.getVertex()];
        this.cIds = new int [g.getVertex()];

        for(int i=0;i<this.cIds.length;i++)
            this.cIds[i] = -1;

        for (int i=0;i<g.getVertex();i++)
            if (!this.visited[i]) {
                dfs(i);
                this.cCount++;
            }
    }

    private void dfs(int vertex) {
        if (this.visited[vertex])
            return;

        this.visited[vertex] = true;
        this.cIds[vertex] = this.cCount;

        for (int eachVertex : this.g.adj(vertex))
            this.dfs(eachVertex);
    }

    public int getCCount() {
        return this.cCount;
    }

    private boolean isConnected(int from, int to) {
        return this.cIds[from] == this.cIds[to];
    }

    public void showComponentsIds() {
        for(int id : this.cIds)
            PrintHelper.echo(id + "\t");
        PrintHelper.echoLn("");
    }
}