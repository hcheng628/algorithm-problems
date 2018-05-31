package us.supercheng.algorithm.problems.adddigits;

public class App {

    public static void main(String [] args) {
        App app = new App();
        System.out.println(app.addDigits(120));
        System.out.println(app.addDigits2(120));
    }

    public int addDigits(int num) {
        String numS = num + "";
        if(numS.length() < 2) {
            return num;
        }
        boolean goFlag = true;
        int tempSum = 0;
        while(goFlag) {
            tempSum = 0;
            for(int i=0;i<numS.length();i++)
                tempSum += Integer.parseInt(numS.charAt(i) + "");
            if(tempSum >9)
                numS=tempSum+"";
            else
                goFlag = false;
        }
        return tempSum;
    }

    public int addDigits2(int num) {
        if(num == 0)
            return 0;
        int ret = num % 9;
        if(ret == 0)
            return 9;
        else
            return ret;
    }
}
