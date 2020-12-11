package us.supercheng.algorithm.problems.leetcode.solvetheequation;

class Solution {

    class Part {

        int x;
        int num;

        public String toString() {
            return this.x + "x and " + this.num;
        }
    }

    public String solveEquation(String equation) {
        String[] arr = equation.split("=");
        Part leftP = this.parseE(arr[0].toCharArray(), new StringBuilder()),
             rightP = this.parseE(arr[1].toCharArray(), new StringBuilder()),
             res = new Part();

        res.x = rightP.x > 0 ? leftP.x - rightP.x : leftP.x + (-rightP.x);
        res.num = rightP.num > 0 ? leftP.num - rightP.num : leftP.num + (-rightP.num);
        //this.echo("Left-> " + leftP + "\r\nRight-> " + rightP + "\r\nRes-> " + res);

        if (res.x == 0 && res.num == 0)
            return "Infinite solutions";
        else if (res.x == 0)
            return "No solution";
        return "x=" + -res.num/res.x;
    }

    private Part parseE(char[] chars, StringBuilder sb) {
        Part p = new Part();
        char sign = '+';
        for (char c : chars) {
            if (c == '+' || c == '-') {
                this.updatePart(sb, p);
                sign = c;
                if (sign == '-')
                    sb.append(c);
                continue;
            }
            sb.append(c);
        }
        this.updatePart(sb, p);
        return p;
    }

    private void updatePart(StringBuilder sb, Part p) {
        if (sb.length() != 0) {
            String s = sb.toString();
            if (s.indexOf("x") > -1) {
                if (s.equals("x"))
                    p.x +=1;
                else if (s.equals("-x"))
                    p.x -=1;
                else
                    p.x += Integer.parseInt(s.substring(0, s.length()-1));
            } else
                p.num += Integer.parseInt(s);
            sb.setLength(0);
        }
    }

    private void echo(Object o) {
        System.out.println(o);
    }
}