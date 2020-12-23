package us.supercheng.algorithm.problems.algo.bstconstruction;

import java.util.*;

public class Program2 {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            this.insert(this, new BST(value));
            return this;
        }

        private void insert(BST root, BST node) {
            if (root == null)
                return;

            if (node.value < root.value) {
                if (root.left == null)
                    root.left = node;
                else
                    this.insert(root.left, node);
            } else {
                if (root.right ==  null)
                    root.right = node;
                else
                    this.insert(root.right, node);
            }
        }


        public boolean contains(int value) {
            return this.find(this, value) != null;
        }

        private BST find(BST root, int val) {
            if (root == null || root.value == val)
                return root;
            if (root.value > val)
                return this.find(root.left, val);
            else
                return this.find(root.right, val);
        }

        public BST remove(int value) {
            if (this.left == null && this.right == null)
                return null;

            BST ret = this.remove(this, value);
            if (this.value != ret.value)
                this.value = ret.value;
            this.left = ret.left;
            this.right = ret.right;
            return this;
        }

        private BST remove(BST root, int val) {
            if (root == null)
                return root;

            int currVal = root.value;

            if (currVal == val) {
                if (root.left == null && root.right == null)
                    return null;
                else if (root.left != null && root.right == null)
                    return root.left;
                else if (root.left == null && root.right != null)
                    return root.right;
                else {
                    BST minNode = this.delMin(root.right);
                    root.value = minNode.value;
                    if (root.right == minNode)
                        root.right = null;
                }
            } else if (val < currVal)
                root.left = this.remove(root.left, val);
            else
                root.right = this.remove(root.right, val);

            return root;
        }

        private BST delMin(BST root) {
            BST curr = root,
                    parent = null;

            while (curr != null && curr.left != null) {
                parent = curr;
                curr = curr.left;
            }

            if (parent != null)
                parent.left = null;

            return curr;
        }

    }
}

