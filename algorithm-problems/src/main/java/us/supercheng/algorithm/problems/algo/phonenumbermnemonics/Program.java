package us.supercheng.algorithm.problems.algo.phonenumbermnemonics;

import java.util.*;

public class Program {

    // Time: O(4^n*n) Space: O(4^n*n)
    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        ArrayList<String> ret = new ArrayList<>();
        int len = phoneNumber.length();
        Map<Integer, List<Character>> map = new HashMap<>();

        map.put(0, Arrays.asList('0'));
        map.put(1, Arrays.asList('1'));
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        this.helper(ret, phoneNumber, len, 0, map, new char[len]);
        return ret;
    }

    private void helper(ArrayList<String> ret, String phone, int len, int idx, Map<Integer, List<Character>> map, char[] chars) {
        if (idx == len) {
            ret.add(String.valueOf(chars));
            return;
        }

        for (Character c : map.get(phone.charAt(idx) - '0')) {
            if (chars[idx] != c)
                chars[idx] = c;
            this.helper(ret, phone, len, idx+1, map, chars);
        }
    }

}