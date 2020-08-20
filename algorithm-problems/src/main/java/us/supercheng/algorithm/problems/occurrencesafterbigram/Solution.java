package us.supercheng.algorithm.problems.occurrencesafterbigram;

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
}
