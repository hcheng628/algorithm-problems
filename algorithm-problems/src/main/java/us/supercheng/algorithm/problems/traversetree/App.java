package us.supercheng.algorithm.problems.traversetree;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        app.echoln("Preorder (Root, Left, Right)");
        app.printPreOrder(app.createTree());
        app.echoln("\r\nInorder (Left, Root, Right)");
        app.printInOrder(app.createTree());
        app.echoln("\r\nPostorder (Left, Right, Root)");
        app.printPostOrder(app.createTree());
    }

    private TreeNode createTree() {
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        TreeNode g = new TreeNode("G");
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
        echo(rootNode.getVal());
        printPreOrder(rootNode.getLeft());
        printPreOrder(rootNode.getRight());
    }

    // D B G E A C F
    // Inorder (Left, Root, Right)
    private void printInOrder(TreeNode rootNode) {
        if (rootNode == null)
            return;
        printInOrder(rootNode.getLeft());
        echo(rootNode.getVal());
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
        echo(rootNode.getVal());
    }

    private void echo(String s) {
        System.out.print(s);
    }

    private void echoln(String s) {
        System.out.println(s);
    }
}