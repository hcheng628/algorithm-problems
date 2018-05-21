package us.supercheng.algorithm.problems.reversebits;

public class App {

    public static void main(String[] args) {
        App app = new App();
        /*
        System.out.println(app.reverseBits(43261596));
        int val = app.binaryToBase10("11111111111111111111111111111111");
        System.out.println("\r\nVal: " + val);
        */

        int val = 10;
        System.out.println(Integer.toBinaryString(val));
        System.out.println(app.reverseBits1(val));
        System.out.println(app.reverseBits2(val));

        /*
        int a = 9;
        int b = 4;
        System.out.println("Before a: " + Integer.toBinaryString(a) + " " + a);
        a = a & 1;
        System.out.println("After a: " + Integer.toBinaryString(a) + " " + a);

        for(int i=0;i<10;i++) {
            b = b + (a & 1);
            System.out.println("After b: " + Integer.toBinaryString(b) + " " + b);
        }
        */
    }

    public int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        if(n == 1) {
            return Integer.MAX_VALUE;
        }

        for(int i=binaryString.length(); i < 32;i++) {
            binaryString = "0" + binaryString;
        }
        System.out.println("binaryString: " + binaryString);
        /*
        for(int i=31;i>=0;i--) {
            char currChar = binaryString.charAt(31);
            binaryString = binaryString.substring(0,31);
            binaryString = currChar + binaryString;
        }
        */
        binaryString = new StringBuilder(binaryString).reverse().toString();
        System.out.println("binaryString: " + binaryString);
        return Integer.parseInt(binaryString, 2);
    }

    public Integer binaryToBase10(String binaryStr) {
        Double res = 0.0;
        for(int i=31;i>=0;i--) {
            System.out.println("i: " + i);
            res  += Math.pow(2, i) * Double.parseDouble(binaryStr.charAt(31 -i) + "");
        }
        System.out.printf("%f", res);
        return res.intValue();
    }

    public int reverseBits1(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            System.out.println("Round: " + (i + 1));
            System.out.println( " >>> 1 :result: " + Integer.toBinaryString(result));
            //System.out.println( " >>> 1 :nnnnnn: " + Integer.toBinaryString(n));
            n >>>= 1;   // 必须进行无符号位移
            //System.out.println( " >>> 2 :nnnnnn: " + Integer.toBinaryString(n));
            if (i < 31) { // 最后一次不需要进行位移
                result <<= 1;
            }
            System.out.println( " >>> 2 :result: " + Integer.toBinaryString(result));


        }
        return result;
    }

    public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & 1) == 1) {
                result = (result << 1) + 1;
            } else {
                result = result << 1;
            }
            n = n >> 1;
        }
        return result;
    }
}
