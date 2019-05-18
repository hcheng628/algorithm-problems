package us.supercheng.algorithm.problems.minimumgeneticmutation;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private Map<String, Boolean> bankMap;
    private Integer ret;

    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length < 1)
            return -1;

        this.bankMap = new HashMap<>();
        for (String each : bank)
            this.bankMap.put(each, false);

        if (!this.bankMap.containsKey(end))
            return -1;

        this.helper(start, end, 0);
        return this.ret == null ? -1 : this.ret;
    }

    private void helper(String start, String end, int count) {
        if (start.equals(end) && (this.ret == null || count < this.ret)) {
            this.ret = count;
            return;
        }

        for (String key : this.bankMap.keySet())
            if (!this.bankMap.get(key) && (this.ret == null || this.ret != null && count+1 < this.ret) && this.canCompare(key, start)) {
                this.bankMap.put(key, true);
                this.helper(key, end, count+1);
                this.bankMap.put(key, false);
            }
    }

    private boolean canCompare(String a, String b) {
        int count = 0;
        for (int i=0;i<8;i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
            if (count > 2)
                return false;
        }
        return count == 1;
    }
}