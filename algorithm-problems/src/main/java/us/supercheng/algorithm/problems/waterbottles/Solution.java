package us.supercheng.algorithm.problems.waterbottles;

public class Solution {

    public int numWaterBottles(int numBottles, int numExchange) {
        int ret = numBottles;

        for (int left=0; numBottles >= numExchange; ret += left) {
            left = numBottles /  numExchange;
            numBottles = left + numBottles % numExchange;
        }

        return ret;
    }
}