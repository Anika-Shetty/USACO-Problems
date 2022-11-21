/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: anika.c1
LANG: JAVA
TASK: blist
*/

import java.io.*;
import java.util.*;

/**
 * See http://www.usaco.org/index.php?page=viewproblem2&cpid=856
 */

class Blist {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("blist.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int numOfCows = Integer.parseInt(st.nextToken());

        int[] startTime = new int[1001];
        int[] endTime = new int[1001];
        int maxEndTime = 0;
        int minStartTime = 1000;

        for (int i = 0; i < numOfCows; i++) {
            st = new StringTokenizer(f.readLine());
            int sTm = Integer.parseInt(st.nextToken());
            int eTm = Integer.parseInt(st.nextToken());
            int bucket = Integer.parseInt(st.nextToken());
            startTime[sTm] = bucket;
            endTime[eTm] = bucket;
            maxEndTime = Math.max(maxEndTime, eTm);
            minStartTime = Math.min(minStartTime, sTm);
        }

        int buckets = 0;
        int maxBuckets = 0;

        for (int i = minStartTime - 1; i < maxEndTime; i++) {
            if (startTime[i] != 0) {
                buckets = buckets + startTime[i];
            }

            maxBuckets = Math.max(maxBuckets, buckets);

            if (endTime[i] != 0) {
                buckets = buckets - endTime[i];
            }

        }

        out.println(maxBuckets);
        out.close();

    }

}

