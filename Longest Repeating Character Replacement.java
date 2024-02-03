// This is done by the O(26*n) method , but there is also a faster O(n) method.
class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int ans = 0;
        int i = 0; // i & j will represent the window.
        int[] arr = new int[26]; // stores frequency of alphabets of ONLY THE WINDOW
        for (int j = 0; j < s.length(); j++) {
            arr[s.charAt(j) - 'A']++;
            max = Math.max(max, arr[s.charAt(j) - 'A']);
            if ( j - i + 1 - max > k) {
                arr[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i + 1 );
        }
        return ans;
    }
}
