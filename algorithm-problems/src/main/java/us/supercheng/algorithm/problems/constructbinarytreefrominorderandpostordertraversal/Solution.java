package us.supercheng.algorithm.problems.constructbinarytreefrominorderandpostordertraversal;

import us.supercheng.algorithm.common.entity.TreeNode;

public class Solution {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length ==0)
            return null;
        return makeTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    private TreeNode makeTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if(inEnd < inStart || postEnd < 0)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int i=0, index = -1;
        for(int start=inStart;start<=inEnd;start++,i++)
            if(inorder[start] == postorder[postEnd]) {
                index = start;
                break;
            }

        root.left = this.makeTree(inorder, postorder,inStart, index-1, postStart,postStart+i-1);
        root.right = this.makeTree(inorder, postorder,index+1,inEnd,postStart+i,postEnd-1);

        return root;
    }
}
