package us.supercheng.algorithm.problems.threeconsecutiveodds;

public class Solution {

    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr != null && arr.length > 2)
            for (int i=0, end=arr.length-2; i<end; i++)
                if (arr[i] % 2 != 0 && arr[i+1] % 2 != 0 && arr[i+2] % 2 != 0)
                    return true;

        return false;
    }

}