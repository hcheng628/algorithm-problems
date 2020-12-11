package us.supercheng.algorithm.problems.leetcode.createlinkedlist;

import us.supercheng.algorithm.common.entity.IntNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        IntNode n = new IntNode();
        n.setVal(5);
        IntNode intNode = app.createLinkedList(Arrays.asList(1,2,3,4,5,6));


        n.printList(intNode);
        n.printList(app.createLinkedList(Arrays.asList(1)));
        n.printList(app.createLinkedList(new ArrayList<Integer>()));
    }

    public IntNode createLinkedList(List<Integer> intList) {
        if(intList.isEmpty()) {
            return null;
        }
        IntNode node = new IntNode();
        node.setVal(intList.get(0));
        node.setNode(createLinkedList(intList.subList(1, intList.size())));
        return node;
    }
}