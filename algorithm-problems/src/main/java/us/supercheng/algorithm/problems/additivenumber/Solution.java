package us.supercheng.algorithm.problems.additivenumber;

class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i=num.length()/2;i>0;i--)
            for (int j=i+1;Math.max(i, j-i) <= (num.length()-j);j++) {
                String firstS = num.substring(0, i),
                        secondS = num.substring(i, j);
                if (i != 1 && firstS.charAt(0) == '0')
                    break;
                if (j-i != 1 && secondS.charAt(0) == '0')
                    continue;
                if (this.additiveCheck(num.substring(j, num.length()), Long.parseLong(firstS), Long.parseLong(secondS)))
                    return true;
            }
        return false;
    }

    private boolean additiveCheck(String num, long first, long second) {
        if (num.length() == 0)
            return true;
        String res = Long.toString(first + second);

        return num.startsWith(res) && additiveCheck(num.substring(res.length(), num.length()), second, first + second);
    }
}