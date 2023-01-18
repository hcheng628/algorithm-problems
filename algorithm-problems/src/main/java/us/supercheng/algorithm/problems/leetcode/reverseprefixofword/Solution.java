package us.supercheng.algorithm.problems.leetcode.reverseprefixofword;

public class Solution {

    public String reversePrefix(String word, char ch) {
        if (word == null || word.length() < 2)
            return word;

        char[] arr = word.toCharArray();
        for (int left = 0, right = word.indexOf(ch); left < right; left++, right--) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }

        return new String(arr);
    }

}
