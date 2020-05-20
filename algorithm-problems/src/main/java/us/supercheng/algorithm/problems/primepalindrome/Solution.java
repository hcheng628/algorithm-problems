package us.supercheng.algorithm.problems.primepalindrome;

public class Solution {

    public int primePalindrome(int N) {
        if (N >= 8 && N <= 11)
            return 11;

        for (int i=1; i<100000; i++) {
            String x = Integer.toString(i),
                   y = new StringBuilder(x).reverse().toString().substring(1);

            int res = Integer.parseInt(x + y);
            if (res >= N && isPrime(res))
                return res;
        }
        return -1;
    }

    public boolean isPrime(int num) {
        if (num < 2)
            return false;
        else if (num < 4)
            return true;

        if (num % 2 == 0 || num % 3 == 0)
            return false;
        for (int i=5; i*i <= num; i += 6)
            if (num % i == 0 || num % (i+2) == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.primePalindrome(10000);
    }
}