package us.supercheng.algorithm.problems.leetcode.countandsay;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.countAndSay(5));
    }

    public String countAndSay(int n){
        String str = "1";
        if (n<=0) {
            return str;
        }
        char prev;
        int count = 0;
        for (int m=1; m<n; m++) {
            StringBuilder sb = new StringBuilder();
            prev = ',';
            count = 0;
            for (int i=0; i<str.length(); i++) {
                if(prev == str.charAt(i) || prev == ',' ) {
                    count ++;
                } else {
                    sb.append(count + Character.toString(prev));
                    count = 1;
                }
                prev = str.charAt(i);
            }
            sb.append(count + Character.toString(prev));
            str = sb.toString();
        }
        return str;
    }
}