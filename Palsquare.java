/*
 ID: anika.c1
 LANG: JAVA
 TASK: palsquare
 */


import java.awt.*;
import java.util.*;
import java.io.*;

/**
 * palindromes are numbers that read the same forwards as backwards. The number 12321 is a typical palindrome.
 *
 * Given a number base B (2 <= B <= 20 base 10), print all the integers N (1 <= N <= 300 base 10) such that the square
 * of N is palindromic when expressed in base B; also print the value of that palindromic square. Use the letters
 * 'A', 'B', and so on to represent the digits 10, 11, and so on.
 *
 * Print both the number and its square in base B.
 *
 * INPUT FORMAT
 * A single line with B, the base (specified in base 10).
 * SAMPLE INPUT (file palsquare.in)
 * 10
 * OUTPUT FORMAT
 * Lines with two integers represented in base B. The first integer is the number whose square is palindromic; the
 * second integer is the square itself. NOTE WELL THAT BOTH INTEGERS ARE IN BASE B!
 * SAMPLE OUTPUT (file palsquare.out)
 * 1 1
 * 2 4
 * 3 9
 * 11 121
 * 22 484
 * 26 676
 * 101 10201
 * 111 12321
 * 121 14641
 * 202 40804
 * 212 44944
 * 264 69696
 *
 *
 *   o Use the letters 'A', 'B', and so on to represent the digits 10, 11, and so on.
 */
class Palsquare {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int base = Integer.parseInt(st.nextToken());

        int[] powers = new int[21];  //Max power the number can have without being over 300
        powers[2] = 16;
        powers[3] = 10;
        powers[4] = 8;
        powers[5] = 7;
        powers[6] = 6;
        powers[7] = 5;
        powers[8] = 5;
        powers[9] = 5;
        powers[10] = 4;
        powers[11] = 4;
        powers[12] = 4;
        powers[13] = 4;
        powers[14] = 4;
        powers[15] = 4;
        powers[16] = 4;
        powers[17] = 4;
        powers[18] = 3;
        powers[19] = 3;
        powers[20] = 3;

        int[] list = getPowers(base, powers[base]);
        int squared;
        int squareBase;
        String num1 = "";
        String num2 = "";

        for (int i = 1; i < 301; i++) { // checks if the numbers square is palindromic
            squared = i * i;
            squareBase = i;
            num1 = "";
            num2 = "";

            num1 = getBase(powers, base, list, num1, squared);
            num2 = getBase(powers, base, list, num2, squareBase);

            if (palindromeCheck(num1)) {
                out.println(num2 + " " + num1);
            }

        }

        out.close();
    }

    static int[] getPowers(int base, int maxPower){ //powers that are possible for that number
        int[] list = new int[maxPower + 1];
        list[0] = 1;
        for (int i = 1; i < maxPower + 1; i++) {
            list[i] = list[i - 1]*base;
        }
        return list;
    }

    static String getBase(int[] powers, int base, int[] list, String num, int input) { // changing the base
        boolean first = true;
        char[] letter = new char[]{'A', 'B','C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        for (int i = powers[base]; i >= 0; i--) {
            if (list[i] > input && first) {
                continue;
            }
            first = false;
            if (input/list[i] >= 10) {
                num = num + letter[(input / list[i]) % 10];
                input = input % list[i];
            } else {
                num = num + input / list[i];
                input = input % list[i];
            }
        }
        return num;
    }

    static boolean palindromeCheck(String num) { // checking if num is palindromic
        boolean palindrome = true;
        for (int i = 0, j = num.length() - 1; i < (num.length()/2); i++, j--) {
            if (num.charAt(i) != num.charAt(j)) {
                palindrome = false;
                break;
            }
        }

        return palindrome;
    }
}
