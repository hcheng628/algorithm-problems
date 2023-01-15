package us.supercheng.algorithm.problems.leetcode.kthsmallestprimefraction;

import java.util.PriorityQueue;

public class Solution {

    public int[] kthSmallestPrimeFractionQueue(int[] arr, int k) {
        int[] curr = null;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            double resA = arr[a[0]] / (arr[a[1]] * 1.0);
            double resB = arr[b[0]] / (arr[b[1]] * 1.0);
            return resA < resB ? -1 : 1;
        });

        for (int i = 0, len = arr.length; i < len - 1; i++)
            heap.offer(new int[]{i, len - 1});

        for (int count = 0; count != k; count++) {
            curr = heap.poll();
            heap.offer(new int[]{curr[0], curr[1] - 1});
        }

        return new int[]{arr[curr[0]], arr[curr[1]]};
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left = 0.0;
        double right = 1.0;

        for (int len = arr.length; true; ) {
            int[] res = {-1, -1};
            int count = 0;
            double mid = (right - left) / 2 + left;
            double currMax = 0.0;

            for (int row = 0, col = 1; row < len; row++) {
                while (col < len && arr[row] > mid * arr[col])
                    col++;

                if (col < len) {
                    double curr = arr[row] / (1.0 * arr[col]);
                    if (curr > currMax) {
                        res = new int[]{row, col};
                        currMax = curr;
                    }
                    count += len - col;
                    if (count > k)
                        break;
                }
            }

            if (count == k)
                return new int[]{arr[res[0]], arr[res[1]]};
            else if (count < k)
                left = mid;
            else
                right = mid;
        }
    }

}