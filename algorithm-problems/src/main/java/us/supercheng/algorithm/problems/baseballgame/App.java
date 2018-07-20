package us.supercheng.algorithm.problems.baseballgame;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.LinkedList;

public class App {

    public static void main(String[]  args) {
        String [] arr = {"5","-2","4","C","D","9","+","+"};
        PrintHelper.echoLn("Points: " + new App().calPoints(arr));
    }

    public int calPoints(String[] ops) {
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();
        int index = 0;

        for(int i=0;i<ops.length;i++) {
            if(ops[i].equals("+")) {
                list.add(list.get(index-1) + list.get(index-2));
                index++;
            } else if (ops[i].equals("D")) {
                list.add(list.get(index-1) * 2);
                index++;
            } else if (ops[i].equals("C")) {
                list.remove(index-1);
                index--;
            } else {
                list.add(Integer.parseInt(ops[i]));
                index++;
            }
        }

        for(int each : list)
            sum += each;
        return sum;
    }
}