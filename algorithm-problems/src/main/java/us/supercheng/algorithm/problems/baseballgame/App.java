package us.supercheng.algorithm.problems.baseballgame;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.LinkedList;

public class App {

    public static void main(String[]  args) {
        String [] arr = {"5","-2","4","C","D","9","+","+"};
        PrintHelper.echoLn("Points: " + new App().calPoints(arr));
        PrintHelper.echoLn("Points: " + new App().calPoints2(arr));
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

    public int calPoints2(String[] ops) {
        int sum = 0;
        int index = 0;
        int [] arr = new int [ops.length];
        for(int i=0;i<ops.length;i++) {
            String each = ops[i];
            if(each.equals("C")) {
                sum -= arr[index-1];
                arr[index - 1] = 0;
                index--;
            } else {
                if(each.equals("+"))
                    arr[index] = arr[index-1] + arr[index-2];
                else if (each.equals("D"))
                    arr[index] = arr[index-1] * 2;
                else
                    arr[index] = Integer.parseInt(ops[i]);
                sum += arr[index];
                index++;
            }
        }
        return sum;
    }
}