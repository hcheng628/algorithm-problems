package us.supercheng.algorithm.problems.leetcode.primenumberofsetbitsinbinaryrepresentation;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        int a = 5, b=15;
        PrintHelper.echoLn(new App().countPrimeSetBits1(a, b));
        PrintHelper.echoLn(new App().countPrimeSetBits2(a, b));
        PrintHelper.echoLn(new App().countPrimeSetBits(a, b));
    }

    private boolean isPrime(int num, Map<Integer, Boolean> map) {
        if(num % 2 == 0) {
            map.put(num, false);
            return false;
        }
        for(int i=3;i*i<=num;i+=2) {
            if(num%i==0) {
                map.put(num, false);
                return false;
            }
        }
        map.put(num, true);
        return true;
    }

    public int countPrimeSetBits1(int L, int R) {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(1, false);
        map.put(2, true);
        map.put(3, true);

        int ret = 0;
        for(int i=L; i<=R;i++) {
            int count = 0;
            char[] chars = Integer.toBinaryString(i).toCharArray();
            for(char each : chars)
                if(each == '1')
                    count++;
            if(map.containsKey(count) && map.get(count))
                ret++;
            else if (!map.containsKey(count)) {
                if(isPrime(count, map))
                    ret++;
            }
        }
        return ret;
    }

    public int countPrimeSetBits(int L, int R) {
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(1, false);
        map.put(2, true);
        map.put(3, true);
        int ret = 0;
        for(int i=L; i<=R;i++) {
            int count = Integer.bitCount(i);
            if(map.containsKey(count) && map.get(count))
                ret++;
            else if (!map.containsKey(count)) {
                if(isPrime(count, map))
                    ret++;
            }
        }
        return ret;
    }

    public int countPrimeSetBits2(int L, int R) {
        int ret = 0;
        for(int i=L; i<=R;i++)
            if(isPrime(Integer.bitCount(i)))
                ret++;
        return ret;
    }

    private boolean isPrime(int num) {
        if(num == 2 ||
                num == 3 ||
                num == 5 ||
                num == 7 ||
                num == 11 ||
                num == 13 ||
                num == 17 ||
                num == 19 ||
                num == 23 ||
                num == 29 ||
                num == 31
                )
            return true;
        return false;
    }
}