class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > high) {
                high = piles[i]; 
            }
        }
        int mid = 0;
        int res= high;
        double actualHours = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            actualHours = 0;
            for (int i = 0; i < piles.length; i++) {
                actualHours = actualHours + Math.ceil((double)piles[i]/mid);
            }
            if (actualHours > h) {
                low = mid + 1;
            } else {
                res = mid;
                
                high = mid - 1;
            }
        }
        return res;
    }
}
