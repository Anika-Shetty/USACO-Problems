/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: anika.c1
LANG: JAVA
TASK: test
*/
import java.io.*;
        import java.util.*;

/**
 * See http://www.usaco.org/index.php?page=viewproblem2&cpid=764
 */

class Shuffle {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] startPosition = new int[n];
        int[] endPosition = new int[n];

        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++) {
            startPosition[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                endPosition[j] = startPosition[array[j]- 1];
            }

            for (int j = 0; j < n; j++) {
                startPosition[j] = endPosition[j];
            }

        }
        for (int i = 0; i < n; i++) {
            out.println(startPosition[i]);
        }
        out.close();

    }
}