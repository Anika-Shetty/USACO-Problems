/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: anika.c1
LANG: JAVA
TASK: stdin
*/
import java.io.*;
import java.util.*;

/**
 * http://www.usaco.org/index.php?page=viewproblem2&cpid=1155
 */
class LonelyPhoto {
    public static void main (String[] args) throws IOException {
        Scanner st = new Scanner(System.in);


        int length = st.nextInt();

        String cows = st.next();

        long photo = 0;

        for (int i = 0; i < length; i++) {
            long lhs = 0;
            // check if previous and current are not same
            if (i > 0 && cows.charAt(i-1) != cows.charAt(i)) {
                // index >= 1
                lhs++;
                // count how many cows on the left is the same as previous cows
                for (int k = i - 2; k >=0 && cows.charAt(k) == cows.charAt(i-1); k--) {
                    // index >= 2
                    lhs++;
                }
            }

            long rhs = 0;

            if (i + 1 < length && cows.charAt(i+1) != cows.charAt(i)) {
                rhs++;
                for (int k = i + 2; k < length && cows.charAt(k) == cows.charAt(i+1); k++) {
                    rhs++;
                }
            }
            long lhsMax = (lhs-1) > 0 ? lhs-1 : 0;
            long rhsMax = (rhs-1) > 0 ? rhs-1 : 0;
            long count = lhs * rhs + lhsMax + rhsMax;
            photo += lhs * rhs + lhsMax + rhsMax;

        }

        /*
        for (int i = 0; i < length; i++) {
            int h = 0;
            int g = 0;
            for (int j = i; j < length; j++) {
                if (cows.charAt(j) == 'H') {
                    h++;
                } else {
                    g++;
                }
                if (h + g >= 3 && (h == 1 || g == 1)) {
                    photo++;
                }
            }
        }
        */
        System.out.println(photo);


    }
}
// 21860174250
// 385337770