package us.supercheng.algorithm.problems.leetcode.checkifawordoccursasaprefixofanywordinasentence;

public class Solution {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");

        for (int i=0, len=arr.length, sLen = searchWord.length(); i<len; i++)
            if (arr[i].length() >= sLen && arr[i].indexOf(searchWord) == 0)
                return i+1;

        return -1;
    }

}
