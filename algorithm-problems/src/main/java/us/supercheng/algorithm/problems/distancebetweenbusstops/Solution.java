package us.supercheng.algorithm.problems.distancebetweenbusstops;

class Solution {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination)
            return 0;
        else if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }

        int ret = 0,
            sum = 0,
            len = distance.length;

        for (int i=0;i<len;i++) {
            sum += distance[i];
            if (i>=start && i<destination)
                ret += distance[i];
        }

        return Math.min(ret, sum - ret);
    }
}