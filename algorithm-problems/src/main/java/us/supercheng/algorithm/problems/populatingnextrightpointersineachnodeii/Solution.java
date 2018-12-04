package us.supercheng.algorithm.problems.populatingnextrightpointersineachnodeii;

import us.supercheng.algorithm.common.entity.TreeLinkNode;
import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        // {1,2,3,4,#,#,5}
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        Solution app = new Solution();
        app.connect2(t1);
        app.printer(t1);
    }

    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        this.attachNext(root.left, root.right);
        this.attachNext(root.right, root.next);
    }

    private void attachNext(TreeLinkNode node, TreeLinkNode next) {
        if(node == null)
            return;
        node.next = next;

        PrintHelper.echoLn(node.val + " next: " + (node.next == null ? "null" : node.next.val));

        if(node.left != null && node.right != null) {
            this.attachNext(node.left, node.right);
        } else if (node.left ==null && node.right != null) {
            while(next != null) {
                if(next.left != null) {
                    this.attachNext(node.right, next.left);
                    break;
                }
                if(next.right != null) {
                    this.attachNext(node.right, next.left);
                    break;
                }
                next = next.next;
            }

        } else if (node.left != null && node.right == null) {
            while(next != null) {
                if(next.left != null) {
                    this.attachNext(node.left, next.left);
                }
                if(next.right != null) {
                    this.attachNext(node.right, next.right);
                }
                next = next.next;
            }
        }
    }

    public void connect2(TreeLinkNode root) {
        if(root == null)
            return;

        Queue<TreeLinkNode> queue = new LinkedList();
        queue.add(root);
        root.next = null;

        TreeLinkNode prev = null;

        for(;!queue.isEmpty();prev = null) {
            Queue<TreeLinkNode> tempQueue = new LinkedList();
            while(!queue.isEmpty()) {
                TreeLinkNode node = queue.poll();
                if(prev != null)
                    prev.next = node;
                if(node != null) {
                    if(tempQueue.isEmpty())
                        node.next = null;
                    if(node.left != null)
                        tempQueue.add(node.left);
                    if(node.right != null)
                        tempQueue.add(node.right);
                }
                prev = node;
            }
            queue = tempQueue;
        }
    }


    private void printer(TreeLinkNode tree) {
        if(tree == null)
            return;
        PrintHelper.echoLn(tree.val + "->" + (tree.next == null ? "null" : tree.next.val));
        this.printer(tree.left);
        this.printer(tree.right);
    }
}
