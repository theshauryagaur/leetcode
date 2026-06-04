class Solution {
    public int totalWaviness(int num1, int num2) {
        int totalWaves = 0;
        int innerWavesForGroup = 0; // waves from all inner digits EXCEPT the second-to-last, shared by all numbers in a x0-x9 group
        int positionInGroup = 0;    // 0 means not in a fast-path group, 1-9 means we're in one

        int i = num1;
        while (i <= num2) {
            String digits = Integer.toString(i);
            int len = digits.length();

            if (len >= 3) {
                if (positionInGroup != 0) {
                    // FAST PATH: only the second-to-last digit needs checking
                    // All other inner digits already counted in innerWavesForGroup
                    // Only the last digit changed (i incremented by 1), which can only
                    // affect whether the second-to-last digit is a peak/valley

                    char left  = digits.charAt(len - 3); // third-to-last (unchanged)
                    char mid   = digits.charAt(len - 2); // second-to-last (unchanged)
                    char right = digits.charAt(len - 1); // last digit (changed)

                    boolean midIsWave = (mid < left && mid < right) || (mid > left && mid > right);
                    if (midIsWave) totalWaves++;

                    totalWaves += innerWavesForGroup;

                    positionInGroup++;
                    if (positionInGroup == 10) {
                        // Processed x0 through x9, group is complete
                        positionInGroup = 0;
                        innerWavesForGroup = 0;
                    }

                    i++;
                    continue;
                }

                // FULL SCAN PATH: runs for every number not in an active group,
                // and for the x0 number that starts a new group

                if (i % 10 == 0) {
                    // This number starts a new x0-x9 group
                    positionInGroup = 1;
                    innerWavesForGroup = 0; // reset before scanning inner digits below
                }

                // Check all inner digits except the second-to-last (index 1 to len-3)
                // These digits won't change for the rest of the x0-x9 group
                for (int j = 1; j <= len - 3; j++) {
                    int left  = digits.charAt(j - 1) - '0';
                    int mid   = digits.charAt(j)     - '0';
                    int right = digits.charAt(j + 1) - '0';
                    boolean midIsWave = (mid < left && mid < right) || (mid > left && mid > right);
                    if (midIsWave) {
                        totalWaves++;
                        innerWavesForGroup++; // remember for the rest of the group
                    }
                }

                // Check the second-to-last digit (len-2) separately
                // This one DOES change across the group (its right neighbor, the last digit, changes)
                char left  = digits.charAt(len - 3);
                char mid   = digits.charAt(len - 2);
                char right = digits.charAt(len - 1);
                boolean secondToLastIsWave = (mid < left && mid < right) || (mid > left && mid > right);
                if (secondToLastIsWave) totalWaves++;
            }

            i++;
        }

        return totalWaves;
    }
}