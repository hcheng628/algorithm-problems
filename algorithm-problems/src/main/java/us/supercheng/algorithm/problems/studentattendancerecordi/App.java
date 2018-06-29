package us.supercheng.algorithm.problems.studentattendancerecordi;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String [] args) {
        String s =  "PPALLP";
        PrintHelper.echoLn(new App().checkRecord(s));
    }

    public boolean checkRecord(String s) {
        char [] chars = s.toCharArray();
        int counter = 0, counterAbs = 0;
        for(int i=0;i<chars.length;i++) {
            char each = chars[i];
            if(each == 'L') {
                counter++;
                if(counter == 3)
                    return false;
            }
            else
                counter = 0;
            if(each == 'A') {
                counterAbs++;
                if(counterAbs == 2)
                    return false;
            }
        }
        return true;
    }
}