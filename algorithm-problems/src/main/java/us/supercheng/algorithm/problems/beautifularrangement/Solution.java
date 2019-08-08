package us.supercheng.algorithm.problems.beautifularrangement;

class Solution {

    int count;

    public int countArrangement(int N) {
        boolean[] arr = new boolean[N+1];
        this.count = 0;
        this.helper(arr, 1);
        return this.count;
    }

    private void helper(boolean[] arr, int idx) {
        if (idx == arr.length) {
            this.count++;
            return;
        }

        for (int i=1;i<arr.length;i++)
            if (!arr[i] && (idx % i == 0 || i % idx == 0)) {
                arr[i] = true;
                this.helper(arr, idx+1);
                arr[i] = false;
            }
    }
}