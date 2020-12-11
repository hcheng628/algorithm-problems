package us.supercheng.algorithm.problems.leetcode.onlinestockspan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {
    private List<Integer> list;
    private Stack<int[]> stack;

    public StockSpanner() {
        this.list = new ArrayList<>();
        this.stack = new Stack<>();
    }

    public int next(int price) {
        int ret = 1;

        for (int idx=this.list.size()-1; idx>=0; idx--)
            if (this.list.get(idx) <= price)
                ret++;
            else
                break;

        this.list.add(price);

        return ret;
    }

    public int nextStack(int price) {
        int ret = 1;

        while (!this.stack.isEmpty() && this.stack.peek()[0] <= price)
            ret += stack.pop()[1];

        this.stack.push(new int[] {price, ret});
        return ret;
    }
}
