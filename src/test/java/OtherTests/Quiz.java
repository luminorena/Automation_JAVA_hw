package OtherTests;

import java.security.MessageDigest;

public class Quiz {

    public static void main(String[] args) throws Exception {
        System.out.println(maxVarargs(2, 4, 5, 7, 10));
        System.out.println("A" + ('\t' + '\u0003'));
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest("abracadabra".getBytes("UTF-8"));
        for (byte b : digest) {
            System.out.printf("%02x", b);
        }

        System.out.println("-----------");
        double a = -6 << 1;
        int value = 6;
        int bitIndex = 3;
        System.out.println(value ^ (1 << bitIndex));
        int b = '\\';
        System.out.println(b);

        int bitCount = Integer.bitCount(123);
        System.out.println(bitCount);
        System.out.println(isPowerOfTwo(12));


    }
    public static boolean isPowerOfTwo(int value) {
       int absResult = Math.abs(value);
       return Integer.bitCount(absResult) == 1;

    }

    static int maxVarargs(int ... numbers){
        int res = 0;
        for (int i: numbers){
            res+=i;
        }
        return res;
    }






}
