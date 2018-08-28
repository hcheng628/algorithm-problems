package us.supercheng.algorithm.problems.binarygap;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        int N = 22;
        PrintHelper.echoLn(new App().binaryGap(N));
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
}
