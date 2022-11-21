/*
ID: anika.c1
LANG: JAVA
TASK: blocks
*/

import java.io.*;
import java.util.*;

/**
 * See http://usaco.org/index.php?page=viewproblem2&cpid=664
 */

class Blocks {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(st.nextToken()); // number of words
        String[][] words =  new String[n][2];
        char[] letters = new char[26];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            words[i][0] = st.nextToken();
            words[i][1] = st.nextToken();
        }

        for (int i = 0; i < n; i++) {
            int length0 = words[i][0].length();
            for (int j = 0; j < length0; j++) {
                int lengthWord = words[i][1].length();
                for (int k = 0; k < lengthWord; k++) {
                    if (words[i][0].charAt(j) == words[i][1].charAt(k)) {
                        StringBuilder sb = new StringBuilder(words[i][1]);
                        sb.deleteCharAt(k);
                        words[i][1] = sb.toString();
                        break;
                    }
                }

                letters[words[i][0].charAt(j) - 'a']++;

            }

            int length1 = words[i][1].length();

            for (int j = 0; j < length1; j++) {
                letters[words[i][1].charAt(j) - 'a']++;
            }
        }

        for(int i = 0; i < 26; i++){
            out.println(letters[i]);
        }

        out.close();
    }
}