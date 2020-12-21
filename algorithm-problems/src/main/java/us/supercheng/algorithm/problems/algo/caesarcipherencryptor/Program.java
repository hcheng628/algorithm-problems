package us.supercheng.algorithm.problems.algo.caesarcipherencryptor;

public class Program {

    public static String caesarCypherEncryptor_Solution1(String str, int key) {
        StringBuilder sb = new StringBuilder();
        key = key % 26;

        for (int i=0, len=str.length(); i<len; i++) {
            int idx = str.charAt(i) + key;

            if (idx >= 'a' + 26)
                idx = idx % ('a' + 26) + 'a';

            sb.append(((char) (idx)));
        }

        return sb.toString();
    }

    public static String caesarCypherEncryptor_Solution2(String str, int key) {
        StringBuilder sb = new StringBuilder();
        key = key % 26;
        String s = "abcdefghijklmnopqrstuvwxyz";

        for (int i=0, len=str.length(); i<len; i++)
            sb.append(s.charAt((s.indexOf(str.charAt(i)) + key) % 26));

        return sb.toString();
    }
}
