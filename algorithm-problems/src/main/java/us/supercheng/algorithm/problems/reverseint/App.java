package us.supercheng.algorithm.problems.reverseint;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.reverse(321123221));
    }

    public int reverse(int x) {
        if (x==0) {
            return 0;
        }
        String xStr = x + "";
        String returnStr = "";
        try {
            if(x >0) {
                for (int i = xStr.length(); i > 0;i--) {
                    returnStr +=  xStr.charAt(i-1);
                }
                return Integer.parseInt(returnStr);
            }else{
                for (int i = xStr.length(); i > 1;i--) {
                    returnStr +=  xStr.charAt(i-1);
                }
                return Integer.parseInt("-" + returnStr);
            }
        } catch (NumberFormatException ex) {
            return 0;
        }

    }
}