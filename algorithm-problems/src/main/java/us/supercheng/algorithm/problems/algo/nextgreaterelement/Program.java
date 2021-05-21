package us.supercheng.algorithm.problems.algo.nextgreaterelement;

import java.util.*;

public class Program {

    // Time: O(n^2) Space: O(n)
    public int[] nextGreaterElement_Solution1(int[] array) {
        if (array == null)
            return new int[0];

        int len = array.length;
        int[] ret = new int[len];
        for (int i=0; i<len; i++)
            ret[i] = this.nextBigVal(array, len, i);

        return ret;
    }

    public int nextBigVal(int[] arr, int len, int idx) {
        int currVal = arr[idx];

        for (int i=idx+1; i<len; i++)
            if (arr[i] > currVal)
                return arr[i];

        for (int i=0; i<idx; i++)
            if (arr[i] > currVal)
                return arr[i];

        return -1;
    }

    // Time: O(n) Space: O(n)
    public int[] nextGreaterElement(int[] array) {
        if (array == null || array.length < 1)
            return new int[0];

        int len = array.length;
        int max = array[0];
        int[] ret = new int[len];
        Stack<Info> stack = new Stack<>();

        for (int i=0; i<len; i++) {
            max = Math.max(array[i], max);

            while (!stack.isEmpty() && stack.peek().val < array[i])
                ret[stack.pop().idx] = array[i];

            stack.push(new Info(i, array[i]));
        }

        for (int i=0; i<len; i++)
            for(; !stack.isEmpty() && (stack.peek().val == max || stack.peek().val < array[i]); stack.pop())
                ret[stack.peek().idx] = stack.peek().val == max ? -1 : array[i];

        return ret;
    }

    class Info {
        int idx;
        int val;

        Info(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
