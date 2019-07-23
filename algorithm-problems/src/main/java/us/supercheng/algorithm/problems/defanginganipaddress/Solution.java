package us.supercheng.algorithm.problems.defanginganipaddress;

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder(address);
        Integer a = null,
                b = null,
                c = null,
                LEN = address.length();

        for (int i=0;i<LEN;i++)
            if (address.charAt(i) == '.') {
                if (a == null) {
                    a = i;
                    continue;
                }

                if (b == null) {
                    b = i;
                    continue;
                }

                if (c == null) {
                    c = i;
                    break;
                }
            }

        this.insertHelper(sb, c+1, c);
        this.insertHelper(sb, b+1, b);
        this.insertHelper(sb, a+1, a);
        return sb.toString();
    }

    private void insertHelper(StringBuilder sb, int idx1, int idx2) {
        sb.insert(idx1, ']');
        sb.insert(idx2, '[');
    }
}
