package us.supercheng.algorithm.problems.leetcode.validateipaddress;

class Solution {

    public String validIPAddress(String IP) {
        if (IP == null || IP.length() < 1)
            return "Neither";

        int len = IP.length();
        if (this.isIPv4(IP, len))
            return "IPv4";
        if (this.isIPv6(IP, len))
            return "IPv6";
        return "Neither";
    }

    private boolean isIPv4(String IP, int len) {
        String[] parts = this.splitHelper(IP, "\\.", '.', len-1, 4);
        if (parts == null)
            return false;

        for (int i=0;i<4;i++) {
            int partsLen = parts[i].length();
            if (partsLen == 1) {
                if (!this.isInRange(parts[i].charAt(0) - '0', 0, 9))
                    return false;
            } else if (partsLen == 2) {
                char c = parts[i].charAt(0);
                if ((c == '0') || (!this.isInRange(c-'0', 0, 9) || !this.isInRange(parts[i].charAt(1)-'0', 0, 9)))
                    return false;
            } else if (partsLen == 3) {
                char c = parts[i].charAt(0),
                        cc = parts[i].charAt(1);
                if (c == '1') {
                    if (!this.isInRange(parts[i].charAt(1)-'0', 0, 9) || !this.isInRange(parts[i].charAt(2)-'0',0,9))
                        return false;
                } else if (c == '2') {
                    if (!this.isInRange(cc - '0', 0, 5))
                        return false;
                    if (cc == '5')
                        if (!this.isInRange(parts[i].charAt(2) - '0', 0, 5))
                            return false;
                        else
                        if (!this.isInRange(parts[i].charAt(2) - '0', 0, 9))
                            return false;
                } else
                    return false;
            } else
                return false;
        }
        return true;
    }

    private boolean isIPv6(String IP, int len) {
        IP = IP.toLowerCase();
        String[] parts = this.splitHelper(IP, ":", ':', len-1, 8);
        if (parts == null)
            return false;

        for (int i=0;i<8;i++) {
            if (!this.isInRange(parts[i].length(), 1, 4))
                return false;
            for (char each : parts[i].toCharArray())
                if (each == 'a' || each == 'b' || each == 'c' || each == 'd' || each == 'e' || each == 'f' ||
                        each == '0' || each == '1' || each == '2' || each == '3' || each == '4' ||
                        each == '5' || each == '6' || each == '7' || each == '8' || each == '9')
                    continue;
                else
                    return false;
        }
        return true;
    }

    private String[] splitHelper(String IP, String splitS, char splitC, int lastIdx, int len) {
        String[] parts = IP.split(splitS);
        if (parts.length != len || IP.charAt(lastIdx) == splitC)
            return null;
        return parts;
    }

    private boolean isInRange(int res, int lowerB, int upperB) {
        return res >= lowerB && res <= upperB;
    }
}