package us.supercheng.algorithm.problems.algo.rightsmallerthan;

import java.util.*;

public class Program {

    public static List<Integer> rightSmallerThan(List<Integer> array) {
        return bf_approach(array);
    }

    // Time: O(n^2) Space: O(n)
    private static List<Integer> bf_approach(List<Integer> list) {
        List<Integer> ret = new ArrayList<>();

        for (int i=0, len=list.size(); i<len; i++) {
            int count = 0;
            int num = list.get(i);
            for (int j=i+1; j<len; j++)
                if (num > list.get(j))
                    count++;

            ret.add(count);
        }

        return ret;
    }

    // Time: O(n^2) Space: O(n) but Average Time is O(nlog(n))
    private static List<Integer> bst_approach(List<Integer> list) {
        List<Integer> ret = new ArrayList<>();
        int len = list.size();

        Tree t = new Tree(list.get(len - 1));
        ret.add(0);

        for (int i=len - 2; i>-1; i--) {
            ret.add(0, t.getBSTLessCount(list.get(i)));
            t.addNode(list.get(i));
        }

        return ret;
    }

    static class BST {
        BST left;
        BST right;
        int val;
        int lessCount;

        BST (int val) {
            this.val = val;
        }
    }

    static class Tree {
        BST root;

        Tree (int val) {
            this.root = new BST(val);
        }

        void addNode(int newVal) {
            for (BST curr = this.root;curr != null; )
                if (newVal < curr.val) {
                    curr.lessCount += 1;
                    if (curr.left == null) {
                        curr.left = new BST(newVal);
                        return;
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new BST(newVal);
                        return;
                    }
                    curr = curr.right;
                }
        }

        int getBSTLessCount(int val) {
            int ret = 0;

            for (BST curr = this.root; curr != null; )
                if (val > curr.val) {
                    ret += curr.lessCount + 1;
                    curr = curr.right;
                } else
                    curr = curr.left;

            return ret;
        }
    }
}

