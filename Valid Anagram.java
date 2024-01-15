class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        String[] a = new String[s.length()];
        String[] b = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            a[i] = String.valueOf(s.charAt(i));
            b[i] = String.valueOf(t.charAt(i));
        }
        Arrays.sort(a);
        Arrays.sort(b);
        if (Arrays.equals(a,b)) {
            return true;
        } else {
            return false;
        }
    }
}
