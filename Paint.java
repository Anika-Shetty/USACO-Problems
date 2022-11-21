/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: anika.c1
LANG: JAVA
TASK: paint
*/
import java.io.*;
import java.util.*;

//http://www.usaco.org/index.php?page=viewproblem2&cpid=567

class Paint {
    public static void main (String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("paint.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int start = Integer.min(a,c);
        int end = Integer.max(b,d);

        out.println(end-start);

        out.close();
    }
}