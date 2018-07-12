package us.supercheng.algorithm.problems.distributecandies;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class App {

    public static void main(String [] args) {
        int [] arr = {1,1,2,2,3,3};
        PrintHelper.echoLn(new App().distributeCandies(arr));
        PrintHelper.echoLn(new App().distributeCandies2(arr));
        PrintHelper.echoLn(new App().distributeCandies3(arr));
        PrintHelper.echoLn(new App().distributeCandies4(arr));
    }

    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for(int each : candies)
            set.add(each);
        return set.size() >= candies.length / 2 ? candies.length / 2 : set.size();
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
        return count >= candies.length / 2 ? candies.length / 2 : count;
    }

    public int distributeCandies3(int[] candies) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<candies.length;i++)
            map.put(candies[i], map.getOrDefault(candies[i], 0) + 1);
        return map.size() > candies.length / 2 ? candies.length / 2 : map.size();
    }

    public int distributeCandies4(int[] candies) {
        Arrays.sort(candies);
        int count = 0;
        for(int i=0;i<candies.length;i++)
            if(i==0 || candies[i] != candies[i-1])
                count ++;
        return count > candies.length / 2 ? candies.length / 2 : count;
    }
}