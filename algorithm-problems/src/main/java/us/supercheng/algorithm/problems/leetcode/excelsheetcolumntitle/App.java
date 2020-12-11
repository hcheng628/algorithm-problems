package us.supercheng.algorithm.problems.leetcode.excelsheetcolumntitle;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int num = 701; // 2600 52 702 701
        System.out.println(app.toBase26(num));
        System.out.println("----------");
        System.out.println(app.convertToTitle(num));
    }

    public String convertToTitle(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input is not valid!");
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            // System.out.println("n: " + n);
            n--;
            // System.out.println("n: " + n);
            char ch = (char) (n % 26 + 'A');
            // System.out.println("ch: " + ch);

            n /= 26;
            sb.append(ch);
            //System.out.println();
        }
        sb.reverse();
        return sb.toString();
    }

    public String toBase26(int n) {
        if (n < 27) {
            return Character.toString(((char) (n - 1 + 'A')));
        }
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            int curr = n % 26;
            n /= 26;
            list.add(0, curr);
        }
        int index = list.size() - 1;
        int reminder = 0;
        while (index >= 0) {
            int res = list.get(index) - reminder;
            if (res == 0 && index != 0) {
                list.set(index, 26);
                reminder = 1;
            } else {
                list.set(index, res);
                reminder = 0;
            }
            index--;
        }
        String s = "";
        for (int i = 0; i < list.size(); i++) {
            s += (char) (list.get(i) - 1 + 'A');
        }
        return s.replaceAll("@","");
    }
}