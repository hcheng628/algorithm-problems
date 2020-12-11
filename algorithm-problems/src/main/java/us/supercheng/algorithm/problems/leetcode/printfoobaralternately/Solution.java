package us.supercheng.algorithm.problems.leetcode.printfoobaralternately;

import java.util.concurrent.*;

class Solution {

    private int n;
    private Semaphore lock1;
    private Semaphore lock2;

    public Solution(int n) {
        this.n = n;
        this.lock1 = new Semaphore(0);
        this.lock2 = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            printFoo.run();
            this.lock2.release();
            this.lock1.acquire();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            this.lock2.acquire();
            printBar.run();
            this.lock1.release();
        }
    }
}