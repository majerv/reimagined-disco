package com.vimacodes.re;

public class TicketShop {

    int minTickets(int[] A, int k, int D) {
        int[][] DP = new int[D + 1][k + 1];

        for (int ticket : A) {
            for (int i = D; i >= 0; i--) {
                for (int j = k; j >= 0; j--) {
                    int ticketCount = DP[i][j];
                    if (ticketCount != 0) {
                        update(DP, D, k, i + ticket, j, ticketCount + 1);
                        update(DP, D, k, i + 2 * ticket, j + 1, ticketCount + 1);
                    }
                }
            }

            update(DP, D, k, ticket, 0, 1);
            update(DP, D, k, 2 * ticket, 1, 1);
        }

        return min(DP[D]);
    }

    private static void update(int[][] DP, int D, int k, int distance, int usedK, int ticketCount) {
        if (distance < 0 || distance > D || usedK > k) return;

        int currentCounter = DP[distance][usedK];
        if (currentCounter == 0 || currentCounter > ticketCount) {
            DP[distance][usedK] = ticketCount;
        }
    }

    private static int min(int[] DF) {
        int min = Integer.MAX_VALUE;
        for (int val : DF) {
            if (val != 0 ) min = Math.min(min, val);
        }
        return min;
    }
}
