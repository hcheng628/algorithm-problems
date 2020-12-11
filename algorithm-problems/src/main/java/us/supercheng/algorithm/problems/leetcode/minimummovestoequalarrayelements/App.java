package us.supercheng.algorithm.problems.leetcode.minimummovestoequalarrayelements;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int [] arr = {21,32,123,12,32,12,32,232,91,232,123};
        PrintHelper.echoLn(app.minMoves(arr));
    }

    public int minMoves(int[] nums) {
        int count = 0;
        int min = Integer.MAX_VALUE;
        for(int each : nums)
            if(each < min)
                min = each;
        for(int each : nums)
            if(min != each)
                count += each - min;
        return count;
    }
}