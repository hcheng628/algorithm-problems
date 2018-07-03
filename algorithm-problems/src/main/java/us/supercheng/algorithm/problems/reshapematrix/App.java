package us.supercheng.algorithm.problems.reshapematrix;

import java.util.ArrayList;

public class App {

    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        if(nums.length * nums[0].length != r * c)
            return nums;
        int[][] ret = new int[r][c];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<nums[i].length;j++)
                list.add(nums[i][j]);
        int index = 0;
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                ret[i][j] = list.get(index++);
        return ret;
    }

    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        if(nums.length * nums[0].length != r * c || nums == null)
            return nums;
        int[][] ret = new int[r][c];
        int index = 0;
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<nums[0].length;j++)
                ret[index / c][index++ % c] = nums[i][j];
        return ret;
    }
}
