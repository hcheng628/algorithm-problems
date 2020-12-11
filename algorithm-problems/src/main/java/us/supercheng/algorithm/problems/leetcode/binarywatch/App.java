package us.supercheng.algorithm.problems.leetcode.binarywatch;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

    }

    public List<String> readBinaryWatch(int num) {
        int [] moments = {1,2,4,8,16,32};
        List<String> list = new ArrayList<>();
        for(int hour=0;hour<12;hour++) {
            for(int min=0;min<60;min++) {
                if (this.countDigits(hour, min, moments) == num)
                    list.add(hour+ ":" + (min > 9 ? min + "" : "0" + min));
            }
        }
        return list;
    }

    private int countDigits(int hour, int min, int[] moments) {
        int count = 0;
        for(int i=3;i>=0;i--) {
            if(hour - moments[i] >= 0) {
                hour -= moments[i];
                count++;
            }
        }
        for(int i=5;i>=0;i--) {
            if(min - moments[i] >=0) {
                min -= moments[i];
                count++;
            }
        }
        return count;
    }
}