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
        int[] array = {1,1,1};//{7,3,2,1};
        int method = 1;

        switch (method) {
            case 1:
                methodA(num,array);
                break;
            default:
                System.out.println("Choose a method");
        }
    }

    public static void methodA(int num, int[] array) {
        //brute force
        int count = 0;
        for ( int i = 0; i < array.length-1; i++) {
            for ( int j = i+1; j < array.length;j++) {
                if ( isPower(2,array[i] + array[j]) ) {
                   count++;
                }
            }
        }
        System.out.println(count);
    }

    /**
     * determine is value the power of base or not.
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
}
