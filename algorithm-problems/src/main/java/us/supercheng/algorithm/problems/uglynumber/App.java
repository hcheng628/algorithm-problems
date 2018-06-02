package us.supercheng.algorithm.problems.uglynumber;

public class App {

    public static void main(String [] args) {
        App app = new App();
        System.out.println(app.isUgly(100));
    }

    public boolean isUgly(int num) {
        if(num <= 0)
            return false;
        if(num < 2)
            return true;
        if(num <=5)
            return true;
        while(num>5) {
            if(num % 5 ==0)
                num /= 5;
            else if (num % 3 == 0)
                num /= 3;
            else if (num % 2 == 0)
                num /= 2;
            else
                return false;
        }
        return true;
    }
}