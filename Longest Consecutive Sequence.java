class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> hs = new HashSet<Integer>();
        for (int number : nums) {
            hs.add(number);
        }
        int lcs = 1;
        
        for (int i = 0; i < nums.length; i++) {
            int cs = 1;
            if (!hs.contains(nums[i] - 1)) {
                int tmp = nums[i];
                while (hs.contains(tmp + 1)) {
                    cs++;
                    if (cs > lcs) {
                        lcs = cs;
                        System.out.println(nums[i] + " -->" + lcs);
                    }
                    tmp++;
                }
            }
        }
        return lcs;
    }
}
