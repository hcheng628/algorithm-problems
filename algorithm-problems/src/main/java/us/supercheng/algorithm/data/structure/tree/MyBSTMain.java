package us.supercheng.algorithm.data.structure.tree;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class MyBSTMain {

    public static void main(String [] args) {
        MyBST<Integer> tree = new MyBST<>();

        PrintHelper.echoLn("Empty Tree? " + tree.isEmpty());
        tree.add(3);
        PrintHelper.echoLn("Empty Tree? " + tree.isEmpty());
        tree.add(4);
        PrintHelper.echoLn("Tree Size: " + tree.size());
        tree.add(5);
        PrintHelper.echoLn("Tree Size: " + tree.size());


        PrintHelper.echoLn("Contains 3: " + tree.contains(3));
        PrintHelper.echoLn("Contains 4: " + tree.contains(4));
        PrintHelper.echoLn("Contains 5: " + tree.contains(5));

        tree.test();
    }

}