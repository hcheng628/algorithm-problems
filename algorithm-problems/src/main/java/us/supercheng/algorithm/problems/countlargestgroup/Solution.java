package us.supercheng.algorithm.problems.countlargestgroup;

public class Solution {

    public int countLargestGroup(int n) {
        int[] bucket = new int[10001];
        int max = 0,
                ret = 0;

        for (int i=1; i<=n; i++) {
            int sum = 0;

            for (int num=i; num != 0; num /= 10)
                sum += num % 10;

            bucket[sum]++;
            max = Math.max(bucket[sum], max);
        }

        for (int i=0; i<10001; i++)
            if (bucket[i] == max)
                ret++;

        return ret;
    }
}
