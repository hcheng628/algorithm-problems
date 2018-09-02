package us.supercheng.algorithm.problems.faircandyswap;

import us.supercheng.algorithm.common.helper.PrintHelper;

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
}
