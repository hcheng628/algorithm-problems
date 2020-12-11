package us.supercheng.algorithm.problems.leetcode.longestwordindictionary;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.*;

public class App {

    public static void main(String [] args) {
        String [] arr = {"k","lg","it","oidd","oid","oiddm","kfk","y","mw","kf","l","o","mwaqz","oi","ych","m","mwa"};
        PrintHelper.echoLn(new App().longestWord(arr));
    }

    public String longestWord1(String[] words) {
        String ret = null;

        HashSet<String> set = new HashSet<>();

        for(String word : words)
            set.add(word);
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(a.length() == b.length())
                    return a.compareTo(b);
                return a.length() - b.length();
            }
        });

        int max = 0;
        for(int i=words.length-1;i>=0;i--) {
            String each = words[i];
            boolean goodWord = true;
            int index = 1;
            for(;index<each.length() && goodWord;index++) {
                if(!set.contains(each.substring(0, index)))
                    goodWord = false;
            }
            if(goodWord && index > max && ret != null) {
                max = index;
                ret = each;
            } else if (goodWord && ret == null) {
                max = index;
                ret = each;
            } else if (goodWord && index == max && ret != null && each.compareTo(ret) < 0)
                ret = each;
            else if (ret != null && max > index)
                break;
        }
        return ret;
    }

    public String longestWord(String[] words) {
        Arrays.sort(words);
        String ret = "";
        HashSet<String> set = new HashSet<>();
        for(String word : words) {
            if(word.length() == 1 || set.contains(word.substring(0, word.length()-1))) {
                if(word.length() > ret.length())
                    ret = word;
                set.add(word);
            }
        }
        return ret;
    }
}