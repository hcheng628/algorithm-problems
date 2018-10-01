package us.supercheng.algorithm.problems.xofakindinadeckofcards;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [] deck = {1,1,1,1,2,2,2,2,2,2};
        PrintHelper.echoLn(new App().hasGroupsSizeX(deck));
    }

    public boolean hasGroupsSizeX(int[] deck) {
        int [] bucket = new int [10001];

        for(int each :  deck)
            bucket[each]++;

        int minCount = Integer.MAX_VALUE;
        for(int each : bucket) {
            if(each == 1)
                return false;
            if(each > 0 && minCount>each)
                minCount = each;
        }

        for(int i=2;i<=minCount;i++)
            for(int j=0;j<bucket.length;j++) {
                if(bucket[j] % i != 0)
                    break;
                if(j== bucket.length-1)
                    return true;
            }
        return false;
    }
}