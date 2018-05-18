package us.supercheng.algorithm.problems.pascalstriangleii;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        List<Integer> list = app.getRow3(5);
        Character.isLetterOrDigit('c');

        for (int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + ",");
        }
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevList = new ArrayList<>();
        int count = 0;
        while(count < rowIndex+2) {
            List<Integer> each = new ArrayList<>();
            for(int i=0;i<count;i++) {
                if(i==0 || i == count-1) {
                    each.add(1);
                } else {
                    each.add(prevList.get(i-1) + prevList.get(i));
                }
            }
            prevList = each;
            count++;
        }
        return prevList;
    }

    public List<Integer> getRow2(int rowIndex) {
        List<Integer> prevList = new ArrayList<>();
        int count = 0;
        List<Integer> each = new ArrayList<>();
        while(count < rowIndex+2) {
            each = new ArrayList<>();
            for(int i=0;i<count;i++) {
                if(i==0 || i == count-1) {
                    each.add(1);
                } else {
                    each.add(prevList.get(i-1) + prevList.get(i));
                }
            }
            prevList = each;
            count++;
        }
        return prevList;
    }

    public List<Integer> getRow3(int rowIndex) {
        List<Integer> result=new ArrayList<Integer>();
        result.add(1);
        for(int i=1;i<=rowIndex;i++) {
            System.out.println("Each: " + (int)((long) result.get(i-1)*(rowIndex - (i-1))/i  ));
            result.add((int)((long) result.get(i-1)*(rowIndex - (i-1))/i  ));
        }
        return result;
    }
}