package us.supercheng.algorithm.problems.nthdigit;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        App app = new App();
        PrintHelper.echoLn(app.findNthDigit(1000000));
    }

    public int findNthDigit(int n) {
        /*
        1-9               9       Nums      - Size 1 -> size * nums = 9         Digits
        10-99             90      Nums      - Size 2 -> size * nums = 180       Digits
        100-999           900     Nums      - Size 3 -> size * nums = 2700      Digits
        1000-9999         9000    Nums      - Size 4 -> size * nums = 36000     Digits
        10000 - 99999     90000   Nums      - Size 5 -> size * nums = 450000    Digits
        */
        if(n<=0)
            return 0;
        if(n<10)
            return n;
        long count = 9;
        int start = 1;
        int len = 1;
        /* Get the Range */
        while(n>count * len) {
            n -= count * len;
            len++;
            start *=10;
            count *=10;
        }
        /* Get the Num */
        start += (n-1)/len;
        PrintHelper.echoLn("Num: " + start);
        /* Get the Digit */
        int ret = String.valueOf(start).charAt((n-1)%len) - '0';
        PrintHelper.echoLn("Digit: " + ret);
        return ret;
    }
}