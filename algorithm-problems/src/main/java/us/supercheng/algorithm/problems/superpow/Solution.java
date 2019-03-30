package us.supercheng.algorithm.problems.superpow;

class Solution {

    public int superPow(int a, int[] b) {
        if (b == null || b.length == 0)
            return 1;
        a %= 1337;
        int lastDig = b[b.length-1];
        int[] arr = new int [b.length-1];
        for (int i=0;i<arr.length;i++)
            arr[i] = b[i];
        return (this.superPow(this.superPow(a, arr), 10) * this.superPow(a, lastDig)) % 1337;
    }

    public int superPow(int a, int b) {
        if (b == 0)
            return 1;
        int ret = 1;
        for (int i=1;i<=b;i++)
            ret = (ret*a) % 1337;
        return ret;
    }
}