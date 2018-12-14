package us.supercheng.algorithm.problems.gasstation;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, debt = 0, remain = 0;
        for(int i=0;i<gas.length;i++) {
            remain += gas[i] - cost[i];
            if(remain <0) {
                start = i+1;
                debt += remain;
                remain = 0;
            }
        }
        return debt + remain > -1 ? start : -1;
    }
}