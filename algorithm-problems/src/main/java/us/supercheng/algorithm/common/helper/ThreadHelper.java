package us.supercheng.algorithm.common.helper;

public class ThreadHelper {
    public static void sleep(int timer) {
        try {
            Thread.sleep(timer * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}