package us.supercheng.algorithm.algorithm.graph.minspantrees;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        String filePrefix = "src/main/resources/graph/basic/",
                testGW1 = "testGW1.bak";

        SparseWeightedGraph<Double> sparseWeightedGraph = new SparseWeightedGraph<Double>(8, false);
        ReadWeightedGraph readWeightedGraph = new ReadWeightedGraph(sparseWeightedGraph, filePrefix+testGW1);
        PrintHelper.echoLn("test G1 in Sparse Weighted Graph:");
        sparseWeightedGraph.show();

        PrintHelper.echoLn("\r\n**********\r\n");

        DenseWeightedGraph<Double> denseWeightedGraph = new DenseWeightedGraph<Double>(8, false);
        readWeightedGraph = new ReadWeightedGraph(denseWeightedGraph , filePrefix+testGW1 );
        PrintHelper.echoLn("test G1 in Dense Graph:");
        denseWeightedGraph.show();
        PrintHelper.echoLn("\r\n**********\r\n");

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(8, false);
        readWeightedGraph = new ReadWeightedGraph(g, filePrefix+testGW1);
        PrintHelper.echoLn("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g);
        Vector<Edge<Double>> mst = lazyPrimMST.getEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            PrintHelper.echoLn(mst.elementAt(i));
        PrintHelper.echoLn("The MST weight is: " + lazyPrimMST.result());
        PrintHelper.echoLn("\r\n**********\r\n");

        g = new SparseWeightedGraph<Double>(8, false);
        readWeightedGraph = new ReadWeightedGraph(g, filePrefix+testGW1);
        PrintHelper.echoLn("Test Prim MST:");
        PrimMST<Double> primMST = new PrimMST<Double>(g);
        mst = lazyPrimMST.getEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            PrintHelper.echoLn(mst.elementAt(i));
        PrintHelper.echoLn("The MST weight is: " + lazyPrimMST.result());
    }
}