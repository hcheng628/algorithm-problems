package us.supercheng.algorithm.problems.splitarrayintofibonaccisequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ret = new ArrayList<>();

        if (this.dfs(S.toCharArray(), S.length(), 0, ret))
            return ret;

        return new ArrayList<>();
    }

    private boolean dfs(char[] chars, int len, int idx, List<Integer> list) {
        if (idx == len)
            return list.size() > 2;

        int num = 0;

        for (int i=idx; i<len; i++) {
            Integer prevPrev = null,
                    prev = null,
                    size = list.size();
            num = num * 10 + (chars[i] - '0');

            if (num < 0)
                return false;

            if (size > 1) {
                prevPrev = list.get(size - 2);
                prev = list.get(size - 1);
            }

            if (size < 2 || prevPrev != null && prev != null && prevPrev + prev == num) {
                list.add(num);
                if (this.dfs(chars, len, i+1, list))
                    return true;
                list.remove(list.size()-1);
            }

            if (chars[i] == '0' && i == idx)
                return false;
        }

        return false;
    }
}