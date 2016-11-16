package contests.set702;

/*
  A. Maximum Increase
  time limit per test 1 second
  memory limit per test 256 megabytes
  input standard input
  output standard output

  You are given array consisting of n integers. Your task is to find
  the maximum length of an increasing subarray of the given array.

  A subarray is the sequence of consecutive elements of the array.
  Subarray is called increasing if each element of this subarray strictly greater than previous.

  Input
  The first line contains single positive integer n (1 ≤ n ≤ 105) — the number of integers.
  The second line contains n positive integers a1, a2, ..., an (1 ≤ ai ≤ 109).

  Output
  Print the maximum length of an increasing subarray of the given array.

  Examples
  Input
  5
  1 7 2 11 15
  Output
  3
*/
/**
 * Created by hongbo on 16-11-17.
 */
public class ProblemA {
    public static void main(String[] args) {
        int length = 5;
        int[] array = {1, 7, 2, 11, 15};
        int method = 1;

        switch (method) {
            case 1:
                methodA(length,array);
                break;
            default:
                System.out.println("Choose a method.");
        }

    }

    public static void methodA(int length, int[] array) {
        int rtn = 1;
        int count = 0;
        for ( int i = 1; i < array.length; i++) {
          if ( array[i] > array[i-1] ) {
             rtn++;
          } else {
              if ( rtn > count ) count = rtn;
              rtn = 1;
          }
            System.out.println(rtn);
        }
        if ( rtn > count ) count = rtn;
        System.out.println(count);
    }
}
