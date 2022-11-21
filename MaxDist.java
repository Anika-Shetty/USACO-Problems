import java.util.*;
import java.io.*;

//https://codeforces.com/gym/102951/problem/A
//https://usaco.guide/bronze/intro-complete?lang=java
//You are given 𝑁 (3≤𝑁≤5000) integer points on the coordinate plane. Find the square of the maximum Euclidean distance
//(aka length of the straight line) between any two of the points.
//
//Input
//The first line contains an integer 𝑁. The second line contains 𝑁 integers, the 𝑥-coordinates of the points:
// 𝑥1,𝑥2,…,𝑥𝑁 (−1000≤𝑥𝑖≤1000). The third line contains 𝑁 integers, the 𝑦-coordinates of the points: 𝑦1,𝑦2,…,𝑦𝑁 (−1000≤𝑦𝑖≤1000).
//
//Output
//Print one integer, the square of the maximum Euclidean distance between any two of the points.

class MaxDist {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("maxDist.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maxDist.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] x = new int[n];
        int[] y = new int[n];

        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++) {
            y[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int s1 = x[i] - x[j];
                int s2 = y[i] - y[j];

                int square = s1*s1 + s2*s2;

                maxLength = Integer.max(maxLength, square);
            }
        }


        out.println(maxLength);
        out.close();
    }
}