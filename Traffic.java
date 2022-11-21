/*
ID: anika.c1
LANG: JAVA
TASK: traffic
*/

import java.io.*;
import java.util.*;

/**
 * See http://www.usaco.org/index.php?page=viewproblem2&cpid=917
 */

class Traffic {

    private static final String NONE = "none";
    private static final String ON = "on";
    private static final String OFF = "off";

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("traffic.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int highwayL = Integer.parseInt(st.nextToken());

        String[] rampType = new String[highwayL];
        int[] rangeStart = new int[highwayL];
        int[] rangeEnd = new int[highwayL];

        for (int i = 0; i < highwayL; i++) {
            st = new StringTokenizer(f.readLine());
            rampType[i] = st.nextToken();
            rangeStart[i] = Integer.parseInt(st.nextToken());
            rangeEnd[i] = Integer.parseInt(st.nextToken());
        }

        int ERS = 0;
        int ERE = 1000 ;

        for (int i = 0; i < highwayL; i++) {
            if (NONE.equals(rampType[i])){
                ERS = Math.max(ERS, rangeStart[i]);
                ERE = Math.min(ERE, rangeEnd[i]);
            } else if (ON.equals(rampType[i])) {
                ERS = ERS + rangeStart[i];
                ERE = ERE + rangeEnd[i];
            } else if (OFF.equals(rampType[i])) {
                if (ERS - rangeEnd[i] < 0){
                    ERS =  0;
                } else {
                    ERS = ERS - rangeEnd[i];
                }
                ERE = ERE - rangeStart[i];
            }
        }

        int SRS = 0;
        int SRE = 1000;

        for (int i = highwayL - 1; i >= 0; i--) {
            if (NONE.equals(rampType[i])) {
                SRS = Math.max(SRS, rangeStart[i]);
                SRE = Math.min(SRE, rangeEnd[i]);
            } else if (OFF.equals(rampType[i])) {
                SRS = SRS + rangeStart[i];
                SRE = SRE + rangeEnd[i];
            } else if (ON.equals(rampType[i])) {
                if (SRS - rangeEnd[i] < 0){
                    SRS =  0;
                } else {
                    SRS = SRS - rangeEnd[i];
                }
                SRE = SRE - rangeStart[i];
            }
        }

        out.println(SRS + " " + SRE);
        out.println(ERS + " " + ERE);
        out.close();
    }
}