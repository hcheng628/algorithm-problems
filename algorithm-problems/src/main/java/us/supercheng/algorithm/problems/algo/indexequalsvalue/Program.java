package us.supercheng.algorithm.problems.algo.indexequalsvalue;

public class Program {

    public int indexEqualsValue_Solution1(int[] array) {
        for (int left = 0, right = array.length - 1; left <= right; ) {
            int mid = (right - left) / 2 + left;
            int midVal = array[mid];
            if (mid == midVal) {
                if (mid == 0 || mid - 1 != array[mid - 1])
                    return mid;
                right = mid - 1;
            } else if (mid < midVal)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return -1;
    }

    public int indexEqualsValue_Solution2(int[] array) {
        return this.helper(array, 0, array.length - 1);
    }

    private int helper(int[] arr, int left, int right) {
        if (left > right)
            return -1;

        int mid = (right - left) / 2 + left;
        int midVal = arr[mid];

        if (mid == midVal)
            return mid == 0 || mid - 1 != arr[mid - 1] ? mid : this.helper(arr, left, mid - 1);

        return mid < midVal ? this.helper(arr, left, mid - 1) : this.helper(arr, mid + 1, right);
    }

}