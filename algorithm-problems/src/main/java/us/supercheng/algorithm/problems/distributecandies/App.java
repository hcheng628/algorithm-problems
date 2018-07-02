package us.supercheng.algorithm.problems.distributecandies;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;
import java.util.HashSet;

public class App {

    public static void main(String [] args) {
        int [] arr = {1,1,2,2,3,3};
        PrintHelper.echoLn(new App().distributeCandies(arr));
        PrintHelper.echoLn(new App().distributeCandies2(arr));
    }


    public int distributeCandies2(int[] candies) {
        Arrays.sort(candies);
        int count = 0;
        Integer prev = null;
        for(int i=0;i<candies.length-1;i++) {
            if(candies[i] != candies[i+1]) {
                count++;
                prev = candies[i];
            }
        }

        if(prev == null)
            count++;
        else if(candies[candies.length -1] != prev)
            count++;

        if(count >= candies.length / 2)
            return candies.length / 2;
        return count;
    }

    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for(int each : candies)
            set.add(each);
        if(set.size() >= candies.length / 2)
            return candies.length / 2;
        return set.size();
    }
}