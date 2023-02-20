package us.supercheng.algorithm.problems.leetcode.bestpokerhand;

class Solution {

    public String bestHand(int[] ranks, char[] suits) {
        if (suits[0] == suits[1] && suits[1] == suits[2] && suits[2] == suits[3] && suits[3] == suits[4])
            return "Flush";

        boolean hasTwoCount = false;
        int[] count = new int[14];
        for (int r : ranks) {
            count[r]++;
            if (count[r] == 2)
                hasTwoCount = true;
            else if (count[r] == 3)
                return  "Three of a Kind";
        }

        return hasTwoCount ? "Pair" : "High Card";
    }

}
