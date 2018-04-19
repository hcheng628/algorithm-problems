package us.supercheng.algorithm.problems.longestcommonprefix;

public class App {

    public static void main(String[]  args) {
        App app = new App();

        String[] arr = {"aaa",null,"aaa"};
        System.out.println(app.longestCommonPrefix2(arr));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0 ) {
            return "";
        }

        String minStr = null;
        int min = 999999;
        for(int i=0; i<strs.length;i++) {
            String each = strs[i];
            if (each.length() <1) {
                return "";
            }
            if(each.length() < min) {
                minStr = each;
                min = each.length();
            }
        }

        int prefixCount = 0;
        boolean match = true;
        for(int i=0;i<minStr.length(); i++) {
            int matchCount = 0;
            for(int j=0; j< strs.length; j++) {
                if(minStr.charAt(i) == strs[j].charAt(i)) {
                    matchCount++;
                }
            }
            if(matchCount != strs.length) {
                break;
            }
            prefixCount ++;
        }
        return minStr.substring(0,prefixCount);
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0 || strs[0] == null) {
            return "";
        }
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++) {
            if (strs[i] == null) {
                return "";
            }
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }
}