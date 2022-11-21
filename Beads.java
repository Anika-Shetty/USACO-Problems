/*
ID: anika.c1
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.StringTokenizer;

/**
 * Description:
 * You have a necklace of N red, white, or blue beads (3<=N<=350) some of which are red, others blue, and others white,
 * arranged at random. Here are two examples for n=29:
 *
 *             1 2                               1 2
 *         r b b r                           b r r b
 *       r         b                       b         b
 *      r           r                     b           r
 *     r             r                   w             r
 *    b               r                 w               w
 *   b                 b               r                 r
 *   b                 b               b                 b
 *   b                 b               r                 b
 *    r               r                 b               r
 *     b             r                   r             r
 *      b           r                     r           r
 *        r       r                         r       b
 *          r b r                             r r w
 *         Figure A                         Figure B
 *                     r red bead
 *                     b blue bead
 *                     w white bead
 *
 * The beads considered first and second in the text that follows have been marked in the picture. The configuration in
 * Figure A may be represented as a string of b’s and r’s, where b represents a blue bead and r represents a red one, as
 * follows: brbrrrbbbrrrrrbrrbbrbbbbrrrrb .
 *
 * Suppose you are to break the necklace at some point, lay it out straight, and then collect beads of the same color
 * from one end until you reach a bead of a different color, and do the same for the other end (which might not be of
 * the same color as the beads collected before this).
 *
 * Determine the point where the necklace should be broken so that the most number of beads can be collected.
 *
 * Example:
 *
 * For example, for the necklace in Figure A, 8 beads can be collected, with the breaking point either between bead 9
 * and bead 10 or else between bead 24 and bead 25.
 *
 * In some necklaces, white beads had been included as shown in Figure B above. When collecting beads, a white bead that
 * is encountered may be treated as either red or blue and then painted with the desired color. The string that
 * represents this configuration can include any of the three symbols r, b and w.
 *
 * Write a program to determine the largest number of beads that can be collected from a supplied necklace.
 *
 * PROGRAM NAME: beads
 * INPUT FORMAT
 * Line 1: N, the number of beads
 * Line 2: a string of N characters, each of which is r, b, or w
 *
 * OUTPUT FORMAT
 * A single line containing the maximum of number of beads that can be collected from the supplied necklace.
 *
 * SAMPLE INPUT (file beads.in)
 * 29
 * wwwbbrwrbrbrrbrbrwrwwrbwrwrrb
 *
 * SAMPLE OUTPUT (file beads.out)
 * 11
 *
 * OUTPUT EXPLANATION
 * Consider two copies of the beads (kind of like being able to runaround the ends). The string of 11 is marked.
 */

class Beads {
    public static void main (String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int numOfBeads = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        String necklace = st.nextToken();
        numOfBeads = necklace.length();
        char color = 'w';
        char current;
        int count = 0;
        int max = 0;
        boolean change = false;

        // Brute force
        for (int i = 0; i < numOfBeads; i++) {
            count = 0;
            color = 'w';
            change = false;
            for (int j = 0; j < numOfBeads; j++) {
                current = necklace.charAt((i + j) % numOfBeads);

                if (current != 'w') {
                    if (color != current) {
                        if (color == 'w') {
                            color = current;
                        } else {
                            if (change) {
                                break;
                            }
                            change = true;
                            color = current;
                        }
                    }
                }

                count++;

            }

            max = Math.max(max, count);

        }

        out.println(max);
        out.close();
    }
}