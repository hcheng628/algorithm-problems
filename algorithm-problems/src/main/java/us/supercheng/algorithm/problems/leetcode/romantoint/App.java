package us.supercheng.algorithm.problems.leetcode.romantoint;

public class App {

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.romanToInt("CDXX"));
    }

    public int romanToInt(String s) {
        int intVal = 0;
        char c = ',';
        char nextC = ',';
        int len = s.length();
        for(int i =0; i<len;i++) {
            c = s.charAt(i);
            if((i+1) < len){
                nextC = s.charAt(i + 1);
            }
            switch(c) {
                case 'I':
                    switch(nextC) {
                        case 'V':
                            intVal += 4;
                            i++;
                            break;
                        case 'X':
                            intVal += 9;
                            i++;
                            break;
                        default:
                            intVal += 1;
                    }
                    break;
                case 'V':
                    intVal += 5;
                    break;
                case 'X':
                    switch(nextC) {
                        case 'L':
                            intVal += 40;
                            i++;
                            break;
                        case 'C':
                            intVal += 90;
                            i++;
                            break;
                        default:
                            intVal += 10;
                    }
                    break;
                case 'L':
                    intVal += 50;
                    break;
                case 'C':
                    switch(nextC) {
                        case 'D':
                            intVal += 400;
                            i++;
                            break;
                        case 'M':
                            intVal += 900;
                            i++;
                            break;
                        default:
                            intVal += 100;
                    }
                    break;
                case 'D':
                    intVal += 500;
                    break;
                case 'M':
                    intVal += 1000;
                    break;
            }
        }
        return intVal;
    }
}