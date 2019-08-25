package us.supercheng.algorithm.problems.fractionadditionandsubtraction;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public String fractionAddition(String expression) {

        List<String> list = new ArrayList<>();
        char[] chars = expression.toCharArray();
        int len = chars.length;

        for (int i=0;i<len;i++) {
            StringBuilder sb = new StringBuilder();
            char curr = chars[i];

            if (curr == '-') {
                sb.append('-');
                curr = chars[++i];
            }

            while (i<len && curr != '-' && curr != '+') {
                sb.append(curr);
                if (++i < len)
                    curr = chars[i];
            }

            if (curr == '-')
                i--;
            list.add(sb.toString());

            if (list.size() > 1) {
                String num1 = list.get(0);
                String num2 = list.get(list.size()-1);
                int top1 = Integer.parseInt(num1.split("/")[0]),
                        bot1 = Integer.parseInt(num1.split("/")[1]),
                        top2 = Integer.parseInt(num2.split("/")[0]),
                        bot2 = Integer.parseInt(num2.split("/")[1]),
                        max = 0,
                        top = 0,
                        bot = 0;

                if (bot1 != bot2) {
                    top = top1 * bot2 + top2 * bot1;
                    bot = bot1 * bot2;
                } else {
                    top = top1 + top2;
                    bot = bot1;
                }

                max = Math.max(Math.abs(top), Math.abs(bot));
                Integer res = this.canSimp(top, bot, max);
                while (res != null) {
                    top = top / res;
                    bot = bot / res;
                    max = Math.max(Math.abs(top), Math.abs(bot));
                    res = this.canSimp(top, bot, max);
                }
                list.set(0, top + "/" + bot);
                list.remove(list.size()-1);
            }
        }
        return list.get(0);
    }

    private Integer canSimp(int a, int b, int max) {
        for (int i=max;i>1;i--)
            if (a % i == 0 && b % i == 0)
                return i;
        return null;
    }
}