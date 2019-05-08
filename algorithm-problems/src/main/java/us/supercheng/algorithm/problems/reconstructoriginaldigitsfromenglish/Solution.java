package us.supercheng.algorithm.problems.reconstructoriginaldigitsfromenglish;

import java.util.HashMap;

class Solution {
    public String originalDigits(String s) {
        HashMap<Character, Integer> repMap = new HashMap<>();
        HashMap<Integer, Integer> resMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (char each : s.toCharArray())
            repMap.put(each, repMap.getOrDefault(each, 0) + 1);

        // zero
        while (repMap.containsKey('z') && repMap.get('z') > 0) {
            repMap.put('z', repMap.get('z')-1);
            repMap.put('e', repMap.get('e')-1);
            repMap.put('r', repMap.get('r')-1);
            repMap.put('o', repMap.get('o')-1);
            resMap.put(0, resMap.getOrDefault(0, 0) + 1);
        }

        // six
        while (repMap.containsKey('x') && repMap.get('x') > 0) {
            repMap.put('s', repMap.get('s')-1);
            repMap.put('i', repMap.get('i')-1);
            repMap.put('x', repMap.get('x')-1);
            resMap.put(6, resMap.getOrDefault(6, 0) + 1);
        }

        //seven
        while (repMap.containsKey('s') && repMap.get('s') > 0 && repMap.containsKey('e') && repMap.get('e') > 1 && repMap.containsKey('v') && repMap.get('v') > 0 && repMap.containsKey('n') && repMap.get('n') > 0) {
            repMap.put('s', repMap.get('s')-1);
            repMap.put('e', repMap.get('e')-2);
            repMap.put('v', repMap.get('v')-1);
            repMap.put('n', repMap.get('n')-1);
            resMap.put(7, resMap.getOrDefault(7, 0) + 1);
        }

        //five
        while (repMap.containsKey('v') && repMap.get('v') > 0 && repMap.containsKey('i') && repMap.get('i') > 0 && repMap.containsKey('e') && repMap.get('e') > 0) {
            repMap.put('f', repMap.get('f')-1);
            repMap.put('i', repMap.get('i')-1);
            repMap.put('v', repMap.get('v')-1);
            repMap.put('e', repMap.get('e')-1);
            resMap.put(5, resMap.getOrDefault(5, 0) + 1);
        }

        // four
        while (repMap.containsKey('f') && repMap.get('f') > 0 && repMap.containsKey('o') && repMap.get('o') > 0 && repMap.containsKey('u') && repMap.get('u') > 0 && repMap.containsKey('r') && repMap.get('r') > 0) {
            repMap.put('f', repMap.get('f')-1);
            repMap.put('o', repMap.get('o')-1);
            repMap.put('u', repMap.get('u')-1);
            repMap.put('r', repMap.get('r')-1);
            resMap.put(4, resMap.getOrDefault(4, 0) + 1);
        }

        //three
        while (repMap.containsKey('r') && repMap.get('r') > 0 && repMap.containsKey('t') && repMap.get('t') > 0 && repMap.containsKey('h') && repMap.get('h') > 0 && repMap.containsKey('e') && repMap.get('e') > 1) {
            repMap.put('t', repMap.get('t')-1);
            repMap.put('h', repMap.get('h')-1);
            repMap.put('r', repMap.get('r')-1);
            repMap.put('e', repMap.get('e')-2);
            resMap.put(3, resMap.getOrDefault(3, 0) + 1);
        }

        // eight
        while (repMap.containsKey('e') && repMap.get('e') > 0 && repMap.containsKey('t') && repMap.get('t') > 0 && repMap.containsKey('i') && repMap.get('i') > 0 && repMap.containsKey('g') && repMap.get('g') > 0 && repMap.containsKey('h') && repMap.get('h') > 0) {
            repMap.put('e', repMap.get('e')-1);
            repMap.put('i', repMap.get('i')-1);
            repMap.put('g', repMap.get('g')-1);
            repMap.put('h', repMap.get('h')-1);
            repMap.put('t', repMap.get('t')-1);
            resMap.put(8, resMap.getOrDefault(8, 0) + 1);
        }

        // two
        while (repMap.containsKey('t') && repMap.get('t') > 0 && repMap.containsKey('w') && repMap.get('w') > 0 && repMap.containsKey('o') && repMap.get('o') > 0) {
            repMap.put('t', repMap.get('t')-1);
            repMap.put('w', repMap.get('w')-1);
            repMap.put('o', repMap.get('o')-1);
            resMap.put(2, resMap.getOrDefault(2, 0) + 1);
        }

        // one
        while (repMap.containsKey('o') && repMap.get('o') > 0 && repMap.containsKey('n') && repMap.get('n') > 0 && repMap.containsKey('e') && repMap.get('e') > 0) {
            repMap.put('o', repMap.get('o')-1);
            repMap.put('n', repMap.get('n')-1);
            repMap.put('e', repMap.get('e')-1);
            resMap.put(1, resMap.getOrDefault(1, 0) + 1);
        }

        // nine
        while (repMap.containsKey('e') && repMap.get('e') > 0) {
            repMap.put('n', repMap.get('n')-2);
            repMap.put('i', repMap.get('i')-1);
            repMap.put('e', repMap.get('e')-1);
            resMap.put(9, resMap.getOrDefault(9, 0) + 1);
        }

        for (int i=0;i<10;i++)
            for (int j=0;resMap.containsKey(i) && j<resMap.get(i);j++)
                sb.append(i);

        return sb.toString();
    }
}