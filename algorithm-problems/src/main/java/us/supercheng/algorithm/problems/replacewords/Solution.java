package us.supercheng.algorithm.problems.replacewords;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    public String replaceWords(List<String> dict, String sentence) {
        String[] arr = sentence.split(" ");
        Set<String> set = new HashSet<>(dict);

        for (int i=0;i<arr.length;i++)
            for (int len = arr[i].length(), j=1;j<len;j++) {
                String s = arr[i].substring(0, j);
                if (set.contains(s)) {
                    arr[i] = s;
                    break;
                }
            }

        return String.join(" ", arr);
    }
}