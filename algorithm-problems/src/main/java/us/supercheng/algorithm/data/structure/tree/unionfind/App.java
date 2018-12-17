package us.supercheng.algorithm.data.structure.tree.unionfind;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Random;

public class App {

    public static void main(String [] args ) {
        int size = 1000000;
        UF1 uf1 = new UF1(size);
        UF2 uf2 = new UF2(size);
        UF3 uf3 = new UF3(size);
        UF4 uf4 = new UF4(size);
        UF5 uf5 = new UF5(size);


        PrintHelper.echoLn("Union Find 1 -> Time Spent: " + runTest(uf1, 0));
        PrintHelper.echoLn("Union Find 2 -> Time Spent: " + runTest(uf2, size));
        PrintHelper.echoLn("Union Find 3 -> Time Spent: " + runTest(uf3, size));
        PrintHelper.echoLn("Union Find 4 -> Time Spent: " + runTest(uf4, size));
        PrintHelper.echoLn("Union Find 5 -> Time Spent: " + runTest(uf5, size));

    }

    public static double runTest(UnionFind uf, int operations) {
        int size = uf.getSize();
        Random random = new Random();
        long startT = System.nanoTime();

        for(int i=0;i<operations;i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for(int i=0;i<operations;i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endT = System.nanoTime();
        return (endT - startT) / 100000000.0;
    }
}