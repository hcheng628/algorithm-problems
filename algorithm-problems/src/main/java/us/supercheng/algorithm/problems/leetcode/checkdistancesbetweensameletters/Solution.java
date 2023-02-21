package us.supercheng.algorithm.problems.leetcode.checkdistancesbetweensameletters;

class Solution {

    public boolean checkDistances(String s, int[] distance) {
        for (int i = 0, len = s.length(); i < len; i++) {
            int idx = s.charAt(i) - 'a';
            if (distance[idx] != -1 && (i + distance[idx] + 1 >= len || s.charAt(i) != s.charAt(i + distance[idx] + 1)))
                return false;
            distance[idx] = -1;
        }

        return true;
    }

}
