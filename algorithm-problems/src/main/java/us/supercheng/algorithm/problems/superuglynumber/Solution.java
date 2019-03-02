package us.supercheng.algorithm.problems.superuglynumber;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int [] indexes = new int [primes.length],
                uglyDp = new int [n];

        uglyDp[0] = 1;
        for (int i=1;i<n;i++) {
            uglyDp[i] = Integer.MAX_VALUE;
            for (int j=0;j<primes.length;j++)
                uglyDp[i] = Math.min(uglyDp[i], primes[j] * uglyDp[indexes[j]]);

            for (int j=0;j<primes.length;j++)
                if (uglyDp[i] >= primes[j] * uglyDp[indexes[j]])
                    indexes[j]++;
        }
        return uglyDp[n-1];
    }
}