package us.supercheng.algorithm.problems.uniquebinarysearchtrees;

public class App {
    public int numTrees(int n) {
        double top = 1.0, count = n;

        for(int i=n*2;i>=n+2;i--) {
            top *= i;
            if(i % 2 == 0)
                top /=count--;
        }

        for(;count >= 2;top /=count--);
        return (int) top;
    }
}
