package us.supercheng.algorithm.problems.sqrtx;

public class App {
    public static void main(String[] args) {
        App app = new App();
        System.out.print("Cheng: " + 1073741823.0 * 1073741823.0);
        int a = app.mySqrt(2147483647);
        System.out.println("Final Result: " + a);
    }

    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int low = 0;
        int high = x;
        double mid = 0.0;
        while(high - low > 1) {
            System.out.println("Before: >>> Low: " + low + " Mid: " + mid + " High: " + high);
            mid = (high + low) / 2;
            double result = mid *  mid;
            if(result == (double)x) {
                return (int) mid;
            } else if (result > x) {
                high = (int) mid;
            } else {
                low = (int) mid;
            }
            System.out.println("After: >>> Low: " + low + " Mid: " + mid + " High: " + high);
        }
        int result = (int)(mid * mid);
        return result > x ? ( (int) mid) -1 : (int) mid;
    }
}