class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle = 30*hour + minutes/2.0 ; // (360)*hour/12 + (360/(12*60))*minutes;
        double minAngle = 6*minutes; // (360*minutes)/60;
        double diff = Math.abs(hourAngle - minAngle);

        return Math.min(diff ,360 - diff);
    }
}