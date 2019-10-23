package us.supercheng.algorithm.problems.beautifularrangementii;

class Solution {

    public int[] constructArray(int n, int k) {
        int[] ret = new int [n];
        Boolean[] bucket = new Boolean[n+1];

        int i = 0;

        for (int skip = n - k - 1,max = n - skip,min = 1;i<ret.length-skip-1;) {
            bucket[min] = true;
            ret[i++] = min++;
            if (i+1<ret.length) {
                bucket[max] = true;
                ret[i++] = max--;
            }
        }

        for (int j=1;j<=n&&i<n;j++)
            if (bucket[j] == null)
                ret[i++] = j;

        return ret;
    }
}