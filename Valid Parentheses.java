class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> par = new ArrayDeque<Character>(); // "ArrayDeque as Stack" is more consistent 
        for (int i = 0; i < s.length() ; i++) {
            if (par.isEmpty() && (s.charAt(i) == ']' || s.charAt(i) == ')' || s.charAt(i) == '}') ){
                return false;
            }
            if (s.charAt(i) == ']' && par.getFirst() == '[') {
                par.removeFirst();
            } else if (s.charAt(i) == '}' && par.getFirst() == '{') {
                par.removeFirst();
            } else if (s.charAt(i) == ')' && par.getFirst() == '(') {
                par.removeFirst();
            } else {
                par.addFirst(s.charAt(i));
            }
        }
        return par.isEmpty();
    }
}
