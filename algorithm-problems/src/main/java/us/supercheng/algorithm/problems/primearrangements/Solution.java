package us.supercheng.algorithm.problems.primearrangements;

class Solution {

    public int numPrimeArrangements(int n) {
        int primeCount = 0;

        for (int i=1;i<=n;i++)
            if (this.isPrime(i))
                primeCount++;

        return (int) (this.mathHelper(primeCount)  % 1000000007 * this.mathHelper(n - primeCount) % 1000000007) % 1000000007;
    }

    private boolean isPrime(int num) {
        if (num == 1)
            return false;
        else if (num == 2)
            return true;
        for (int i=2;i<num;i++)
            if (num % i == 0)
                return false;
        return true;
    }

    private long mathHelper(int num) {
        long ret = 1;
        for (int i=1;i<=num;i++)
            ret = ret * i % 1000000007;
        return ret;
    }
}