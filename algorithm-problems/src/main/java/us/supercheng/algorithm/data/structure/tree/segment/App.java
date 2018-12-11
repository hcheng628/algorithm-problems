package us.supercheng.algorithm.data.structure.tree.segment;

public class App {

    public static void main(String[] args) {
        Integer [] arr = {1,2,3,4,5,6,7,8,9, 10};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(arr, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        segmentTree.echo();
    }
}
