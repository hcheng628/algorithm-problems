package us.supercheng.algorithm.problems.leetcode.occurrencesafterbigram;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String[] findOcurrences(String text, String first, String second) {
        if (text == null || text.length() < 1)
            return new String[0];

        String[] arr = text.split(" ");
        List<String> list = new ArrayList<>();
        boolean f = false, s = false;

        for (String curr : arr) {
            boolean once = true;

            if (f && s) {
                list.add(curr);
                f = s = false;
            }

            if (!f && curr.equals(first)) {
                once = false;
                f = true;
            }

            if (once)
                if (f && curr.equals(second))
                    s = true;
                else if (!curr.equals(first))
                    f = s = false;
        }

        return list.toArray(new String[list.size()]);
    }

    public String[] findOcurrencesOPT(String text, String first, String second) {
        String[] arr = text.split(" ");
        List<String> list = new ArrayList<>();

        for (int i=0, end=arr.length-2; i<end; i++)
            if (arr[i].equals(first) && arr[i+1].equals(second))
                list.add(arr[i+2]);

        return list.toArray(new String[list.size()]);
    }
}
