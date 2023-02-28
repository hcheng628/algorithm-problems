package us.supercheng.algorithm.problems.leetcode.circularsentence;

class Solution {

    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        if (arr[0].charAt(0) != arr[arr.length - 1].charAt(arr[arr.length - 1].length() - 1))
            return false;

        for (int i = 1, len = arr.length; i < len; i++)
            if (arr[i - 1].charAt(arr[i - 1].length() - 1) != arr[i].charAt(0))
                return false;

        return true;
    }

}
