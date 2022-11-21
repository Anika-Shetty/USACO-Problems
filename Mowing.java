/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: anika.c1
LANG: JAVA
TASK: tttt
*/
import java.io.*;
import java.util.*;

/**
 * Farmer John is quite reliable in all aspects of managing his farm, except one: he is terrible at mowing the grass in
 * a timely or logical fashion.
 * The farm is a large 2D grid of square unit cells. FJ starts in one of these cells at time t=0, mowing the grass in
 * this cell so that it is initially the only cell in which the grass is cut. FJ's remaining mowing pattern is described
 * by a sequence of N statements. For example, if the first statement is "W 10", then for times t=1 through t=10 (i.e.,
 * the next 10 units of time), FJ will step one cell to his west, mowing the grass along the way. After completing this
 * sequence of steps, he will end up 10 cells to his west at time t=10, having mowed the grass in every cell along the
 * way.
 *
 * So slow is FJ's progress that some of the grass he mows might grow back before he is finished with all his mowing.
 * Any section of grass that is cut at time t will reappear at time t+x.
 *
 * FJ's mowing pattern might have him re-visit the same cell multiple times, but he remarks that he never encounters a
 * cell in which the grass is already cut. That is, every time he visits a cell, his most recent visit to that same cell
 * must have been at least x units of time earlier, in order for the grass to have grown back.
 *
 * Please determine the maximum possible value of x so that FJ's observation remains valid.
 *
 * INPUT FORMAT (file mowing.in):
 * The first line of input contains N (1≤N≤100). Each of the remaining N lines contains a single statement and is of the
 * form 'D S', where D is a character describing a direction (N=north, E=east, S=south, W=west) and S is the number of
 * steps taken in that direction (1≤S≤10).
 *
 * OUTPUT FORMAT (file mowing.out):
 * Please determine the maximum value of x such that FJ never steps on a cell with cut grass. If FJ never visits any
 * cell more than once, please output -1.
 *
 * SAMPLE INPUT:
 * 6
 * N 10
 * E 2
 * S 3
 * W 4
 * S 5
 * E 8
 * SAMPLE OUTPUT:
 * 10
 * In this example, FJ steps on a cell at time 17 that he stepped on earlier at time 7; therefore, x must be at most 10 or else the grass from his first visit would not yet have grown back. He also steps on a cell at time 26 that he also visited at time 2; hence x must also be at most 24. Since the first of these two constraints is tighter, we see that x can be at most 10.
 */

class Mowing {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mowing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[][] field = new int[2000][2000];

        int numOfMoves = Integer.parseInt(st.nextToken());

        int x = 20000;
        int curVir = 1000;
        int curHor = 1000;
        int t = 1;

        for (int i = 0; i < numOfMoves; i++) {
            st =  new StringTokenizer(f.readLine());
            char dirc = st.nextToken().charAt(0);
            int moves = Integer.parseInt(st.nextToken());

            for (int j = 0; j < moves; j++) {
                if (dirc == 'N') {
                    if (field[curVir][curHor] != 0) {
                        x = Math.min(x, t - field[curVir][curHor]);
                    }
                    field[curVir][curHor] = t;
                    curVir--;
                    t++;
                } else if (dirc == 'E') {
                    if (field[curVir][curHor] != 0) {
                        x = Math.min(x, t - field[curVir][curHor]);
                    }
                    field[curVir][curHor] = t;
                    curHor++;
                    t++;
                } else if (dirc == 'S') {
                    if (field[curVir][curHor] != 0) {
                        x = Math.min(x, t - field[curVir][curHor]);
                    }
                    field[curVir][curHor] = t;
                    curVir++;
                    t++;
                } else if (dirc == 'W') {
                    if (field[curVir][curHor] != 0) {
                        x = Math.min(x, t - field[curVir][curHor]);
                    }
                    field[curVir][curHor] = t;
                    curHor--;
                    t++;
                }
            }
        }

        if (x == 20000) {
            out.println("-1");
        } else {
            out.println(x);
        }

        out.close();
    }
}