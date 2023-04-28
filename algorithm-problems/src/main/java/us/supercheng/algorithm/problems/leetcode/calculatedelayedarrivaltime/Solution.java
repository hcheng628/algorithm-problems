package us.supercheng.algorithm.problems.leetcode.calculatedelayedarrivaltime;

class Solution {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

}
