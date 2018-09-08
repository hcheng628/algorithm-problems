package us.supercheng.algorithm.problems.binarygap;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        int N = 22;
        PrintHelper.echoLn(new App().binaryGap(N));
        PrintHelper.echoLn(new App().binaryGap1(N));
    }

    public int binaryGap(int N) {
        char[] chars = Integer.toBinaryString(N).toCharArray();
        int ret = 0, oneA = -1, oneB = -1;
        for(int i=0;i<chars.length;i++) {
            if(chars[i] == '1') {
                if (oneA == -1)
                    oneA = i;
                else {
                    if(oneB != -1)
                        oneA = oneB;
                    oneB = i;
                    ret = Math.max(ret, oneB-oneA);
                }
            }
        }
        return ret;
    }

    public int binaryGap1(int N) {
        int ret = 0, first = -1, second = -1;
        for(int i=0;N>0&&i<32;i++,N = N>>1) {
            if((N & 1) == 1) {
                if(first == -1)
                    first = i;
                else if (second == -1) {
                    second = i;
                    ret = Math.max(ret, second - first);
                } else {
                    first = second;
                    second = i;
                    ret = Math.max(ret, second - first);
                }

            }
        }
        return ret;
    }
}
