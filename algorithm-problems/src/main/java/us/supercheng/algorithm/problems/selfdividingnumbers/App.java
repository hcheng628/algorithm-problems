package us.supercheng.algorithm.problems.selfdividingnumbers;

import us.supercheng.algorithm.common.helper.PrintHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int left = 28, right = 132231;
        for(int each : new App().selfDividingNumbers(left, right)) {
            PrintHelper.echo(each + " ");
        }
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ret = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=left; i<=right; i++) {
            char [] digits = (i + "").toCharArray();
            boolean isSelfDiv = true, hasZero = false;
            if(!set.isEmpty())
                set.clear();
            for(char digit : digits) {
                if(digit == '0') {
                    hasZero = true;
                    break;
                }
                set.add(((int)digit) - 48);
            }

            if(hasZero)
                continue;

            for (int each : set) {
                if(i%each != 0) {
                    isSelfDiv = false;
                    break;
                }
            }
            if(isSelfDiv)
                ret.add(i);
        }
        return ret;
    }
}