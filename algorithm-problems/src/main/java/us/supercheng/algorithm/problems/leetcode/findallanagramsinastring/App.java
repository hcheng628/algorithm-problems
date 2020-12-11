package us.supercheng.algorithm.problems.leetcode.findallanagramsinastring;

import us.supercheng.algorithm.common.helper.PrintHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        App app = new App();
        String s = "abab";
        String p = "ab";
        PrintHelper.echo("[ ");
        for(int each : app.findAnagrams(s, p))
            PrintHelper.echo(each + " ");
        PrintHelper.echo("]\n");


        PrintHelper.echo("[ ");
        for(int each : app.findAnagramsWindow(s, p))
            PrintHelper.echo(each + " ");
        PrintHelper.echo("]");
    }

    public List<Integer> findAnagramsWindow(String s, String p) {
        List<Integer> ret = new ArrayList<>();
        if(s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length())
            return ret;
        int [] windows = new int[26];
        int [] arr = new int [26];
        int size = p.length();
        for(int i=0;i<size;i++) {
            arr[s.charAt(i) - 97]++;
            windows[p.charAt(i) - 97]++;
        }
        char prevIndex = '-';
        for(int i=0;i<s.length() - size + 1;i++) {
            if(i > 0) {
                arr[prevIndex-97]--;
                arr[s.charAt(i + size - 1)-97]++;
            }
            if(this.isAnagramsWindow(arr, windows)) {
                ret.add(i);
            }
            prevIndex = s.charAt(i);
        }
        return ret;
    }

    public boolean isAnagramsWindow(int [] arr, int [] window) {
        for(int i=0;i<26;i++)
            if(arr[i] != window[i])
                return false;
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        p = String.valueOf(pArr);
        char[] arr = s.toCharArray();
        List<Integer> ret = new ArrayList<Integer>();
        for(int i=0;i<arr.length-p.length()+1;i++) {
            if(this.isAnagrams(i, i+p.length(), arr, p)) {
                ret.add(i);
            }
        }
        return ret;
    }

    private boolean isAnagrams(int startIndex, int endIndex, char[] arr, String p) {
        char[] tempArr = Arrays.copyOfRange(arr, startIndex, endIndex);
        Arrays.sort(tempArr);
        return String.valueOf(tempArr).equals(p);
    }
}
