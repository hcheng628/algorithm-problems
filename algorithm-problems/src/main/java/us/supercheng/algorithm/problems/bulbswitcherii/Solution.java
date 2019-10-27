package us.supercheng.algorithm.problems.bulbswitcherii;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int flipLights(int n, int m) {
        if (n == 0 || m == 0)
            return 1;
        else if (n == 1)
            return 2;
        else if (n == 2)
            return m == 1 ? 3 : 4;
        else if (m == 1)
            return 4;
        else if (m == 2)
            return 7;
        return 8;
    }


    private int SIZE;

    public int flipLightsTLE(int n, int m) {
        Set<String> set = new HashSet<>();
        this.SIZE = n;

        boolean[] arr = new boolean[this.SIZE];
        Arrays.fill(arr, true);
        this.doAction(0, m, set, arr);

        return set.size();
    }

    private void doAction(int curr, int end, Set<String> set, boolean[] arr) {
        if (curr == end) {
            set.add(Arrays.toString(arr));
            return;
        }

        boolean[] copy = this.copyArr(arr);
        this.filp(copy);
        this.doAction(curr+1, end, set, copy);

        copy = this.copyArr(arr);
        this.filpEven(copy);
        this.doAction(curr+1, end, set, copy);

        copy = this.copyArr(arr);
        this.filpOdd(copy);
        this.doAction(curr+1, end, set, copy);

        copy = this.copyArr(arr);
        this.filpK(copy);
        this.doAction(curr+1, end, set, copy);

    }

    private void filp(boolean[] arr) {
        for (int i=0, len=arr.length;i<len;i++)
            arr[i] = !arr[i];
    }

    private void filpEven(boolean[] arr) {
        for (int i=0, len=arr.length;i<len;i++)
            if (i%2==0)
                arr[i] = !arr[i];
    }


    private void filpOdd(boolean[] arr) {
        for (int i=0, len=arr.length;i<len;i++)
            if (i%2 != 0)
                arr[i] = !arr[i];
    }


    private void filpK(boolean[] arr) {
        int k = 0;
        for (int i=0, len=arr.length;i<len;i++) {
            if (i == 3*k*(i)) {
                arr[i] = !arr[i];
                k++;
            }
        }
    }

    private boolean[] copyArr(boolean[] arr) {
        boolean[] ret = new boolean[arr.length];
        for (int i=0, len=arr.length;i<len;i++)
            ret[i] = arr[i];
        return ret;
    }
}