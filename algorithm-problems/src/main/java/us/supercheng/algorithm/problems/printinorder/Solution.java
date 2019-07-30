package us.supercheng.algorithm.problems.printinorder;

import java.util.concurrent.*;

class Solution {

    Semaphore lock2, lock3;

    public Solution () {
        this.lock2 = new Semaphore(0);
        this.lock3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        this.lock2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        this.lock2.acquire();
        printSecond.run();
        this.lock2.release();
        this.lock3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        this.lock3.acquire();
        printThird.run();
        this.lock3.release();
    }
}