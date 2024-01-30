class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int max = prices[right] - prices[left];
        while (right < prices.length) {
            if (prices[left] > prices[right]) {
                left = right;
            } else {
                int diff = prices[right] - prices[left];
                if (diff > max) {
                    max = diff;
                }
                right++;
            }
        }
        return max;
    }
}
