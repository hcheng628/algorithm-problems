package us.supercheng.algorithm.problems.lengthoflastword;

public class App {
    
    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.lengthOfLastWord("Hello World    "));
    }

    public int lengthOfLastWord(String s) {
        if(s==null) {
            return 0;
        }
        int size = 0;
        int loopCount = s.length()-1;
        for(int i=loopCount;i>=0;i--) {
            char each = s.charAt(i);
            if(i == loopCount && each == ' '){
                loopCount--;
            } else {
                if (each != ' ') {
                    size++;
                } else {
                    break;
                }
            }
        }
        return size;
    }
}