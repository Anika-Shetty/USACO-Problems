/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: anika.c1
LANG: JAVA
TASK: speeding
*/
import java.io.*;
import java.util.*;

/**
 * See http://www.usaco.org/index.php?page=viewproblem2&cpid=568
 */

class Speeding {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int police = Integer.parseInt(st.nextToken());
        int bessy = Integer.parseInt(st.nextToken());

        int[] seg = new int[police];
        int[] mph = new int[police];

        for (int i = 0; i < police; i++) {
            st = new StringTokenizer(f.readLine());
            seg[i] = Integer.parseInt(st.nextToken());
            mph[i] = Integer.parseInt(st.nextToken());
        }

        int[] bessySeg = new int[bessy];
        int[] bessyMph = new int[bessy];

        for (int i = 0; i < bessy; i++) {
            st = new StringTokenizer(f.readLine());
            bessySeg[i] = Integer.parseInt(st.nextToken());
            bessyMph[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int bc = 0;

        int max = 0;

        while (idx != police && bc != bessy) {
            int remain = seg[idx] - bessySeg[bc];
            if (remain >= 0) {
                max = Math.max(bessyMph[bc] - mph[idx], max);
                seg[idx] = remain;
                if (remain == 0) {
                    idx++;
                }
                bc++;
            } else {
                max = Math.max(bessyMph[bc] - mph[idx], max);
                bessySeg[bc] = bessySeg[bc] - seg[idx];
                idx++;
            }
        }

        out.println(max);
        out.close();
    }
}