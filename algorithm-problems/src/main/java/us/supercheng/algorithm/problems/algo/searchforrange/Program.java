package us.supercheng.algorithm.problems.algo.searchforrange;

public class Program {

    // Time: O(log(n)) Space: O(1)
    public static int[] searchForRange(int[] array, int target) {
        int idx = search(array, 0, array.length - 1, target);
        if (idx < 0)
            return new int[] {-1, -1};

        int first = idx;
        int last = idx;

        for (int left = 0, right = idx - 1; left <= right; right = idx - 1) {
            idx = search(array, left, right, target);
            if (idx < 0)
                break;
            first = idx;
        }

        for (int left = idx + 1,right = array.length - 1; left <= right; left = idx + 1) {
            idx = search(array, left, right, target);
            if (idx < 0)
                break;
            last = idx;
        }

        return new int[]{first, last};
    }

    private static int search(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int midVal = arr[mid];
            if (midVal == target) return mid;
            else if (midVal > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

}
