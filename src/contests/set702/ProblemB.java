package contests.set702;
      /*
        B. Powers of Two
        time limit per test 3 seconds
        memory limit per test 256 megabytes
        input standard input
        output standard output

        You are given n integers a1, a2, ..., an. Find the number of
        pairs of indexes i, j (i < j) that ai + aj is a power of 2
        (i. e. some integer x exists so that ai + aj = 2^x).

        Input
        The first line contains the single positive integer n (1 ≤ n ≤ 105) — the number of integers.
        The second line contains n positive integers a1, a2, ..., an (1 ≤ ai ≤ 109).

        Output
        Print the number of pairs of indexes i, j (i < j) that ai + aj is a power of 2.

        Examples
        Input
        4
        7 3 2 1
        Output
        2
      */
/**
 * Created by hongbo on 16-11-17.
 */
public class ProblemB {

    public static void main(String[] args) {
        int num = 3;//4;
        int num1 = 4;
        int[] array = {1,1,1};//
        int[] array1 = {7,3,2,1};
        int method = 1;

        //System.out.println(isPowerOf2(24,false));

        switch (method) {
            case 1:
                methodA(num,array);
                break;
            default:
                System.out.println("Choose a method");
        }
    }

    /**
     * brute force, two loops. O(N^2)
     * @param num
     * @param array
     */
    public static void methodA(int num, int[] array) {
        //brute force
        int count = 0;
        for ( int i = 0; i < array.length-1; i++) {
            for ( int j = i+1; j < array.length;j++) {
                //if ( isPower(2,array[i] + array[j]) ) {
                if ( isPowerOf2(array[i] + array[j],true) ) {
                        count++;
                }
            }
        }
        System.out.println(count);
    }


    public static void methodB( int num, int[] array) {
        
    }

    /**
     * determine is value the power of base or not.
     * use recursive
     * @param base base cannot be 1.
     * @param value
     * @return if base if power of value, return true; false otherwise.
     */
    public static boolean isPower(int base, int value) {
       if ( base == 1 ) {
           System.out.println("base cannot be 1");
           return false;
       }
       if ( value == 1 ) {
           return true;
       } else if ( value > 1 && value < base) {
           return false;
       } else {
           if ( value % base != 0 ) {
               return false;
           } else {
               return isPower(base, value / base);
           }
       }

    }

    /**
     * use java.lang.Integer built-in method
     * @param value
     * @return
     */
    public static boolean isPowerOf2(int value) {
        /*
        if ( (value & 0xFFFFFFFF) == 1) { // 0b1111_1111_1111_1111_1111_1111_1111_1111)
            return true;
        } else {
            return false;
        }
        */
        if ( Integer.bitCount(value) == 1) return true;
        return false;
   }

    /**
     * bitwise operation
     * Hamming weight
     * https://en.wikipedia.org/wiki/Hamming_weight *
     * @param x
     * @param useBuiltIn
     * @return
     */
   public static boolean isPowerOf2(int x, boolean useBuiltIn) {
        if (useBuiltIn == true) return isPowerOf2(x);
        int m1 = 0x55555555;
        int m2 = 0x33333333;
        int m4 = 0x0f0f0f0f;
        int m8 = 0x00ff00ff;
        int m16 = 0x0000ffff;
       //System.out.println(x);
        x = (x & m1) + ((x >> 1) & m1);
       //System.out.println(x);
        x = (x & m2) + ((x >> 2) & m2);
       //System.out.println(x);
       //System.out.println(Integer.toBinaryString(x)+"\n"+Integer.toBinaryString(x & m4)+"\n"+Integer.toBinaryString(x>>4)+"\n"+Integer.toBinaryString((x>>4) & m4));
       //System.out.println(x & m4);
      //System.out.println((x >> 4) & m4);
        x = (x & m4) + ((x >> 4) & m4);
       //System.out.println(x);
        x = (x & m8) + ((x >> 8) & m8);
       //System.out.println(x);
        if ( x == 1 ) return true;
        return  false;
   }
}
