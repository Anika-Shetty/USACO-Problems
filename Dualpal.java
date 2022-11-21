/*
 ID: anika.c1
 LANG: JAVA
 TASK: dualpal
 */

import java.io.*;
import java.util.*;

/**
 * A number that reads the same from right to left as when read from left to right is called a palindrome.
 * The number 12321 is a palindrome; the number 77778 is not. Of course, palindromes have neither leading
 * nor trailing zeroes, so 0220 is not a palindrome.
 *
 * The number 21 (base 10) is not palindrome in base 10, but the number 21 (base 10) is, in fact, a
 * palindrome in base 2 (10101).
 *
 * Write a program that reads two numbers (expressed in base 10):
 *
 * N (1 <= N <= 15)
 * S (0 < S < 10000)
 * and then finds and prints (in base 10) the first N numbers strictly greater than S that are palindromic
 * when written in two or more number bases (2 <= base <= 10).
 * Solutions to this problem do not require manipulating integers larger than the standard 32 bits.
 *
 * PROGRAM NAME: dualpal
 * INPUT FORMAT
 * A single line with space separated integers N and S.
 *
 * SAMPLE INPUT (file dualpal.in)
 * 3 25
 * OUTPUT FORMAT
 * N lines, each with a base 10 number that is palindromic when expressed in at least two of the bases 2..10.
 * The numbers should be listed in order from smallest to largest.
 * SAMPLE OUTPUT (file dualpal.out)
 * 26
 * 27
 * 28
 */

class Dualpal {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(st.nextToken()); // number of palindromes
        int s = Integer.parseInt(st.nextToken()); // number the palindromes need to be bigger than

        int palindromes = 0;
        int numbers = 0;
        String num = "";

        
        while (numbers < n) {
            s++;
            palindromes = 0;
            for (int i = 2; i < 11; i++) {
                num = getBase(s, i);

                if (palindromeCheck(num)) {
                    palindromes++;
                }

                if (palindromes == 2) {
                    out.println(s);
                    numbers++;
                    break;
                }
            }
        }

        out.close();

    }

    static String getBase(int num, int base) {
        StringBuffer sb = new StringBuffer();
        char[] letters = new char[]{'A', 'B','C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        while ( num >= 1) {
            int mod = num % base;
            if (mod >= 10) {
                sb.append(letters[mod % 10]); // telling them to use letters instead of 10, 11, ect.
            } else {
                sb.append(mod);
            }

            num = num / base;
        }
        return sb.reverse().toString();
    }

    static boolean palindromeCheck(String num) {
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
