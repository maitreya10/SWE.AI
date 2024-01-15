class Solution {
    public int maxArea(int[] height) {
        int width = height.length - 1;
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = 0;
            area = width * Math.min(height[left], height[right]);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
            width--;
        }
        return maxArea;
    }

}
