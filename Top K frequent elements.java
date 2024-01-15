class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        ArrayList[] arr = new ArrayList[nums.length + 1];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : nums) {
            if (!hm.containsKey(i)) {
                hm.put(i, 1);
            } else {
                hm.put(i, (hm.get(i) + 1));
            }
        }
        for (int i : hm.keySet()) {
            if (arr[hm.get(i)] == null) {
                arr[hm.get(i)] = new ArrayList<Integer>();
                arr[hm.get(i)].add(i);
            } else {
                arr[hm.get(i)].add(i);
            }
        }
        int[] res = new int[k];
        int m = k;
        int p = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (arr[i] != null) {
                for (int j = 0; j < arr[i].size() ; j++ ) {
                    res[p] =(int) arr[i].get(j);
                    m--;
                    p++;
                    if (m == 0) {
                        break;
                    }
                }
            }
            if (m == 0) {
                break;
            }
        }
        return res;
    }
}
