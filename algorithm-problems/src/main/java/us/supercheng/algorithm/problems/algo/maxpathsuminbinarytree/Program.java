package us.supercheng.algorithm.problems.algo.maxpathsuminbinarytree;

public class Program {

    public static int maxPathSum(BinaryTree tree) {
        int[] ret = helper(tree);
        return Math.max(ret[0], ret[1]);
    }

    private static int[] helper(BinaryTree tree) {
        if (tree == null)
            return null;

        int self = tree.value;
        int[] left = helper(tree.left);
        int[] right = helper(tree.right);
        int[] ret = new int[]{self, self};

        if (left != null && right != null) {
            ret[0] = max(new int[]{self, self + left[0], self + right[0]});
            ret[1] = max(new int[]{self + left[0] + right[0], left[0], left[1], right[0], right[1]});
        } else if (left == null && right != null) {
            ret[0] = Math.max(self, self + right[0]);
            ret[1] = max(new int[]{self + right[0], right[0], right[1]});
        } else if (left != null && right == null) {
            ret[0] = Math.max(self, self + left[0]);
            ret[1] = max(new int[]{self + left[0], left[0], left[1]});
        }

        return ret;
    }

    private static int max(int[] arr) {
        int ret = arr[0];
        for (int i=1, len=arr.length; i<len; i++)
            if (arr[i] > ret)
                ret = arr[i];
        return ret;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}

