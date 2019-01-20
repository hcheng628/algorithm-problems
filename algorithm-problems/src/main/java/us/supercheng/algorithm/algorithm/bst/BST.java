package us.supercheng.algorithm.algorithm.bst;

import us.supercheng.algorithm.common.entity.Node;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST<Key extends Comparable, Value> {

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(Key k) {
        return false;
    }

    public Value search(Key key) {
        return this.search(this.root, key);
    }

    public void insert(Key k, Value v) {
        this.root = this.insert(this.root, k, v);
    }

    public List<Value> preOrder() {
        List<Value> ret = new ArrayList<>();
        this.preOrder(this.root, ret);
        return ret;    }

    public List<Value> inOrder() {
        List<Value> ret = new ArrayList<>();
        this.inOrder(this.root, ret);
        return ret;
    }

    public List<Value> postOrder() {
        List<Value> ret = new ArrayList<>();
        this.postOrder(this.root, ret);
        return ret;
    }

    public List<Value> levelOrder() {
        List<Value> ret = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        if(this.size != 0)
            queue.add(this.root);

        while(!queue.isEmpty()) {
            Node<Key, Value> each = queue.poll();
            ret.add(each.v);
            if(each.left != null)
                queue.add(each.left);
            if(each.right != null)
                queue.add(each.right);
        }

        return ret;
    }

    public Value getMax() {
        if(this.size == 0)
            return null;
        Node<Key, Value> curr = this.root;
        while(curr.right != null)
            curr = curr.right;
        return curr.v;
    }

    public Value getMin() {
        if(this.size == 0)
            return null;
        Node<Key, Value> curr = this.root;
        while(curr.left != null)
            curr = curr.left;
        return curr.v;
    }

    public Value removeMin() {
        return null;
    }

    public Value removeMax() {
        return null;
    }

    public Value remove(Key key) {
        return null;
    }

    private Node insert(Node node, Key k, Value v) {
        if(node == null) {
            this.size++;
            return new Node(k, v);
        }
        if(k.compareTo(node.k)>0) {
            node.right = this.insert(node.right, k, v);
        } else if (k.compareTo(node.k)<0) {
            node.left = this.insert(node.left, k, v);
        } else {
            node.v = v; // Update based on Key
        }
        return node;
    }

    private Value search(Node<Key, Value> node, Key k) {
        if (node == null)
            return null;
        if (k.compareTo(node.k) > 0)
            return this.search(node.right, k);
        else if (k.compareTo(node.k) < 0)
            return this.search(node.left, k);
        else
            return node.v;
    }

    private void preOrder(Node<Key, Value> node, List<Value> list) {
        if(node == null)
            return;
        list.add(node.v);
        this.preOrder(node.right, list);
        this.preOrder(node.left, list);
    }

    private void inOrder(Node<Key, Value> node, List<Value> list) {
        if(node == null)
            return;
        this.inOrder(node.left, list);
        list.add(node.v);
        this.inOrder(node.right, list);
    }

    private void postOrder(Node<Key, Value> node, List<Value> list) {
        if(node == null)
            return;
        this.postOrder(node.left, list);
        this.postOrder(node.right, list);
        list.add(node.v);
    }



    public static void main(String[] args) {
        int N = 10; //1000000

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
        for(int i = 0 ; i < N ; i ++){
            int pos = (int) (Math.random() * (i+1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
        // 平衡二叉树的实现，我们在这个课程中没有涉及，
        // 有兴趣的同学可以查看资料自学诸如红黑树的实现
        // 以后有机会，我会在别的课程里向大家介绍平衡二叉树的实现的：）


        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串
        BST<Integer,String> bst = new BST<Integer,String>();
        for(int i = 0 ; i < N ; i ++)
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));


        PrintHelper.echoLn("PreOrder: ");
        for(String each : bst.preOrder()) {
            PrintHelper.echo(each + ", ");
        }
        PrintHelper.echoLn("");

        PrintHelper.echoLn("InOrder: ");
        for(String each : bst.inOrder()) {
            PrintHelper.echo(each + ", ");
        }
        PrintHelper.echo("\r\nMin: " + bst.getMin() + " ---  Max: " + bst.getMax() + "\r\n");

        PrintHelper.echoLn("PostOrder: ");
        for(String each : bst.postOrder()) {
            PrintHelper.echo(each + ", ");
        }
        PrintHelper.echoLn("");

        PrintHelper.echoLn("LevelOrder: ");
        for(String each : bst.levelOrder()) {
            PrintHelper.echo(each + ", ");
        }
        PrintHelper.echoLn("");




        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for(int i = 0 ; i < 2*N ; i ++){
            String res = bst.search(new Integer(i));
            if( i < N )
                assert res.equals(Integer.toString(i));
            else
                assert res == null;
        }
    }

}
