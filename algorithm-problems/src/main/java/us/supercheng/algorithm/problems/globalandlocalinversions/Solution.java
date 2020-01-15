package us.supercheng.algorithm.problems.globalandlocalinversions;

public class Solution {

    public boolean isIdealPermutation(int[] A) {
        int glo = 0;

        for (int i=0;i<A.length;i++)
            glo += this.invGlo(i, A);

        return glo == this.invLoc(A.length, A);
    }

    private int invGlo(int idx, int[] A) {
        int count = 0;
        for (int i=0;i<idx;i++)
            if (A[i] > A[idx])
                count++;
        return count;
    }

    private int invLoc(int idx, int[] A) {
        int count = 0;
        for (int i=0;i<A.length-1;i++)
            if (A[i] > A[i+1])
                count++;
        return count;
    }

    public boolean isIdealPermutationMS(int[] A) {
        if (A == null || A.length < 1)
            return true;

        int len = A.length,
            loc = 0;

        for (int i=0;i<len-1;i++)
            if (A[i] > A[i+1])
                loc++;

        return this.mergeSort(A, 0, len) == loc;
    }

    private int mergeSort(int[] arr, int left, int right) {
        if (left + 1 >= right)
            return 0;

        int mid = (right - left) / 2 + left,
            res = this.mergeSort(arr, left, mid) + this.mergeSort(arr, mid, right),
            l = left,
            r = mid,
            idx = 0;

        int[] copy = new int[right-left];

        while (l<mid && r < right)
            if (arr[l] < arr[r])
                copy[idx++] = arr[l++];
            else {
                res += mid - l;
                copy[idx++] = arr[r++];
            }

        while(l<mid)
            copy[idx++] = arr[l++];

        while(r<right)
            copy[idx++] = arr[r++];

        for (int i=left,j=0;i<right;i++,j++)
            arr[i] = copy[j];

        return res;
    }
}