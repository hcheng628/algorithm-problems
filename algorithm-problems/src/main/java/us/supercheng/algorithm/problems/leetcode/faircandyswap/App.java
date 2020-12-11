package us.supercheng.algorithm.problems.leetcode.faircandyswap;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int[] A = {1,2,5}, B = {2,4};
        int[] res = new App().fairCandySwap(A, B);
        PrintHelper.echoLn("Alice: " + res[0] + " Bob: " + res[1]);
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int [] ret = new int[2];
        int sumA=0, sumB=0;
        for(int each : A)
            sumA += each;

        for(int each : B)
            sumB += each;

        if(sumA == sumB) {
            for(int i=0;i<A.length;i++)
                for(int j=0;j<B.length;j++) {
                    if(A[i]==B[j]) {
                        ret[0] = A[i];
                        ret[1] = B[j];
                        return ret;
                    }
                }
        } else {
            int diff = Math.abs(sumA - sumB);
            boolean isABigger = sumA > sumB;
            for(int i=0;i<A.length;i++) {
                for(int j=0;j<B.length;j++) {
                    if(isABigger && (A[i]-B[j]) * 2 == diff) {
                        ret[0] = A[i];
                        ret[1] = B[j];
                        return ret;
                    } else if(!isABigger && (B[j]-A[i]) * 2 == diff){
                        ret[0] = A[i];
                        ret[1] = B[j];
                        return ret;
                    }
                }
            }
        }
        return null;
    }

    public int[] fairCandySwap1(int[] A, int[] B) {
        int [] ret = new int[2];
        int sumA=0, sumB=0;
        for(int each : A)
            sumA += each;
        for(int each : B)
            sumB += each;
        int diff = Math.abs(sumA - sumB) / 2;
        if(sumA > sumB)
            return this.helper(A, B, diff, ret, true);
        else
            return this.helper(B, A, diff, ret, false);
    }

    private int[] helper(int[] A, int [] B, int diff, int [] ret, boolean flag) {
        Arrays.sort(B);
        for(int i=0;i<A.length;i++) {
            int index = Arrays.binarySearch(B,A[i]-diff);
            if(index > -1) {
                if(flag) {
                    ret[0] = A[i];
                    ret[1] = B[index];
                } else {
                    ret[0] = B[index];
                    ret[1] = A[i];
                }
                return ret;
            }
        }
        return null;
    }

    public int[] fairCandySwap2(int[] A, int[] B) {
        int [] ret = new int[2];
        boolean [] db = new boolean[1000001];
        int diff = 0;
        for(int each : A)
            diff += each;
        for(int each: B) {
            diff -= each;
            db[each] = true;
        }
        diff /=2;

        for(int each : A) {
            int res = each - diff;
            if(res>0 && res<db.length && db[res]) {
                ret[0] = each;
                ret[1] = res;
                return ret;
            }
        }
        return null;
    }
}
