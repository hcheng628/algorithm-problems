package us.supercheng.algorithm.problems.algo.nodedepths;

import java.util.*;

public class Program {

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static int nodeDepths_Solution1(BinaryTree root) {
        return nodeDepths_Solution1(root, 0);
    }

    private static int nodeDepths_Solution1(BinaryTree root, int curr) {
        return root == null ? 0 :
                curr + nodeDepths_Solution1(root.left, curr + 1) + nodeDepths_Solution1(root.right, curr + 1);
    }

    public static int nodeDepths_Solution2(BinaryTree root) {
        int ret = 0;
        Queue<BinaryTree> q = new LinkedList<>();

        if (root != null)
            q.offer(root);

        for (int level=0;!q.isEmpty(); level++)
            for (int i=q.size(); i>0; i--) {
                BinaryTree t = q.poll();
                ret += level;
                if (t.left != null)
                    q.offer(t.left);
                if (t.right != null)
                    q.offer(t.right);
            }

        return ret;
    }

    public static int nodeDepths_Solution3(BinaryTree root) {
        if (root == null)
            return 0;

        int ret = 0;
        Stack<Level> s = new Stack<>();
        s.push(new Level(0, root));

        while (!s.isEmpty()) {
            Level level = s.pop();
            int l = level.l;
            BinaryTree t = level.t;

            ret += l;
            l++;
            if (t.left != null)
                s.push(new Level(l, t.left));
            if (t.right != null)
                s.push(new Level(l, t.right));
        }

        return ret;
    }

    static class Level {
        int l;
        BinaryTree t;

        public Level(int l, BinaryTree t) {
            this.l = l;
            this.t = t;
        }
    }
}
