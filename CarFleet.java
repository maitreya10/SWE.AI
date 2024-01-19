class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        float[] times = new float[target];
        
        for (int i = 0 ; i < position.length; i++) {
            times[position[i]] = (target - position[i]) / (float) speed[i] ;
        }
        // times[]] automatically sorted w.r.t positions.
        int ctr = 0;
        float prevFleet = 0;
        for (int i = times.length - 1 ; i >= 0; i--) {
            if ( times[i] > prevFleet ) {
             prevFleet = times[i];
             ctr++;
            }
        }
        return ctr;
    }
}
