/*
 ID: anika.c1
 LANG: JAVA
 TASK: cowsignal
 */

import java.io.*;
import java.util.*;

/**
 * See http://www.usaco.org/index.php?page=viewproblem2&cpid=665
 */

class Cowsignal {
    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int m = Integer.parseInt(st.nextToken()); // Side length number 1
        int n = Integer.parseInt(st.nextToken()); // Side length number 2
        int k = Integer.parseInt(st.nextToken()); // The number of times bigger the new signal should be

        int length = n * k;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < m; i++) {
            String line = f.readLine();
            for (int j = 0; j < n; j++) {
                char letter = line.charAt(j);
                for (int l = 0; l < k; l++) {
                    sb.append(letter);
                }
            }

            for (int j = 0; j < k; j++) {
                out.println(sb);
            }

            sb.delete(0, length);
        }

        out.close();
    }
}
