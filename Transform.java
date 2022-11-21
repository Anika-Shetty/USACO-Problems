/* Use the slash-star style comments or the system won't see your
   identification information */
/*
 ID: anika.c1
 LANG: JAVA
 TASK: transform
 */

import java.util.*;
import java.io.*;

/**
 * A square pattern of size N x N (1 <= N <= 10) black and white square tiles is transformed into another square
 * pattern. Write a program that will recognize the minimum transformation that has been applied to the original
 * pattern given the following list of possible transformations:
 *
 * 90 Degree Rotation: The pattern was rotated clockwise 90 degrees.
 * 180 Degree Rotation: The pattern was rotated clockwise 180 degrees.
 * 270 Degree Rotation: The pattern was rotated clockwise 270 degrees.
 * Reflection: The pattern was reflected horizontally (turned into a mirror image of itself by reflecting around a
 * vertical line in the middle of the image).
 * Combination: The pattern was reflected horizontally and then subjected to one of the rotations (#1-#3).
 * No Change: The original pattern was not changed.
 * Invalid Transformation: The new pattern was not obtained by any of the above methods.
 * In the case that more than one transform could have been used, choose the one with the minimum number above.
 *
 * PROGRAM NAME: transform
 * INPUT FORMAT
 * Line 1:	A single integer, N
 * Line 2..N+1:	N lines of N characters (each either ‘@’ or ‘-‘); this is the square before transformation
 * Line N+2..2*N+1:	N lines of N characters (each either ‘@’ or ‘-‘); this is the square after transformation
 *
 * SAMPLE INPUT (file transform.in)
 * 3
 * @-@
 * ---
 * @@-
 * @-@
 * @--
 * --@
 *
 * OUTPUT FORMAT
 * A single line containing the number from 1 through 7 (described above) that categorizes the transformation required
 * to change from the ‘before’ representation to the ‘after’ representation.
 *
 * SAMPLE OUTPUT (file transform.out)
 * 1
 */

class Transform {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int sideLength = Integer.parseInt(st.nextToken());

        char[][] matrixS = new char[sideLength][sideLength];
        char[][] matrixE = new char[sideLength][sideLength];

        readInput(f, sideLength, matrixS);      // input ending square
        readInput(f, sideLength, matrixE);      // input starting square

        if (isTransformed(sideLength, matrixS, matrixE, 1)) {
            out.println("1");
        } else if(isTransformed(sideLength, matrixS, matrixE, 2)){
            out.println("2");
        } else if(isTransformed(sideLength, matrixS, matrixE, 3)){
            out.println("3");
        } else if(isTransformed(sideLength, matrixS, matrixE, 4)){
            out.println("4");
        } else if(isTransformed(sideLength, matrixS, matrixE, 5)){
            out.println("5");
        } else if(isTransformed(sideLength, matrixS, matrixE, 6)){
            out.println("5");
        } else if(isTransformed(sideLength, matrixS, matrixE, 7)){
            out.println("5");
        } else if(isTransformed(sideLength, matrixS, matrixE, 8)){
            out.println("6");
        } else {
            out.println("7");
        }

        out.close();

    }

    static void readInput(BufferedReader f, int sideLength, char[][] matrix) throws IOException {
        String line;
        for (int i = 0; i < sideLength; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            line = st.nextToken();
            for (int j = 0; j < sideLength; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
    }

    static boolean isTransformed(int sideLength, char matrixS[][], char matrixE[][], int type) {
        boolean match = true;
        char[][] combination = new char[sideLength][sideLength];

        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                combination[i][j] = matrixS[i][sideLength - j - 1];
            }
        }

        for (int i = 0; i < sideLength; i++) {          // checking if the transformation is #1 : 90 degree turn
            for (int j = 0; j < sideLength; j++) {
                switch (type) {
                    case 1: {
                        // checking if the transformation is #1 : 90 degree turn
                        if (matrixS[sideLength - j - 1][i] != matrixE[i][j]) {
                            match = false;
                        }
                        break;
                    }
                    case 2: {
                        // checking if the transformation is #2: 180 degree turn
                        if (matrixS[sideLength - i - 1][sideLength - j - 1] != matrixE[i][j]) {
                            match = false;
                        }
                        break;
                    }
                    case 3: {
                        // checking if the transformation is #3 : 270 degree turn
                        if (matrixS[j][sideLength - i - 1] != matrixE[i][j]) {
                            match = false;
                        }
                        break;
                    }
                    case 4: {
                        // checking if the transformation is #4 : reflection
                        if (matrixS[i][sideLength - j - 1] != matrixE[i][j]) {
                            match = false;
                        }
                        break;
                    }
                    case 5: {
                        // checking if the transformation is #5: combination: 90 degree turn & reflection
                        if (combination[sideLength - j - 1][i] != matrixE[i][j]) {
                            match = false;
                        }
                        break;
                    }
                    case 6: {
                        // checking if the transformation is #5: combination: 180 degree turn & reflection
                        if (combination[sideLength - i - 1][sideLength - j - 1] != matrixE[i][j]) {
                            match = false;
                        }
                        break;
                    }
                    case 7: {
                        // checking if the transformation is #5: combination: 270 degree turn & reflection
                        if (combination[j][sideLength - i - 1] != matrixE[i][j]) {
                            match = false;
                        }
                        break;
                    }
                    case 8: {
                        // checking if the transformation is #6 : no change
                        if (matrixS[i][j] != matrixE[i][j]) {
                            match = false;
                        }
                        break;
                    }
                }
                if (match == false) {
                    break;
                }
            }
            if (match == false) {
                break;
            }
        }
        return match;
    }

}
