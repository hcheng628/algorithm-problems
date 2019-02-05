package us.supercheng.algorithm.algorithm.graph.mimspantrees;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class Main {

    public static void main(String[] args) {

        String filePrefix = "src/main/resources/graph/basic/",
                testGW1 = "testGW1.bak";


        String filename = "testG1.txt";
        SparseWeightedGraph<Double> sparseWeightedGraph = new SparseWeightedGraph<Double>(8, false);
        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(sparseWeightedGraph, filePrefix+testGW1);
        PrintHelper.echoLn("test G1 in Sparse Weighted Graph:");
        sparseWeightedGraph.show();

        PrintHelper.echoLn("\r\n**********\r\n");

        DenseWeightedGraph<Double> denseWeightedGraph = new DenseWeightedGraph<Double>(8, false);
        readWeightedGraph = new ReadWeightedGraph(denseWeightedGraph , filePrefix+testGW1 );
        PrintHelper.echoLn("test G1 in Dense Graph:");
        denseWeightedGraph.show();
    }

}