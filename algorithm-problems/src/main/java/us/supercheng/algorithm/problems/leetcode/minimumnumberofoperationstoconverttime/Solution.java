package us.supercheng.algorithm.problems.leetcode.minimumnumberofoperationstoconverttime;

class Solution {

    public int convertTime(String current, String correct) {
        int diff = this.toMins(correct) - this.toMins(current);
        return (diff / 60) + (diff % 60 / 15) + (diff % 60 % 15 / 5) + (diff % 60 % 15 % 5);
    }

    private int toMins(String t) {
        return t.charAt(0) * 600 + t.charAt(1) * 60 + t.charAt(3) * 10 + t.charAt(4);
    }

}
