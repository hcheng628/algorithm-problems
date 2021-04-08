package us.supercheng.algorithm.problems.algo.validatethreenodes;

public class Program {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // Time: O(height of the tree) Space: O(height of the tree from call stack)
    public boolean validateThreeNodes_Solution1(BST nodeOne, BST nodeTwo, BST nodeThree) {
        return (this.contains(nodeOne, nodeTwo) && this.contains(nodeTwo, nodeThree)) ||
                (this.contains(nodeThree, nodeTwo) && this.contains(nodeTwo, nodeOne));
    }

    private boolean contains(BST root, BST child) {
        if (root == null)
            return false;

        if (root == child)
            return true;

        return child.value < root.value ? this.contains(root.left, child) : this.contains(root.right, child);
    }

    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        BST one = nodeOne;
        BST three = nodeThree;
        int twoVal = nodeTwo.value;

        while (one != null || three != null) {
            if (one == nodeTwo || three == nodeTwo)
                break;
            else if (one == nodeThree || three == nodeOne)
                return false;

            if (one != null)
                one = twoVal < one.value ? one.left : one.right;

            if (three != null)
                three = twoVal < three.value ? three.left : three.right;
        }

        if (one == nodeTwo)
            return this.contains(nodeTwo, nodeThree);
        else if (three == nodeTwo)
            return this.contains(nodeTwo, nodeOne);

        return false;
    }

}