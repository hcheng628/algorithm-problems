package us.supercheng.algorithm.problems.constructbinarytreefrompreorderandinordertraversal;

import us.supercheng.algorithm.common.entity.TreeNode;

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;

        return makeTree(preorder, inorder, 0, preorder.length -1, 0, inorder.length-1);
    }

    public TreeNode makeTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preorder.length-1 || preStart > preEnd)
            return null;

        int index = this.getIndex(inorder, preorder[preStart], inStart);
        TreeNode root = new TreeNode(preorder[preStart]);

        int i=0;
        while(i<index-inStart)
            i++;
        root.left = this.makeTree(preorder, inorder, preStart+1, preStart+i, inStart, index-1);
        root.right = this.makeTree(preorder, inorder, preStart+i+1, preEnd, index+1, inEnd);
        return root;
    }

    private int getIndex(int[] nums, int val, int start) {
        for(;start<nums.length;start++)
            if(nums[start]== val)
                return start;
        return -1;
    }
}