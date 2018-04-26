package us.supercheng.algorithm.problems.reverselinkedlist;

import us.supercheng.algorithm.common.entity.IntNode;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        IntNode node = app.createLinkedList(5);
        IntNode.printList(node);
        node = app.reverseLinkedListRec(node);
        IntNode.printList(node);
    }

    public IntNode reverseLinkedList(IntNode intNode) {
        IntNode next;
        IntNode prev = null;
        while(intNode != null) {
            next = intNode.getNode();
            intNode.setNode(prev);
            prev = intNode;
            intNode = next;
        }
        return prev;
    }

    public IntNode reverseLinkedListRec(IntNode head) {
        if(head == null || head.getNode() == null) {
            return head;
        }
        IntNode newHead = reverseLinkedListRec(head.getNode());
        head.getNode().setNode(head);
        head.setNode(null);
        return newHead;
    }

    public IntNode createLinkedList(int num) {
        IntNode returnHead = new IntNode(0);
        IntNode prev = returnHead;
        for(int i=1; i <= num ; i++) {
            IntNode newHead = new IntNode(i);
            prev.setNode(newHead);
            prev = newHead;
        }
        return returnHead.getNode();
    }
}