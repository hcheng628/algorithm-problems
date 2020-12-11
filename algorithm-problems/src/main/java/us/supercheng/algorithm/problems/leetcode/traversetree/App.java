package us.supercheng.algorithm.problems.leetcode.traversetree;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        /*
        app.echoln("Preorder (Root, Left, Right)");
        app.printPreOrder(app.createTree());
        app.echoln("\r\nInorder (Left, Root, Right)");
        app.printInOrder(app.createTree());
        app.echoln("\r\nPostorder (Left, Right, Root)");
        app.printPostOrder(app.createTree());
        */

        String preOrder1 = "ABDEGCF";
        String inOrder1 = "DBGEACF";


        app.echoln(">>>>>>");
        TreeNode treeRoot = app.createTree(preOrder1, inOrder1);
        app.echoln("PostOrder (Root, Left, Right)");
        app.printPostOrder(treeRoot);

        app.echoln("\r\n>>>>>>");
        String postOrder = app.getPostFromPreAndInOrder(preOrder1, inOrder1);
        app.echoln("PostOrder getPostFromPreAndInOrder: \r\n" + postOrder);

    }

    private TreeNode createTree() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);
        e.setLeft(g);
        return a;
    }

    // A B D E G C F
    // Preorder (Root, Left, Right)
    private void printPreOrder(TreeNode rootNode) {
        if (rootNode == null)
            return;
        echo(rootNode.getVal()+"");
        printPreOrder(rootNode.getLeft());
        printPreOrder(rootNode.getRight());
    }

    // D B G E A C F
    // Inorder (Left, Root, Right)
    private void printInOrder(TreeNode rootNode) {
        if (rootNode == null)
            return;
        printInOrder(rootNode.getLeft());
        echo(rootNode.getVal()+"");
        printInOrder(rootNode.getRight());
    }

    // D G E B F C A
    // Postorder (Left, Right, Root)
    private void printPostOrder(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        printPostOrder(rootNode.getLeft());
        printPostOrder(rootNode.getRight());
        echo(rootNode.getVal()+"");
    }
    // Pre: A B D E G C F    In: D B G E A C F
    public TreeNode createTree(String preOrder, String inOrder) {
        if(preOrder.isEmpty()) {
            return null;
        }
        char currentRoot = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(currentRoot);
        TreeNode root = new TreeNode(Integer.parseInt(currentRoot+""));
        root.setLeft(createTree(preOrder.substring(1,rootIndex + 1), inOrder.substring(0, rootIndex)));
        root.setRight(createTree(preOrder.substring(rootIndex+1),inOrder.substring(rootIndex + 1)));
        return root;
    }

    // Pre: Root Left Right
    // In: Left Root Right
    // Post: Left Right Root
    public String getPostFromPreAndInOrder(String preOrder, String inOrder) {
        if(preOrder.isEmpty()) {
            return  "";
        }
        char root = preOrder.charAt(0);
        int rootIndex = inOrder.indexOf(root);
        return getPostFromPreAndInOrder(preOrder.substring(1, rootIndex + 1), inOrder.substring(0,rootIndex))
            + getPostFromPreAndInOrder(preOrder.substring(rootIndex+1), inOrder.substring(rootIndex + 1))
            + root;
    }


    private void echo(String s) {
        System.out.print(s);
    }

    private void echoln(String s) {
        System.out.println(s);
    }
}