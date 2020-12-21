package us.supercheng.algorithm.problems.algo.palindromecheck;

public class Program {

    public static boolean isPalindrome_Solution1(String str) {
        for (int left=0, right=str.length() - 1; left<right; left++, right--)
            if (str.charAt(left) != str.charAt(right))
                return false;
        return true;
    }

    public static boolean isPalindrome_Solution2(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i=str.length()-1; i>-1; i--)
            sb.append(str.charAt(i));

        return str.equals(sb.toString());
    }

    public static boolean isPalindrome_Solution3(String str) {
        return isPalindrome_Solution3(str, 0, str.length() - 1);
    }

    private static boolean isPalindrome_Solution3(String s, int left, int right) {
        return left >= right || (s.charAt(left) == s.charAt(right) && isPalindrome_Solution3(s, left + 1, right - 1));
    }
}
