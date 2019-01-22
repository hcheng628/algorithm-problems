package us.supercheng.algorithm.algorithm.bst;

import us.supercheng.algorithm.common.entity.Node;
import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST<Key extends Comparable, Value> {

    private Node<Key, Value> root;
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
        return this.search(this.root, k) != null;
    }

    public Value search(Key key) {
        Node<Key, Value> ret = this.search(this.root, key);
        return ret == null ? null : ret.v;
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
//        Node<Key, Value> curr = this.root;
//        while(curr.right != null)
//            curr = curr.right;
//        return curr.v;
        return this.getMax(this.root).v;
    }

    public Value getMin() {
        if(this.size == 0)
            return null;
//        Node<Key, Value> curr = this.root;
//        while(curr.left != null)
//            curr = curr.left;
//        return curr.v;
        return this.getMin(this.root).v;
    }

    public Value removeMin() {
        if(this.size == 0)
            return null;
        Value ret = this.getMin();
        this.root = this.removeMin(this.root);
        return ret;
    }

    public Value removeMax() {
        if(this.size == 0)
            return null;
        Value ret = this.getMax();
        this.root = this.removeMax(this.root);
        return ret;
    }

    public Value remove(Key key) {
        if(this.size == 0)
            return null;

        Value ret = this.search(key);
        if(ret == null)
            return null;
        this.root = this.remove(this.root, key);
        return ret;
    }

    private Node insert(Node node, Key k, Value v) {
        if(node == null) {
            this.size++;
            return new Node(k, v);
        }

        if(k.compareTo(node.k)>0)
            node.right = this.insert(node.right, k, v);
        else if (k.compareTo(node.k)<0)
            node.left = this.insert(node.left, k, v);
        else
            node.v = v; // Update based on Key
        return node;
    }

    private Node<Key, Value> search(Node<Key, Value> node, Key k) {
        if (node == null)
            return null;

        if (k.compareTo(node.k) > 0)
            return this.search(node.right, k);
        else if (k.compareTo(node.k) < 0)
            return this.search(node.left, k);
        else
            return node;
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

    private Node<Key, Value> getMin(Node<Key, Value> node) {
        if(node.left == null)
            return node;
        return this.getMin(node.left);
    }

    private Node<Key, Value> getMax(Node<Key, Value> node) {
        if(node.right == null)
            return node;
        return this.getMax(node.right);
    }

    private void postOrder(Node<Key, Value> node, List<Value> list) {
        if(node == null)
            return;
        this.postOrder(node.left, list);
        this.postOrder(node.right, list);
        list.add(node.v);
    }

    private Node<Key, Value> removeMin(Node<Key, Value> node) {
        if(node.left == null) {
            this.size--;
            if(node.right != null)
                return node.right;
            node.right = null;
            return null;
        }
        node.left = this.removeMin(node.left);
        return node;
    }

    private Node<Key, Value> removeMax(Node<Key, Value> node) {
        if(node.right == null) {
            Node leftNode = node.left;
            this.size--;
            node.left = null;
            return leftNode;
        }
        node.right = this.removeMax(node.right);
        return node;
    }

    private Node<Key, Value> remove(Node<Key, Value> node, Key key) {
        if(key.compareTo(node.k) < 0) {
            node.left = this.remove(node.left, key);
            return node;
        } else if(key.compareTo(node.k) > 0) {
            node.right = this.remove(node.right, key);
            return node;
        } else {
            this.size--;
            if(node.right == null) {
                Node ret = node.left;
                node.left = null;
                return ret;
            } else if (node.left == null) {
                Node ret = node.right;
                node.right = null;
                return ret;
            } else {
                Node rightMin = this.getMin(node.right),
                     ret = new Node(rightMin.k, rightMin.v);
                ret.right = this.removeMin(node.right);
                ret.left = node.left;
                this.size++;
                node.left = node.right = null;
                return ret;
            }
        }
    }

    public Value floor(Key key) {
        if(this.size == 0 || key.compareTo(this.getMin(this.root).k) < 0)
            return null;
        Node<Key, Value> ret = this.floor(this.root, key);
        return ret == null ? null : ret.v;
    }

    private Node<Key, Value> floor(Node<Key, Value> node, Key key) {
        if(node == null || key.compareTo(node.k) == 0)
            return node;
        else if (key.compareTo(node.k) < 0)
            return this.floor(node.left, key);
        Node maxFloor = this.floor(node.right, key);
        return maxFloor != null ? maxFloor : node;
    }

    public Value ceil(Key key) {
        if(this.size == 0 || key.compareTo(this.getMax(this.root).k) > 0)
            return null;
        Node<Key, Value> ret = this.ceil(this.root, key);
        return ret == null ? null : ret.v;
    }

    private Node<Key, Value> ceil(Node<Key, Value> node, Key key) {
        if(node == null || key.compareTo(node.k) == 0)
            return node;
        else if (key.compareTo(node.k) > 0)
            return this.ceil(node.right, key);
        Node minCeil = this.ceil(node.left, key);
        return minCeil != null ? minCeil : node;
    }

    public static void main(String[] args) {
        int N = 100; //1000000

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

        PrintHelper.echoLn("Search: " + bst.search(10));


        PrintHelper.echoLn("Deleting......");
        for(int i=0;i<5;i++) {
            bst.removeMin();
            PrintHelper.echoLn("LevelOrder: size: " + bst.size());
            for(String each : bst.inOrder()) {
                PrintHelper.echo(each + ", ");
            }
            PrintHelper.echoLn("");
        }

        for(int i=0;i<5;i++) {
            bst.removeMax();
            PrintHelper.echoLn("LevelOrder: size: " + bst.size());
            for(String each : bst.inOrder()) {
                PrintHelper.echo(each + ", ");
            }
            PrintHelper.echoLn("");
        }

        PrintHelper.echoLn("Del 1.....");
        bst.remove(1);
        PrintHelper.echoLn("LevelOrder: size: " + bst.size());
        for(String each : bst.inOrder()) {
            PrintHelper.echo(each + ", ");
        }
        PrintHelper.echoLn("");

        PrintHelper.echoLn("Del 3.....");
        bst.remove(3);
        PrintHelper.echoLn("LevelOrder: size: " + bst.size());
        for(String each : bst.inOrder()) {
            PrintHelper.echo(each + ", ");
        }
        PrintHelper.echoLn("");


        PrintHelper.echoLn("Del 5.....");
        bst.remove(5);
        PrintHelper.echoLn("LevelOrder: size: " + bst.size());
        for(String each : bst.inOrder()) {
            PrintHelper.echo(each + ", ");
        }
        PrintHelper.echoLn("");

        PrintHelper.echoLn("Del 2.....");
        bst.remove(2);
        PrintHelper.echoLn("LevelOrder: size: " + bst.size());
        for(String each : bst.inOrder()) {
            PrintHelper.echo(each + ", ");
        }
        PrintHelper.echoLn("");

        PrintHelper.echoLn("Del 4.....");
        bst.remove(4);
        PrintHelper.echoLn("LevelOrder: size: " + bst.size());
        for(String each : bst.inOrder()) {
            PrintHelper.echo(each + ", ");
        }
        PrintHelper.echoLn("");

        PrintHelper.echoLn("Del 6.....");
        bst.remove(6);
        PrintHelper.echoLn("LevelOrder: size: " + bst.size());
        for(String each : bst.inOrder()) {
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

        bst = new BST<>();

        int a = 5,
                b = 2,
                c =18,
                d = -4,
                e = 3,
                f = 18,
                g = 21,
                h = 19,
                i = 25;

        bst.insert(a,a+"");
        bst.insert(b,b+"");
        bst.insert(c,c+"");
        bst.insert(d,d+"");
        bst.insert(e,e+"");
        bst.insert(f,f+"");
        bst.insert(g,g+"");
        bst.insert(h,h+"");
        bst.insert(i,i+"");

        PrintHelper.echoLn("Floor 4: " + bst.floor(4));
        PrintHelper.echoLn("Ceil 4: " + bst.ceil(4));



    }
}