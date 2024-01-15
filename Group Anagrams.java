class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        for (String s : strs) {
          char[] chars = s.toCharArray();
          Arrays.sort(chars);
          String sortedWord = new String(chars);
          if (!hm.containsKey(sortedWord)) {
              hm.put(sortedWord, new ArrayList());
              hm.get(sortedWord).add(s);
          } else {
              hm.get(sortedWord).add(s);
          }
        }
        return new ArrayList(hm.values());
    }
}
