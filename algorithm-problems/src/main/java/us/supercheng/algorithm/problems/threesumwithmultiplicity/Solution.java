package us.supercheng.algorithm.problems.threesumwithmultiplicity;

public class Solution {

    public int threeSumMulti(int[] A, int target) {
        long[] map = new long[101];
        long count = 0;

        for (int a : A)
            map[a]++;

        for (int i=0; i<101; i++)
            for (int j=0; map[i] > 0 && j<101; j++)
                if (map[j] > 0) {
                    int k = target - i - j;
                    if (k < 0 || k > 100 || map[k] == 0)
                        continue;
                    if (i == j && j == k)
                        count += map[i] * (map[i]-1) * (map[i]-2) / 6 % 1000000007; // 3*2*1
                    else if (i == j && j != k)
                        count += map[i] * (map[i]-1) / 2 * map[k] % 1000000007;     // 2*1
                    else if (i < j && j < k)
                        count += map[i] * map[j] * map[k] % 1000000007;
                }

        return (int) count % 1000000007;
    }
}