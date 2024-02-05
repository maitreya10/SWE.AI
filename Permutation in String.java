class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int n =s1.length();
        int m = s2.length();
        int[] freq2 = new int[26];
        for (int i = 0; i < n; i++){
            freq1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            freq2[s2.charAt(i) - 'a']++;
            if (i >= n) {
                freq2[s2.charAt(i - n) - 'a']--; // by doing this we are always the consecutive 'n' letters (window)
            } // we are doing freq2[]-- above, because freq2[s2.charAt(i - n) - 'a'] will always have 1 as the frequency, so we need to make it 0 as its part of our window.
            if (Arrays.equals(freq1, freq2)) {
                return true; // window possesses same count array as freq1 hence anagram/permutation exists!
            }
        }
        return false;
    }
}
