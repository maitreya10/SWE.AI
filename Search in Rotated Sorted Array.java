class Solution {
    public int search(int[] nums, int target) {
        int left =0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] > nums[right]) { // rotation exists
                
                if (nums[left] <= nums[mid]) { // in Left sorted section
                    if (target >= nums[left] && target <= nums[mid]) {
                        right = mid - 1;
                    } else if (target >= nums[left] && target > nums[mid]) {
                        left = mid + 1;
                    } else { // target smaller than nums[left]
                        left = mid + 1;
                    }
                } else { // in right sorted section
                    if (target > nums[right]) {
                        right = mid - 1;
                    } else if (target < nums[right] && target < nums[mid]){
                        right = mid - 1;
                    } 
                    else { // target < nums[right] but target > nums[mid]
                        left = mid + 1 ;
                    }
                }
            } else { // array left is now non rotated, do normal Binary Search
            System.out.println("im here" + left + " " + right);
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }   
        }
        if (left == right && nums[left] == target) {
            return left;
        }
        return -1;
    }
}
