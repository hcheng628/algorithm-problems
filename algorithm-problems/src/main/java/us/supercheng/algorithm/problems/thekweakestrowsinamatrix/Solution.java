package us.supercheng.algorithm.problems.thekweakestrowsinamatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        if (mat == null || mat.length < 1)
            return null; // whatever validation.....

        int rowL = mat.length,
                idx = 0;

        int[] row = new int [rowL],
                ret = new int[k];

        for (int i=0, colL = mat[0].length; i<rowL; i++) {
            int count = 0;
            for (int j=0; j<colL; j++) {
                if (j == 0 && mat[i][j] == 0)
                    break;
                if (mat[i][j] == 1)
                    count++;
            }
            row[i] = count;
        }

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i=0; i<rowL; i++) {
            List<Integer> list = map.get(row[i]);
            if (list == null)
                map.put(row[i], new ArrayList<>(Arrays.asList(i)));
            else
                list.add(i);
        }

        for (List<Integer> list : map.values()) {
            for (int i=0, len=list.size(); i<len && idx < k; i++)
                ret[idx++] = list.get(i);
            if (idx == k)
                break;
        }

        return ret;
    }
}