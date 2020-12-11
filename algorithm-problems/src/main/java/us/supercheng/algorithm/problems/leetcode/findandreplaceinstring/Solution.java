package us.supercheng.algorithm.problems.leetcode.findandreplaceinstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        int len = indexes.length,
                sLen = S.length(),
                curr = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<len;i++)
            map.put(indexes[i],i);

        Arrays.sort(indexes);

        if (curr < indexes[0]) {
            sb.append(S.substring(0, indexes[0]));
            curr = indexes[0];
        }

        for (int i=0;i<len && curr < sLen;i++) {
            int idx = indexes[i],
                wordLen = sources[map.get(idx)].length();

            if (idx + wordLen <= sLen && S.subSequence(idx, idx + wordLen).equals(sources[map.get(idx)])) {
                sb.append(targets[map.get(idx)]);
                curr += wordLen;
            } else
                sb.append(S.charAt(curr++));

            if (i != len - 1 && indexes[i+1] > curr) {
                sb.append(S.substring(curr, indexes[i+1]));
                curr = indexes[i+1];
            }
        }

        if (curr < sLen)
            sb.append(S.substring(curr));

        return sb.toString();
    }
}