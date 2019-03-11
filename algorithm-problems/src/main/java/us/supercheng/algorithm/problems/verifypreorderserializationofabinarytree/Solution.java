package us.supercheng.algorithm.problems.verifypreorderserializationofabinarytree;

import java.util.LinkedList;
import java.util.List;

class Solution {

    public static void main(String [] args) {
        Solution solution = new Solution();
        String s = "1,#,#,#,#";

        solution.isValidSerialization(s);
    }

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() < 1)
            return false;

        String[] arr = preorder.split(",");
        List<String> stack = new LinkedList<>();

        for (int i=0;i<arr.length;i++) {
            stack.add(arr[i]);
            while (stack.size()>=3 && stack.get(stack.size()-1).equals("#") &&
                    stack.get(stack.size()-2).equals("#") && !stack.get(stack.size() - 3).equals("#")) {
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                stack.add("#");
            }
        }
        return stack.size() == 1 && stack.get(0).equals("#");
    }
}