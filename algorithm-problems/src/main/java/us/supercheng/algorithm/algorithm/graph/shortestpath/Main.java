package us.supercheng.algorithm.algorithm.graph.shortestpath;

import us.supercheng.algorithm.algorithm.graph.common.ReadWeightedGraph;
import us.supercheng.algorithm.algorithm.graph.common.SparseWeightedGraph;
import us.supercheng.algorithm.common.helper.PrintHelper;

public class Main {
    public static void main(String[] args) {

        String filePrefix = "src/main/resources/graph/shortestpath/";
        String testSP1 = "testSP1.bak", testSPN1 = "testSPN1.bak", testSPN2 = "testSPN2.bak";
        int V = 5;

        SparseWeightedGraph<Integer> g = new SparseWeightedGraph<Integer>(V, true);
        // Dijkstra最短路径算法同样适用于有向图
        //SparseGraph<int> g = SparseGraph<int>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filePrefix+testSP1);

        PrintHelper.echoLn("Test Dijkstra:\n");
        Dijkstra<Integer> dij = new Dijkstra<Integer>(g,0);
        for (int i = 1 ; i < V ; i ++ ) {
            if(dij.hasPathTo(i)) {
                PrintHelper.echoLn("Shortest Path to " + i + " : " + dij.shortestPathTo(i));
                dij.showPath(i);
            } else
                PrintHelper.echoLn("No Path to " + i );
            PrintHelper.echoLn("----------------------------------------\r\n");
        }

        g = new SparseWeightedGraph<>(V, true);
        readGraph = new ReadWeightedGraph(g, filePrefix+testSPN1);

        PrintHelper.echoLn("Test Bellman-Ford:\n");
        BellmanFord<Integer> bellmanFord = new BellmanFord<Integer>(g, 0);
        if(bellmanFord.isHasNegativeCycle())
            PrintHelper.echoLn("The graph contain negative cycle!");
        else
            for (int i = 0 ; i < V ; i ++ ) {
                if(i == 0)
                    continue;
                if(bellmanFord.hasPathTo(i)) {
                    PrintHelper.echoLn("Shortest Path to " + i + " : " + bellmanFord.shortestPathTo(i));
                    bellmanFord.showPath(i);
                } else
                    PrintHelper.echoLn("No Path to " + i );
                PrintHelper.echoLn("----------------------------------------\r\n");
            }
    }
}