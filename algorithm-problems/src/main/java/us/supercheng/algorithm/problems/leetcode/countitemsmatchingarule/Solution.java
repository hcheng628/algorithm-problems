package us.supercheng.algorithm.problems.leetcode.countitemsmatchingarule;

import java.util.List;

public class Solution {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ruleIdx = this.ruleKeyIdx(ruleKey);
        int ret = 0;

        for (List<String> item : items)
            if (ruleValue.equals(item.get(ruleIdx)))
                ret++;

        return ret;
    }

    private int ruleKeyIdx(String r) {
        if (r.equals("type"))
            return 0;
        else if (r.equals("color"))
            return 1;

        return 2;
    }
}