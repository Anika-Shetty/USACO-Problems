/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: anika.c1
LANG: JAVA
TASK: square
*/
import java.io.*;
import java.util.*;

//http://www.usaco.org/index.php?page=viewproblem2&cpid=663

/**
 * See http://www.usaco.org/index.php?page=viewproblem2&cpid=663
 */

class Square {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("square.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        // Farmer John's 1st rectangle
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());

        // Farmer John's 2nd rectangle
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        // Smallest rectangle with both of Farmer John's rectangles
        int cx1 = Integer.min(x1, x3);
        int cy1 = Integer.min(y1, y3);
        int cx2 = Integer.max(x2, x4);
        int cy2 = Integer.max(y2, y4);

        // Side lengths of the large rectangle
        int rs1 = cx2 - cx1;
        int rs2 = cy2 - cy1;

        // The larger side length
        int s = Integer.max(rs1, rs2);

        out.print(s * s);

        out.close();
    }
}