package us.supercheng.algorithm.data.structure.tree.segment;

import us.supercheng.algorithm.common.helper.PrintHelper;
import us.supercheng.algorithm.common.helper.ThreadHelper;

public class App {

    public static void main(String[] args) {
        Integer [] arr = {1,2,3,4,5,6,7,8,9,10};

        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });

        segmentTree.echo();
        ThreadHelper.sleep(5);

        Integer res = segmentTree.getRange(0,7);
        PrintHelper.echoLn("\r\nres: " + res);
        ThreadHelper.sleep(5);

        segmentTree.setRange(9, 100);
        segmentTree.echo();

        res = segmentTree.getRange(0,7);
        PrintHelper.echoLn("\r\nres: " + res);
        ThreadHelper.sleep(5);

        res = segmentTree.getRange(5,9);
        PrintHelper.echoLn("\r\nres: " + res);
    }
};