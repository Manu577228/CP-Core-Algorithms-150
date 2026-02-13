/* ----------------------------------------------------------------------------  */
/*   ( The Authentic JAVA CodeBuff )
 ___ _                      _              _
 | _ ) |_  __ _ _ _ __ _ __| |_ __ ____ _ (_)
 | _ \ ' \/ _` | '_/ _` / _` \ V  V / _` || |
 |___/_||_\__,_|_| \__,_\__,_|\_/\_/\__,_|/ |
                                        |__/
 */
/* --------------------------------------------------------------------------   */
/*    Youtube: https://youtube.com/@code-with-Bharadwaj                        */
/*    Github : https://github.com/Manu577228                                  */
/*    Portfolio : https://manu-bharadwaj-portfolio.vercel.app/portfolio      */
/* -----------------------------------------------------------------------  */

import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        PrintWriter out = new PrintWriter(System.out);

        int n = 3;

        int[][] cost = {
                {9, 2, 7},
                {6, 4, 3},
                {5, 8, 1}
        };

        int size = 1 << n;

        int[] dp = new int[size];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int mask = 0; mask < size; mask++) {

            int person = Integer.bitCount(mask);

            for (int job = 0; job < n; job++) {

                if ((mask & (1 << job)) == 0) {

                    int nextMask = mask | (1 << job);

                    dp[nextMask] = Math.min(
                            dp[nextMask],
                            dp[mask] + cost[person][job]
                    );
                }
            }
        }

        out.println(dp[size - 1]);

        out.flush();
    }
}
