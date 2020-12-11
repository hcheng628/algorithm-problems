package us.supercheng.algorithm.problems.leetcode.numberofrecentcalls;

import java.util.LinkedList;
import java.util.Queue;

public class App {
    private Queue<Integer> queue;

    public App() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        this.queue.add(t);
        if(this.queue.peek() + 3000 < t)
            while(!this.queue.isEmpty() && this.queue.peek() + 3000 < t)
                this.queue.remove();
        return this.queue.size();
    }
}
