class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<Character>();
        int maxLen = 0;
        int len = 0;
        while (right < s.length() ) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
                len--;
            }
            set.add(s.charAt(right));
            right++;
            len++;
            if (len > maxLen) {
                    maxLen = len;
                }
        }
        return maxLen;
    }
}
