package us.supercheng.algorithm.algorithm.graph.basic;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class Main {
    public static void main(String[] args) {
        String filePrefix = "src/main/resources/graph/basic/",
               testG = "testG.bak",
               testG1 = "testG1.bak",
               testG2 = "testG2.bak";

        int V6 = 6, V13 = 13;
        boolean isDir = false;
//        SparseGraph sparseGraph = new SparseGraph(V13, isDir);
//        ReadGraph readGraph = new ReadGraph(sparseGraph, filePrefix+testG1);
//        sparseGraph.show();
//        PrintHelper.echoLn("******************************************************************************************");
//        DenseGraph denseGraph = new DenseGraph(V13, isDir);
//        readGraph = new ReadGraph(denseGraph, filePrefix+testG1);
//        denseGraph.show();
//        PrintHelper.echoLn("******************************************************************************************");
//
//        sparseGraph = new SparseGraph(V6, isDir);
//        readGraph = new ReadGraph(sparseGraph, filePrefix+testG2);
//        sparseGraph.show();
//        PrintHelper.echoLn("******************************************************************************************");
//
//        denseGraph = new DenseGraph(V6, isDir);
//        readGraph = new ReadGraph(denseGraph, filePrefix+testG2);
//        denseGraph.show();
//        PrintHelper.echoLn("******************************************************************************************");
//
//
//        sparseGraph = new SparseGraph(V13, false);
//        readGraph = new ReadGraph(sparseGraph, filePrefix+testG1);
//        Components component = new Components(sparseGraph);
//        PrintHelper.echoLn("TestG1.txt, Component Count: " + component.getCCount());
//        sparseGraph = new SparseGraph(V6, false);
//        ReadGraph readGraph2 = new ReadGraph(sparseGraph, filePrefix+testG2);
//        component = new Components(sparseGraph);
//        PrintHelper.echoLn("TestG2.txt, Component Count: " + component.getCCount());


        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filePrefix+testG);
        g.show();
        PrintHelper.echoLn("");
        Path path = new Path(g,0);
        PrintHelper.echoLn("Path from 0 to 6 : ");
        path.echoPath(4);
    }
}