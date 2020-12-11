package us.supercheng.algorithm.problems.leetcode.crawlerlogfolder;

public class Solution {
    public int minOperations(String[] logs) {
        int level = 0;

        for (String l : logs)
            if (l.equals("../")) {
                if (level > 0)
                    level--;
            } else if (!l.equals("./"))
                level++;

        return level;
    }
}