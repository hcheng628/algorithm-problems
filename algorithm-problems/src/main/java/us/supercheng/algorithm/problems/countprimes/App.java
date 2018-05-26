package us.supercheng.algorithm.problems.countprimes;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        int val = 1500000;
        long a = System.currentTimeMillis();
        System.out.println(app.countPrimes(val));
        long b = System.currentTimeMillis();
        System.out.println("1st Approach Time: " + (b - a));

        a = System.currentTimeMillis();
        System.out.println(app.countPrimes2(val));
        b = System.currentTimeMillis();
        System.out.println("2nd Approach Time: " + (b - a));

        a = System.currentTimeMillis();
        System.out.println(app.countPrimes3(val));
        b = System.currentTimeMillis();
        System.out.println("3rd Approach Time: " + (b - a));
    }

    public int countPrimes(int n) {
        if(n < 3) {
            return 0;
        }
        int count = 1;
        boolean isPrime;
        for(int i=3; i<n;i+=2) {
            isPrime = true;
            for(int j=3; j*j<=i;j+=2) {
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                count++;
            }
        }
        return count;
    }

    public int countPrimes2(int n) {
        boolean [] primes = new boolean[n];
        int count = 0;
        for(int i=2;i<n;i++) {
            if(!primes[i]) {
                boolean isPrimeFlag = true;
                for(int j=2;j*i<primes.length;j++) {
                    if(!primes[j*i]) {
                        primes[j*i] = true;
                    }
                }
                for(int j=3; j*j<i;j+=2) {
                    if(i % j == 0) {
                        isPrimeFlag = true;
                        break;
                    }
                }
                if(isPrimeFlag) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countPrimes3(int n) {
        boolean [] primes = new boolean[n];
        int count = 0;
        for(int i=2;i<n;i++) {
            if(!primes[i]) {
                for(int j=2;j*i<primes.length;j++) {
                    if(!primes[j*i]) {
                        primes[j*i] = true;
                    }
                }
                count++;
            }
        }
        return count;
    }
}