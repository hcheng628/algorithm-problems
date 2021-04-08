package us.supercheng.algorithm.problems.algo.firstnonrepeatingcharacter;

public class Program {

    public int firstNonRepeatingCharacter(String string) {
        int[] bucket = new int[26];

        for (char c : string.toCharArray())
            bucket[c - 'a']++;

        for (int i=0, len=string.length(); i<len; i++)
            if (bucket[string.charAt(i) - 'a'] == 1)
                return i;

        return -1;
    }
}
