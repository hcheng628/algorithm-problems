package us.supercheng.algorithm.problems.convertanumbertohexadecimal;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public String toHex_BIT(int num) {
        if (num == 0)
            return "0";

        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<8 && num != 0;i++) {
            int key = num & 0b1111;
            sb.insert(0, map[key]);
            num = num >> 4;
        }

        return sb.toString();
    }

    public String toHex(int num) {
        if (num == 0)
            return "0";

        Map<String, Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        boolean isPos = num >= 0;
        String res = null;
        int zero = 0;

        map.put("0000", '0');
        map.put("0001", '1');
        map.put("0010", '2');
        map.put("0011", '3');
        map.put("0100", '4');
        map.put("0101", '5');
        map.put("0110", '6');
        map.put("0111", '7');
        map.put("1000", '8');
        map.put("1001", '9');
        map.put("1010", 'a');
        map.put("1011", 'b');
        map.put("1100", 'c');
        map.put("1101", 'd');
        map.put("1110", 'e');
        map.put("1111", 'f');


        for (int n = Math.abs(num);n != 0;n /= 2)
            sb.append(n % 2);

        while (sb.length() < 32)
            sb.append('0');

        if (isPos)
            res = sb.reverse().toString();
        else {
            char[] temp = new char[32];
            for (int i=0;i<32;i++)
                temp[i] = sb.charAt(i) == '1' ? '0' : '1';
            res = this.addOne(new StringBuilder(new String(temp)).reverse().toString().toCharArray());
        }

        sb.setLength(0);
        for (int i=0;i<29;i+=4)
            sb.append(map.get(res.substring(i, i+4)));


        while (zero < sb.length() && sb.charAt(zero) == '0')
            zero++;

        return sb.substring(zero);
    }


    private String addOne(char[] chars) {
        if (new String(chars).equals("11111111111111111111111111111111"))
            return "10000000000000000000000000000000";

        boolean round = false;

        if (chars[31] == '0')
            chars[31] = '1';
        else {
            chars[31] = '0';
            round = true;
        }

        for (int i=30; round && i>-1; i--)
            if (chars[i] == '0') {
                chars[i] = '1';
                round = false;
            } else {
                chars[i] = '0';
                round = true;
            }

        return new String(chars);
    }
}