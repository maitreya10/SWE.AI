class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if(flag == 1) {
                break;
            }
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                    flag = 1;
                    break;
                }
            }
        }
        return arr;
    }
}
