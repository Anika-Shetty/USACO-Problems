/*
ID: anika.c1
LANG: JAVA
TASK: censor
*/

/**
 * Farmer John has purchased a subscription to Good Hooveskeeping magazine for his cows, so they have plenty of material
 * to read while waiting around in the barn during milking sessions. Unfortunately, the latest issue contains a rather
 * inappropriate article on how to cook the perfect steak, which FJ would rather his cows not see (clearly, the magazine
 * is in need of better editorial oversight).
 *
 * FJ has taken all of the text from the magazine to create the string S of length at most 10^6 characters. From this,
 * he would like to remove occurrences of a substring T of length <= 100 characters to censor the inappropriate content.
 * To do this, Farmer John finds the _first_ occurrence of T in S and deletes it. He then repeats the process again,
 * deleting the first occurrence of T again, continuing until there are no more occurrences of T in S. Note that the
 * deletion of one occurrence might create a new occurrence of T that didn't exist before.
 *
 *
 * a b c d e f g a
 *
 * Please help FJ determine the final contents of S after censoring is complete.
 *
 * INPUT FORMAT: (file censor.in)
 * The first line will contain S. The second line will contain T. The length of T will be at most that of S, and all
 * characters of S and T will be lower-case alphabet characters (in the range a..z).
 *
 * OUTPUT FORMAT: (file censor.out)
 * The string S after all deletions are complete. It is guaranteed that S will not become empty during the deletion
 * process.
 *
 * SAMPLE INPUT:
 * whatthemoofun
 * moo
 *
 * 10,000,000
 * StringBuffer sb = new StringBuffer(10_000_000);
 * wh
 * SAMPLE OUTPUT:
 * whatthefun
 */

import java.io.*;

/**
 * See http://www.usaco.org/index.php?page=viewproblem2&cpid=529
 */

class Censor {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("censor.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));

        String mag = f.readLine();


        String censor = f.readLine();
        int magLength = mag.length();
        int censorLength = censor.length();

        boolean isNotCensored =  true;
        StringBuffer sb = new StringBuffer(10_000_000);
        sb.append(mag);

        for (int i = 0; i <= magLength - censorLength; i++) {
            if (sb.charAt(i) == censor.charAt(0)) {
                if (sb.substring(i, i + censorLength).equals(censor)) {
                    sb.delete(i, i + censorLength);
                    magLength = sb.length();
                    if (i - censorLength > 0) {
                        i = i - censorLength;
                    } else {
                        i = -1;
                    }
                }
            }
        }

        mag = sb.toString();

/**
        for (int k = 0; k < orMagLength/orCensorLength; k++) {
            String magOld = mag;
            magazine.append(mag);
            int magLength = mag.length();
            int censorLength = censor.length();

            int startValue = 0;
            int wordValue = 0;

            for (int i = startValue; i <= magLength - censorLength; i++) {
                if (magazine.charAt(i) == censor.charAt(0)){
                        if (magazine.substring(i, i + censorLength).equals(censor)) {
                            magazine.delete(i, i + censorLength);
                            wordValue = i;
                            magLength = magazine.length();
                        }
                }

                    for (int j = 0; j < censorLength; j++) {
                        if (mag.charAt(i + j) != censor.charAt(j)) {
                            magazine.append(mag.charAt(i));
                            break;
                        } else if (j == censorLength - 1) {
                            wordValue = i;
                            i = i+j;
                            word = false;
                        }
                    }

            }


            if (wordValue - censorLength > 0) {
                startValue = wordValue - censorLength;
            } else {
                startValue = 0;
            }

            mag = magazine.toString();

            if (magOld.equals(mag) || k == orMagLength/orCensorLength) {
                isNotCensored = false;
            }
        }
        **/
        out.println(mag);

        out.close();
    }
}