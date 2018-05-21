package us.supercheng.algorithm.problems.factorialtrailingzeroes;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int num = 701; // 2600 52 702 701
        System.out.println(app.trailingZeroes1(num));
        System.out.println("----------");
        System.out.println(app.trailingZeroes2(num));
        System.out.println("----------");
        System.out.println(app.trailingZeroes3(num));
        System.out.println("----------");
        System.out.println(app.trailingZeroes4(num));
    }

    public int trailingZeroes1(int n) {
        int numF = 0;
        while(n != 0) {
            numF += n / 5;
            n /= 5;
        }
        return numF;
    }

    public int trailingZeroes2(int n) {
        int numF = 0;
        while(n != 0) {
            int temp = n / 5;
            numF += temp;
            n = temp;
        }
        return numF;
    }

    public int trailingZeroes3(int n) {
        int numF = 0;
        for(int i=1;i<=n;i++) {
            int currNum = i;
            while(currNum / 5 != 0 && currNum % 5 == 0) {
                currNum = currNum / 5;
                numF++;
            }
        }
        return numF;
    }

    public int trailingZeroes4(int n) {
        int numF = 0;
        return n == 0 ? 0 : n / 5 + trailingZeroes4(n/5);
    }
}