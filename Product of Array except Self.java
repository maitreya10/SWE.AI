class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] outp = new int[nums.length];
        int postfix = nums[nums.length - 1];
        outp[0] = 1;
        for (int i =1 ; i < nums.length; i++) {
            outp[i] = nums[i-1]*outp[i-1];
                
        }
        
        for (int i = nums.length - 2 ; i >= 0; i--) {
            outp[i] = postfix * outp[i];
            postfix = postfix * nums[i];
            
        }
        return outp;
    }
}
