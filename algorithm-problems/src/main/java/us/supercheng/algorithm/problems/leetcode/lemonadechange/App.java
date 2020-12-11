package us.supercheng.algorithm.problems.leetcode.lemonadechange;

import us.supercheng.algorithm.common.helper.PrintHelper;

public class App {

    public static void main(String[] args) {
        int [] bills = {5,5,5,10,20};
        PrintHelper.echoLn(new App().lemonadeChange(bills));
        PrintHelper.echoLn(new App().lemonadeChange1(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        int[] wallet = new int [11];
        for(int bill : bills) {
            switch(bill) {
                case 5:
                    wallet[5]++;
                    break;

                case 10:
                    if(wallet[5] == 0)
                        return false;
                    wallet[10]++;
                    wallet[5]--;
                    break;

                default:
                    if(wallet[10] == 0) {
                        if(wallet[5] > 2)
                            wallet[5] -=3;
                        else
                            return false;
                    } else {
                        wallet[10]--;
                        if(wallet[5] > 0)
                            wallet[5]--;
                        else
                            return false;
                    }
                    break;
            }
        }
        return true;
    }

    public boolean lemonadeChange1(int[] bills) {
        int bill5=0, bill10=0;
        for(int bill : bills) {
            switch(bill) {
                case 5:
                    bill5++;
                    break;
                case 10:
                    if(bill5 == 0)
                        return false;
                    bill10++;
                    bill5--;
                    break;
                default:
                    if(bill10 == 0) {
                        if(bill5 < 3)
                            return false;
                        bill5 -=3;
                    } else {
                        if(bill5 < 1)
                            return false;
                        bill10--;
                        bill5--;
                    }
                    break;
            }
        }
        return true;
    }
}