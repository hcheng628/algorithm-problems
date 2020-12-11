package us.supercheng.algorithm.problems.leetcode.largestplussign;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int orderOfLargestPlusSignV1(int N, int[][] mines) {
        int[][] up = new int[N][N],
                down = new int[N][N],
                left = new int[N][N],
                right = new int[N][N],
                mat = new int[N][N];

        for (int i=0;i<N;i++)
            Arrays.fill(mat[i], 1);
        for (int[] m : mines)
            mat[m[0]][m[1]] = 0;

        for (int i=1;i<N;i++)
            for (int j=0;j<N;j++)
                if (mat[i][j] != 0 && mat[i-1][j] != 0)
                    up[i][j] += up[i-1][j] + 1;

        for (int i=N-2;i>-1;i--)
            for (int j=0;j<N;j++)
                if (mat[i][j] != 0 && mat[i+1][j] != 0)
                    down[i][j] += down[i+1][j] + 1;

        for (int i=1;i<N;i++)
            for (int j=0;j<N;j++)
                if (mat[j][i] != 0 && mat[j][i-1] != 0)
                    left[j][i] += left[j][i-1] + 1;

        for (int i=N-2;i>-1;i--)
            for (int j=0;j<N;j++)
                if (mat[j][i] != 0 && mat[j][i+1] != 0)
                    right[j][i] += right[j][i+1] + 1;

        int ret = 0;
        for (int i=0;i<N;i++)
            for (int j=0;j<N;j++)
                if (mat[i][j] != 0)
                    ret = Math.max(ret, Math.min(up[i][j], Math.min(down[i][j], Math.min(left[i][j], right[i][j])))+1);

        return ret;
    }

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> set = new HashSet<>();
        int[][] mat = new int[N][N];
        int ret = 0,
                count = 0;

        for (int[] row : mines)
            set.add(row[0] * N + row[1]);

        for (int i=0;i<N;i++) {
            count = 0;
            for (int j=0;j<N;j++) {
                count = set.contains(i*N+j) ? 0 : 1 + count;
                mat[i][j] = count;
            }
            count = 0;
            for (int j=N-1;j>-1;j--) {
                count = set.contains(i*N+j) ? 0 : 1 + count;
                mat[i][j] = Math.min(mat[i][j], count);
            }
        }

        for (int i=0;i<N;i++) {
            count = 0;
            for (int j=0;j<N;j++) {
                count = set.contains(j*N+i) ? 0 : 1 + count;
                mat[j][i] = Math.min(mat[j][i], count);
            }
            count = 0;
            for (int j=N-1;j>-1;j--) {
                count = set.contains(j*N+i) ? 0 : 1 + count;
                mat[j][i] = Math.min(mat[j][i], count);
                ret = Math.max(mat[j][i], ret);
            }
        }
        return ret;
    }
}