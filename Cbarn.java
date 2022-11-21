/*
ID: anika.c1
LANG: JAVA
TASK: cbarn
*/

import java.io.*;
import java.util.*;

/**
 * See http://www.usaco.org/index.php?page=viewproblem2&cpid=616
 */

class Cbarn {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int numOfRooms = Integer.parseInt(st.nextToken());

        int[] cowsInRoom = new int[numOfRooms];
        int roomStart;
        int minSteps = 2147483647;

        for (int i = 0; i < numOfRooms; i++) {
            st = new StringTokenizer(f.readLine());
            cowsInRoom[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < numOfRooms; i++) {
            roomStart = i;
            int steps = 0;
            for (int j = 0; j < numOfRooms; j++) {
                steps = steps + j * cowsInRoom[roomStart % numOfRooms];
                roomStart++;
            }
            minSteps = Math.min(minSteps,steps);
        }

        out.println(minSteps);
        out.close();

    }

}