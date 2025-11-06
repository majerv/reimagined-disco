package com.vimacodes.re;

import java.util.Arrays;

public class SubsetSums {

    boolean isOneThreeSubsetOf(int[] A, int b) {
        int n = A.length;

        // array of remainders
        boolean[] rem = new boolean[b];
        Arrays.fill(rem, false); // can be replaced with a for loop, if no imports allowed

        for (int i = 0; i < n; i++) {
            int num = A[i];

            // not in the first round
            if (i > 0) {
                for (int j = 0; j < b; j++) {
                    // if we already have remainder 'j'
                    if (rem[j]) {
                        save(rem, j - num);
                        save(rem, j - 2 * num);
                        save(rem, j - 3 * num);
                    }
                }
            }

            // at last we save remainder with this number only, as if no other values were used
            save(rem, b - num);
            save(rem, b - 2 * num);
            save(rem, b - 3 * num);

            // if we get remainder == 0, then we're good (could be optimally checked after every save)
            if(rem[0]) {
                return true;
            }
        }

        return false;
    }

    private static void save(boolean[] rem, int index) {
        if (index < 0 /* || index >= b <- add as parameter, if we need to support '0's in A */) {
            return;
        }

        rem[index] = true;
    }

}
