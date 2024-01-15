class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxL = height[left];
        int maxR = height[right];
        int totalArea = 0;
        while (left < right) {
            if (maxL < maxR) {
                left++;
                maxL = Math.max(maxL, height[left]);
                if (maxL > 0) {
                    totalArea = totalArea + (maxL - height[left]);
                }
            } else {
                right--;
                maxR = Math.max(maxR, height[right]);
                if (maxR > 0) {
                    totalArea = totalArea + maxR - height[right];
                }
            }
        }
        return totalArea;
    }
}
