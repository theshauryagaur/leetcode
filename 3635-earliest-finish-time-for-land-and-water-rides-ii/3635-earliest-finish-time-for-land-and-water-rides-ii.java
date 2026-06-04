class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int res1 = earliest(landStartTime, landDuration, waterStartTime, waterDuration);
        int res2 = earliest(waterStartTime, waterDuration, landStartTime, landDuration);
        return Math.min(res1, res2);

    }

    private int earliest(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int[] landEnd = new int[landDuration.length];
        for (int i = 0; i < landDuration.length; i++) {
            landEnd[i] = landStartTime[i] + landDuration[i];
        }

        int landEndMin = Integer.MAX_VALUE;
        for (int i : landEnd) {
            landEndMin = Math.min(i, landEndMin);
        }

        int waterEndMin = Integer.MAX_VALUE;
        for (int i = 0; i < waterDuration.length; i++) {
            
            waterEndMin = Math.min(waterEndMin, Math.max(landEndMin, waterStartTime[i]) + waterDuration[i]);
        }
        return waterEndMin;

    }
}