package us.supercheng.algorithm.problems.leetcode.rearrangespacesbetweenwords;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String reorderSpaces(String text) {
        StringBuilder sb = new StringBuilder();
        String[] arr = text.split(" ");
        int wordTotalLen = 0;
        List<String> list = new ArrayList<>();

        for (String a : arr) {
            String curr = a.trim();
            int currLen = curr.length();
            if (currLen != 0 && !curr.equals(" ")) {
                list.add(curr);
                wordTotalLen += currLen;
            }
        }

        int size = 1,
            spaceCount = text.length() - wordTotalLen;

        if (list.size() > 1)
            size = spaceCount / (list.size() - 1);

        for (int i=0; i<size; i++)
            sb.append(' ');

        String spaceBlk = sb.toString();
        sb.setLength(0);

        for (String l : list) {
            sb.append(l);
            if (spaceCount >= size) {
                sb.append(spaceBlk);
                spaceCount -= size;
            }
        }

        for (; spaceCount > 0; spaceCount--)
            sb.append(' ');

        return sb.toString();
    }
}