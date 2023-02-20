package us.supercheng.algorithm.problems.leetcode.firstlettertoappeartwice;

class Solution {

    public char repeatedCharacter(String s) {
        boolean[] visited = new boolean[26];

        for (char c : s.toCharArray()) {
            if (visited[c - 'a'])
                return c;
            visited[c - 'a'] = true;
        }

        return '-';
    }

}
