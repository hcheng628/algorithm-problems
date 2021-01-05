package us.supercheng.algorithm.problems.algo.searchinsortedmatrix;

public class Program {

    public static int[] searchInSortedMatrix_Solution1(int[][] matrix, int target) {
        for (int i=0, R = matrix.length; i<R; i++) {
            int idx = binarySearch(matrix[i], target);
            if (idx != -1)
                return new int[]{i, idx};
        }
        return new int[] {-1, -1};
    }

    public static int binarySearch(int[] row, int target) {
        for (int len = row.length, left = 0, right = len - 1; left <= right; ) {
            int mid = (right - left) / 2 + left;
            int val = row[mid];
            if (val == target)
                return mid;
            else if (val < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }

    public static int[] searchInSortedMatrix_Solution2(int[][] matrix, int target) {
        for (int row = matrix.length - 1, col = 0; row >= 0 && col >= 0 && col <= matrix[row].length; ) {
            int curr = matrix[row][col];
            if (curr == target)
                return new int[]{row, col};
            else if (curr > target)
                row--;
            else
                col++;
        }

        return new int[]{-1, -1};
    }

    public static int[] searchInSortedMatrix_Solution3(int[][] matrix, int target) {
        for (int row=0, col=matrix[row].length - 1, len = matrix.length; row < len && col > -1; ) {
            int curr = matrix[row][col];
            if (curr == target)
                return new int[]{row, col};
            else if (curr < target)
                row++;
            else
                col--;
        }
        return new int[] {-1, -1};
    }

}
