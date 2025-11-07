package com.vimacodes.re;

public class TicketShop {

    int minTickets(int[] A, int k, int D) {
        int n = A.length;

        int[][] DP = new int[D+1][k+1];
        for (int i = 0; i <= D; i++) {
            for (int j = 0; j <= k; j++) {
                DP[i][j] = 0;
            }
        }

        for (int t = 0; t < n; t++) {
            int ticket = A[t];

            // not in the first round
            if (t > 0) {
                int[][] newDP = copy(DP, D, k);
                for (int i = 0; i <= D; i++) {
                    for (int j = 0; j <= k; j++) {
                        int ticketCount = DP[i][j];
                        if (ticketCount != 0) {
                            update(newDP, i + ticket, j, ticketCount + 1);
                            if (j > 0) {
                                update(newDP, i + 2 * ticket, j - 1, ticketCount + 1);
                            }
                        }
                    }
                }
                DP = copy(newDP, D, k);
            }

            update(DP, ticket, k, 1);
            if (k > 0) {
                update(DP, 2 * ticket, k-1, 1);
            }
        }

        // get the minimum ticket count in the "final" distance (last row)
        return min(DP[D]);
    }

    private static void update(int[][] DP, int distance, int k, int ticketCount) {
        if (distance < 0 || distance > 20) {
            return;
        }

        int currentCounter = DP[distance][k];
        if (currentCounter == 0 || currentCounter > ticketCount) {
            DP[distance][k] = ticketCount;
        }
    }

    private static int[][] copy(int[][] DP, int D, int k) {
        int [][] newDP = new int[D+1][k+1];
        for(int i = 0; i <= D; i++){
            for (int j = 0; j <= k; j++){
                newDP[i][j] = DP[i][j];
            }
        }
        return newDP;
    }

    private static int min(int[] DF) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < DF.length; i++) {
            int val = DF[i];
            if (val !=0 && val < min) {
                min = val;
            }
        }
        return min;
    }
}
