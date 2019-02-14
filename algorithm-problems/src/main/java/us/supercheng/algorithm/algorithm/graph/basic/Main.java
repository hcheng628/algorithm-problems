package us.supercheng.algorithm.algorithm.graph.basic;

import us.supercheng.algorithm.algorithm.graph.common.ReadGraph;
import us.supercheng.algorithm.common.helper.PrintHelper;

public class Main {
    public static void main(String[] args) {
        String filePrefix = "src/main/resources/graph/basic/",
               testG = "testG.bak",
               testG1 = "testG1.bak",
               testG2 = "testG2.bak";

        int V6 = 6, V13 = 13;
        boolean isDir = false;
        SparseGraph sparseGraph = new SparseGraph(V13, isDir);
        ReadGraph readGraph = new ReadGraph(sparseGraph, filePrefix+testG1);
        sparseGraph.show();
        PrintHelper.echoLn("******************************************************************************************");
        DenseGraph denseGraph = new DenseGraph(V13, isDir);
        readGraph = new ReadGraph(denseGraph, filePrefix+testG1);
        denseGraph.show();
        PrintHelper.echoLn("******************************************************************************************");

        sparseGraph = new SparseGraph(V6, isDir);
        readGraph = new ReadGraph(sparseGraph, filePrefix+testG2);
        sparseGraph.show();
        PrintHelper.echoLn("******************************************************************************************");

        denseGraph = new DenseGraph(V6, isDir);
        readGraph = new ReadGraph(denseGraph, filePrefix+testG2);
        denseGraph.show();
        PrintHelper.echoLn("******************************************************************************************");


        sparseGraph = new SparseGraph(V13, false);
        readGraph = new ReadGraph(sparseGraph, filePrefix+testG1);
        Components component = new Components(sparseGraph);
        PrintHelper.echoLn("TestG1.txt, Component Count: " + component.getCCount());
        sparseGraph = new SparseGraph(V6, false);
        ReadGraph readGraph2 = new ReadGraph(sparseGraph, filePrefix+testG2);
        component = new Components(sparseGraph);
        PrintHelper.echoLn("TestG2.txt, Component Count: " + component.getCCount());

        sparseGraph= new SparseGraph(7, false);
        readGraph = new ReadGraph(sparseGraph, filePrefix+testG);
        sparseGraph.show();
        PrintHelper.echoLn("");
        Path path = new Path(sparseGraph,0);
        PrintHelper.echoLn("Path from 0 to 6 : ");
        path.echoPath(4);

        sparseGraph = new SparseGraph(7, false);
        readGraph = new ReadGraph(sparseGraph, filePrefix+testG);
        sparseGraph.show();
        Path dfs = new Path(sparseGraph,0);
        PrintHelper.echoLn("DFS: ");
        dfs.echoPath(6);
        ShortestPath bfs = new ShortestPath(sparseGraph,0);
        PrintHelper.echoLn("BFS: ");
        bfs.echoPath(6);
        PrintHelper.echoLn("******************************************************************************************");

        sparseGraph = new SparseGraph(13, false);
        readGraph = new ReadGraph(sparseGraph, filePrefix+testG1);
        sparseGraph.show();
        dfs = new Path(sparseGraph,0);
        PrintHelper.echoLn("DFS: ");
        dfs.echoPath(3);
        bfs = new ShortestPath(sparseGraph,0);
        PrintHelper.echoLn("BFS: ");
        bfs.echoPath(3);
    }
}