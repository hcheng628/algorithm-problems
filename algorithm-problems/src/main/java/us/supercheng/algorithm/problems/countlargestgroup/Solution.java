package us.supercheng.algorithm.problems.countlargestgroup;

public class Solution {

    public int countLargestGroup(int n) {
        int[] bucket = new int[37]; // 9 + 9 + 9 + 9 = 36
        int max = 0,
                ret = 0;

        for (int i=1; i<=n; i++) {
            int sum = 0;

            for (int num=i; num != 0; num /= 10)
                sum += num % 10;

            bucket[sum]++;

            if (bucket[sum] > max) {
                ret = 1;
                max = bucket[sum];
            } else if (bucket[sum] == max)
                ret++;
        }

        return ret;
    }
}
