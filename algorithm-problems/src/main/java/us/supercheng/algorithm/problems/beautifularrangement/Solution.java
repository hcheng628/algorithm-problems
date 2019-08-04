package us.supercheng.algorithm.problems.beautifularrangement;

import java.util.ArrayList;
import java.util.List;

class Solution {

    int count;

    public int countArrangement(int N) {
        boolean[] arr = new boolean[N+1];
        List<Integer> list = new ArrayList<>();
        this.count = 0;
        this.helper(arr, 1, list);
        return this.count;
    }

    private void helper(boolean[] arr, int idx, List<Integer> list) {
        if (list.size() == arr.length-1) {
            this.count++;
            return;
        }

        for (int i=1;i<arr.length;i++) {
            if (arr[i])
                continue;
            if (idx % i == 0 || i % idx == 0) {
                list.add(idx);
                arr[i] = true;
                this.helper(arr, idx+1, list);
                arr[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}