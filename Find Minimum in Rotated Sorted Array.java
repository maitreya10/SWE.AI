class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (left == right) {
            return nums[left];
        }
        int mid;
        int min = nums[0];

        while (nums[left] >= nums[right]) {
            mid = left + (right - left) / 2;
            if (nums[mid] < min) {
                min = nums[mid];
            }
            if (nums[mid] >=  nums[left]) { // we are in left section, go to right section
                left = mid + 1;
                if (nums[left] <= nums[right]) {
                    break;
                }
            } else {
                right = mid - 1;
                if (nums[left] <= nums[right]) {
                    break;
                }
            }
        }
        System.out.println(nums[left]);
        if (nums[left] <= min) {
            min = nums[left];
        }
        return min;
    }
}
