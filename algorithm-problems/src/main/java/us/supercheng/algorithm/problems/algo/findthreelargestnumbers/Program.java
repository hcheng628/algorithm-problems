package us.supercheng.algorithm.problems.algo.findthreelargestnumbers;

public class Program {

    public static int[] findThreeLargestNumbers_Solution1(int[] array) {
        if (array == null || array.length < 3)
            return new int[0];

        int low = Math.min(array[0], Math.min(array[1], array[2])),
            high = Math.max(array[0], Math.max(array[1], array[2])),
            mid = array[0] + array[1] + array[2] - low - high;

        int[] ret = new int[]{low, mid, high};

        for (int i=3, len = array.length; i<len; i++) {
            int val = array[i];

            if (val > ret[2]) {
                if (ret[1] > ret[0])
                    ret[0] = ret[1];
                if (ret[2] > ret[1])
                    ret[1] = ret[2];
                ret[2] = val;
            } else if (val > ret[1]) {
                if (ret[1] > ret[0])
                    ret[0] = array[1];
                ret[1] = val;
            } else if (val > ret[0])
                ret[0] = val;
        }

        return ret;
    }

    public static int[] findThreeLargestNumbers_Solution2(int[] array) {
        if (array == null || array.length < 3)
            return new int[0];

        int[] ret = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int i=0, len=array.length; i<len; i++) {
            int val = array[i];

            if (val > ret[2])
                updateMaxArr(ret, 2, val);
            else if (val > ret[1])
                updateMaxArr(ret, 1, val);
            else if (val > ret[0])
                updateMaxArr(ret, 0, val);
        }

        return ret;
    }

    private static void updateMaxArr(int[] ret, int idx, int val) {
        for (int i=1; i<=idx; i++)
            if (ret[i-1] < ret[i])
                ret[i-1] = ret[i];
        ret[idx]= val;
    }
}
