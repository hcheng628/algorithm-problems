package us.supercheng.algorithm.problems.algo.bstconstruction;

import java.util.*;

public class Program {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            BST curr = this;

            while (true)
                if (value < curr.value) {
                    if (curr.left == null) {
                        curr.left = new BST(value);
                        break;
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new BST(value);
                        break;
                    }
                    curr = curr.right;
                }

            return this;
        }

        public boolean contains(int value) {
            BST curr = this;

            while (curr != null) {
                int currVal = curr.value;
                if (value == currVal)
                    return true;
                curr = value < currVal ? curr = curr.left : curr.right;
            }

            return false;
        }

        public BST remove(int value) {
            this.remove(value, this, null);
            return this;
        }

        private void remove(int value, BST root, BST parent) {
            BST curr = root;

            while (curr != null) {
                int currVal = curr.value;
                if (value < currVal) {
                    parent = curr;
                    curr = curr.left;
                } else if (value > currVal) {
                    parent = curr;
                    curr = curr.right;
                } else {
                    if (curr.left != null && curr.right != null) {
                        curr.value = this.getMin(curr.right).value;
                        remove(curr.value, curr.right, curr);
                    } else if (parent == null) {
                        if (curr.left != null) {
                            curr.value = curr.left.value;
                            curr.right = curr.left.right;
                            curr.left = curr.left.left;
                        } else if (curr.right != null) {
                            curr.value = curr.right.value;
                            curr.left = curr.right.left;
                            curr.right = curr.right.right;
                        }
                    } else if (parent.left == curr)
                        parent.left = curr.left != null ? curr.left : curr.right;
                    else if  (parent.right == curr)
                        parent.right = curr.left != null ? curr.left : curr.right;
                    break;
                }
            }
        }

        private BST getMin(BST root) {
            BST ret = root;
            while (ret.left != null)
                ret = ret.left;
            return ret;
        }
    }
}