package us.supercheng.algorithm.problems.leetcode.convertsortedarraytobinarysearchtree;

import us.supercheng.algorithm.common.entity.TreeNode;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        int [] arr = {-10,-9,-6,-3,-1,0,1,2,3,4,5,6,7,8,9,10};
        System.out.println(app.sortedArrayToBST(arr));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] arr, int left, int right) {
        if(left <0 || right < 0 || left > arr.length || right >= arr.length || left > right) {
            return null;
        }
        int mid = (right - left) / 2 + left;
        TreeNode tree = new TreeNode(arr[mid]);
        tree.left = helper(arr, left, mid - 1);
        tree.right = helper(arr, mid + 1, right);
        return tree;
    }
}