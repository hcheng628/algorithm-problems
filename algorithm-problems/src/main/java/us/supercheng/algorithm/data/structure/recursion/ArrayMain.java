package us.supercheng.algorithm.data.structure.recursion;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class ArrayMain {

    public static void main(String[] args) {
        int [] arr = {1,-2,3,5,7,6,-98,77,82,13,16};
        PrintHelper.echoLn("Recursion: " + ArraySumRecursion.sum(arr));
        PrintHelper.echoLn("Loop: " + ArraySumLoop.sum(arr));
    }


    static class ArraySumRecursion {
        public static int sum(int[] arr) {
            return helper(arr, 0);
        }

        private static int helper(int[] arr, int l) {
            if(l==arr.length)
                return 0;
            return arr[l] + helper(arr, l+1);
        }
    }

    static class ArraySumLoop {
        public static int sum(int[] arr) {
            int ret = 0;
            for(int each : arr)
                ret += each;
            return ret;
        }
    }
}