package us.supercheng.algorithm.problems.deletenodeinalinkedlist;

import us.supercheng.algorithm.common.entity.ListNode;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.deleteNode(null);
    }

    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) {
            return;
        }
        ListNode last = null;
        while(node.next != null) {
            node.val = node.next.val;
            if(node.next.next == null) {
                last = node;
            }
            node = node.next;
        }
        last.next = null;
    }
}