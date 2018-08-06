package us.supercheng.algorithm.problems.onebitand2bitcharacters;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [] bits =  {1, 0, 0};
        PrintHelper.echoLn(new App().isOneBitCharacter(bits));
    }

    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length == 1)
            return true;
        if(bits[bits.length -1] == 0 && bits[bits.length-2] == 0)
            return true;
        else {
            int i=0;
            while(i<bits.length-1) {
                if(bits[i]==0)
                    i++;
                else
                    i+=2;
            }
            return i == bits.length -1;
        }
    }
}
